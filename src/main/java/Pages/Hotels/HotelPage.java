package Pages.Hotels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Core.Constans;

public class HotelPage {

	WebDriver driver;
	WebElement hotelName;
	WebElement hotelRate;
	WebElement hotelCity;

	public HotelPage(WebDriver driver) {
		this.driver = driver;
		this.hotelName = driver.findElement(By.xpath(Constans.hotelName));
		this.hotelRate = driver.findElement(By.xpath(Constans.hotelRate));
		this.hotelCity = driver.findElement(By.xpath(Constans.hotelLocation));

	}

	public String getHotelName() {
		return this.hotelName.getText();
	}

	public String getHotelRate() {
		return this.hotelRate.getText();
	}

	public String getHotelCity() {
		return this.hotelCity.getText();
	}
}
