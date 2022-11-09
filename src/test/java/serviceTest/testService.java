package serviceTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Core.Constans;
import Core.OpenBrowsers;
import Core.ReadCsvFile;
import Core.WriteCsvFile;
import Pages.Hotels.HomePage;
import Pages.service.CustmerService;
import Pages.service.DetailsPage;


public class testService {
	List<String[]> datas;
	WebDriver driver;

	@BeforeClass
	public void beforeClass() throws Exception {
		datas = new ArrayList<String[]>();
		
	}

	@DataProvider(name = "Data")
	public Object[][] getData() throws Exception {
		List<String[]> lines = ReadCsvFile.readAllLines("massege.csv");
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
	public void testSearch(String con, String pin) throws InterruptedException, IOException {
		driver = OpenBrowsers.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get(Constans.URL);
		Thread.sleep(1000);

		//click Custmer Service
		HomePage homepage = new HomePage(driver);
		homepage.openServiceCustmer();
		Thread.sleep(3000);
		//go to massege
		CustmerService servicecustmer = new CustmerService(driver);
		servicecustmer.massege();
		//write Massege
		DetailsPage detail = new DetailsPage(driver);
		detail.writeMassege(con, pin);
		driver.quit();

	}
}
