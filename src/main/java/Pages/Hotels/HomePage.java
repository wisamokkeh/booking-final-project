package Pages.Hotels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Core.Constans;

public class HomePage {

	WebDriver driver;
	WebElement cityName;
	WebElement checkinDateClick;
	WebElement btnDateChoice;
	WebElement btnClear;
	JavascriptExecutor js;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.cityName = driver.findElement(By.name(Constans.search));
		this.checkinDateClick = driver.findElement(By.xpath(Constans.checkinDateClick));
		this.btnDateChoice = driver.findElement(By.xpath(Constans.btnClickDate));
		try {
			Thread.sleep(2000);
			this.btnClear = driver.findElement(By.xpath(Constans.btnClearCity));
			this.btnClear.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.js = (JavascriptExecutor) driver;

	}

	public void Search(String search, String checkIn, String checkOut) throws InterruptedException {

		this.cityName.sendKeys(search);
		this.checkinDateClick.click();
		js.executeScript("document.querySelector('[data-date=\"" + checkIn + "\"]').click();");
		js.executeScript("document.querySelector('[data-date=\"" + checkOut + "\"]').click();");
		this.btnDateChoice.click();
	}
}
