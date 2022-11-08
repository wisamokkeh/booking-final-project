package Pages.Hotels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Core.Constans;

public class Filter {
	WebElement price50;
	WebDriver driver;

	public Filter(WebDriver driver) {
		this.driver = driver;
	}

	public void clickFilter() throws InterruptedException {
		// this.price50 = driver.findElement(By.xpath(Constans.priceFilter));
		// Thread.sleep(10000);
		// this.price50.click();
		// Thread.sleep(5000);

		this.price50 = driver.findElement(By.xpath(Constans.priceFilter));
		Actions actions = new Actions(driver);
		actions.moveToElement(price50).click().build().perform();
	}

}
