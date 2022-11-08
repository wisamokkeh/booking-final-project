package hotelTests;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Core.Constans;
import Core.OpenBrowsers;
import Core.ReadCsvFile;
import Pages.Hotels.Filter;
import Pages.Hotels.HomePage;
import Pages.Hotels.ResultsPage;

public class TestHotelWithFilter {

	List<String[]> datas;
	WebDriver driver;

	@BeforeClass
	public void beforeClass() throws Exception {
		datas = new ArrayList<String[]>();
		driver = OpenBrowsers.openBrowser("chrome");
		driver.manage().window().maximize();

	}

	@DataProvider(name = "Data")
	public Object[][] getData() throws Exception {
		List<String[]> lines = ReadCsvFile.readAllLines("input.csv");
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for (String[] line : lines) {
			data[index] = line;
			index++;
		}
		return data;
	}

	@Test(dataProvider = "Data")
	public void testSearch(String city, String checkIn, String checkOut) throws InterruptedException, IOException {
		// open website
		driver.get(Constans.URL);
		Thread.sleep(1000);
		// select the city
		HomePage homepage = new HomePage(driver);
		homepage.Search(city, checkIn, checkOut);
		Thread.sleep(2000);
		Filter filter = new Filter(driver);
		Thread.sleep(2000);
		filter.clickFilter();
		Thread.sleep(2000);

		ResultsPage resultPage = new ResultsPage(driver);
		Thread.sleep(2000);
		int price = resultPage.getPrice(1);
		assertTrue(price >= 0 && price <= 50);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
