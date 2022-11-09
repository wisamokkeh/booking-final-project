package Pages.attractions;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Core.Constans;

public class HomePageAttractions {

	WebDriver driver;
	WebElement attCity;
	WebElement checkinDateClick;
	WebElement firstAtt;
	WebElement btnDateChoice;
	WebElement btnClear;
	JavascriptExecutor js;

	public HomePageAttractions(WebDriver driver) {
		this.driver = driver;
		this.attCity = driver.findElement(By.name(Constans.cityAtt));
		this.checkinDateClick = driver.findElement(By.xpath(Constans.attDateClick));
		this.btnDateChoice = driver.findElement(By.xpath(Constans.attBtnClickDate));
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

		this.checkinDateClick.click();
		js.executeScript("document.querySelector('[data-date=\"" + checkIn + "\"]').click();");
		js.executeScript("document.querySelector('[data-date=\"" + checkOut + "\"]').click();");
		this.attCity.sendKeys(search);
		Thread.sleep(5000);
		this.firstAtt = driver.findElement(By.xpath(Constans.attFirstResult));
		this.firstAtt.click();
		Thread.sleep(5000);
		this.btnDateChoice.click();
	}
}
