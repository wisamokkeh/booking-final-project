package attractionsTests;


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
import Core.WriteCsvFile;
import Pages.attractions.AttractionsPage;
import Pages.attractions.HomePageAttractions;
import Pages.attractions.ResultsPageAtt;

public class TestAttractions {

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
		List<String[]> lines = ReadCsvFile.readAllLines("inputAtt.csv");
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
		driver.get(Constans.URLAtt);
		Thread.sleep(1000);

		// select the city
		HomePageAttractions homepageatt = new HomePageAttractions(driver);
		homepageatt.Search(city, checkIn, checkOut);

		// select first result
		Thread.sleep(2000);


		ResultsPageAtt resultpageatt = new ResultsPageAtt(driver);
		resultpageatt.openFirstResult();
		Thread.sleep(5000);

		// get url result
		String currentUrl = driver.getCurrentUrl();
		Thread.sleep(5000);

		AttractionsPage attpage = new AttractionsPage(driver);
		// get att name
		String attName = attpage.getAttName();

		// get att rate
		String attRate = attpage.getAttRate();


		// get data to write in csv file
		String[] lineDetails = { currentUrl, attName, attRate, city, checkIn, checkOut };
		datas.add(lineDetails);

	}

	@AfterClass
	public void afterClass() {
		String[] headers = { "Url", "Att Name", "Att Rate", "City", "Chek In", "Chek Out" };
		WriteCsvFile.writeDataLineByLine("outputAtt.csv", datas, headers);
		driver.quit();
	}



}
