package Pages.attractions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Core.Constans;

public class ResultsPageAtt {

	List<WebElement> priceResult;
	WebElement firstAddress;
	WebElement firstResult;
	WebDriver driver;

	public ResultsPageAtt(WebDriver driver) {
		this.driver = driver;
	}

	public void openFirstResult() throws InterruptedException {
		Thread.sleep(2000);
		this.firstResult = driver.findElement(By.xpath(Constans.attFirstResultPage));
		Thread.sleep(2000);

		String url = this.firstResult.getAttribute("href");
		this.driver.get(url);
	}

	public int getPrice(int i) throws InterruptedException {
		this.priceResult = driver.findElements(By.xpath(Constans.attprice));
		String priceText = this.priceResult.get(i).getText();
		String priceValue = priceText.replace("US$", "");
		int price = Integer.parseInt(priceValue);
		return price;
	}

}
