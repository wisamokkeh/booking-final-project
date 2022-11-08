package Pages.Hotels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Core.Constans;

public class ResultsPage {

	List<WebElement> priceResult;
	WebElement firstAddress;
	WebElement firstResult;
	WebDriver driver;

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		this.firstResult = driver.findElement(By.xpath(Constans.firstResult));
		this.firstAddress = driver.findElements(By.xpath(Constans.address)).get(0);

	}

	public void openFirstResult() throws InterruptedException {
		String url = this.firstResult.getAttribute("href");
		this.driver.get(url);
	}

	public String getFirstAddress() throws InterruptedException {
		return this.firstAddress.getText();
	}

	public int getPrice(int i) throws InterruptedException {
		this.priceResult = driver.findElements(By.xpath(Constans.price));

		String priceText = this.priceResult.get(i).getText();
		String priceValue = priceText.replace("US$", "");
		int price = Integer.parseInt(priceValue);
		return price;
	}

}
