package Pages.attractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Core.Constans;

public class FilterAtt {
	WebElement price21;
	WebDriver driver;

	public FilterAtt(WebDriver driver) {
		this.driver = driver;
	}

	public void clickFilter() throws InterruptedException {

		this.price21 = driver.findElement(By.xpath(Constans.attPriceFilter));
		Actions actions = new Actions(driver);
		actions.moveToElement(price21).click().build().perform();
	}

}
