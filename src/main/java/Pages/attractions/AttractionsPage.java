package Pages.attractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Core.Constans;

public class AttractionsPage {

	WebDriver driver;
	WebElement nameAtt;
	WebElement rateAtt;
	WebElement cityAtt;

	public AttractionsPage(WebDriver driver) {
		this.driver = driver;
		this.nameAtt = driver.findElement(By.xpath(Constans.attName));
		this.rateAtt = driver.findElement(By.xpath(Constans.attRate));
		this.cityAtt = driver.findElement(By.xpath(Constans.attLocation));

	}

	public String getAttName() {
		return this.nameAtt.getText();
	}

	public String getAttRate() {
		return this.rateAtt.getText();
	}

	public String getAttCity() {
		return this.cityAtt.getText();
	}
}
