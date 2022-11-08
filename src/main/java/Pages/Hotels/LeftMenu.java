package Pages.Hotels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Core.Constans;

public class LeftMenu {

	WebElement cityName;
	WebDriver driver;

	public LeftMenu(WebDriver driver) {
		this.driver = driver;
		this.cityName = driver.findElement(By.name(Constans.search));
	}

	public String getCity() {
		return this.cityName.getAttribute("value");
	}
}
