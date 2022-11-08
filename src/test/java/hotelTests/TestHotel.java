package hotelTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Core.Constans;
import Core.OpenBrowsers;
import Core.ReadCsvFile;
import Core.WriteCsvFile;
import Pages.Hotels.HomePage;
import Pages.Hotels.HotelPage;
import Pages.Hotels.LeftMenu;
import Pages.Hotels.ResultsPage;
import io.qameta.allure.Allure;

public class TestHotel {

	List<String[]> datas;
	WebDriver driver;

	@BeforeClass
	public void beforeClass() throws Exception {
		datas = new ArrayList<String[]>();
		driver = OpenBrowsers.openBrowser("chrome");
		driver.manage().window().maximize();


	}

	@DataProvider(name = "Data")
	public Object[][] getData() throws Exception{
		List<String[]> lines = ReadCsvFile.readAllLines("input.csv");
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for(String[] line : lines) {
			data[index] = line;
			index++;
		}
		return data;
	}

	@Test(dataProvider = "Data")
	public void testSearch(String city, String checkIn, String checkOut) throws InterruptedException, IOException {
		//open website
		driver.get(Constans.URL);
		Thread.sleep(1000);

		//select the city
		HomePage homepage = new HomePage(driver);
		homepage.Search(city , checkIn , checkOut);



		//Screenshot
		TestHotel.attachImgToAllure(driver, "img1.png");



		//select first result
		Thread.sleep(2000);


		//assert city
		LeftMenu leftmenu = new LeftMenu(driver);
		String cityResult = leftmenu.getCity();
		assertEquals(cityResult.toLowerCase(), city.toLowerCase());

		ResultsPage resultpage = new ResultsPage(driver);

		//assert results with city
		String cityInResult = resultpage.getFirstAddress();
		assertTrue(cityInResult.toLowerCase().contains(city.toLowerCase()));


		resultpage.openFirstResult();


		Thread.sleep(5000);

		//get url result
		String currentUrl = driver.getCurrentUrl();
		Thread.sleep(5000);

		HotelPage hotelPage = new HotelPage(driver);
		//get hotel name
		String hotelName = hotelPage.getHotelName();

		//get hotel rate
		String hotelRate =hotelPage.getHotelRate();

		//get hotel city
		String hotelCity = hotelPage.getHotelCity();
		assertTrue(hotelCity.toLowerCase().contains(city.toLowerCase()));

//		assertTrue(price>=0 && price<=50);
//		String ii = "5";
//		int i = Integer.parseInt(ii);

		//Screenshot
		TestHotel.attachImgToAllure(driver, "img2.png");


		//get data to write in csv file
		String[] lineDetails = {currentUrl,hotelName,hotelRate, city , checkIn , checkOut};
		datas.add(lineDetails);

	}

	@AfterClass
	public void afterClass() {
		String[] headers = {"Url", "Hotel Name", "Hotel Rate" , "City" , "Chek In" , "Chek Out"};
		WriteCsvFile.writeDataLineByLine("output.csv", datas, headers);
		driver.quit();
	}

	public static void attachImgToAllure(WebDriver driver , String fileName) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileName);
		FileUtils.copyFile(SrcFile, DestFile);
		Allure.addAttachment("Screenshot", FileUtils.openInputStream(SrcFile));
	}
}


