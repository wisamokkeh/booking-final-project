package Pages.service;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Core.Constans;

public class CustmerService {

	WebDriver driver;
	WebElement noSignIn;

	public CustmerService(WebDriver driver) {
		this.driver = driver;
		this.noSignIn = driver.findElement(By.xpath(Constans.contWithoutSignIn));


	}

	public void massege() throws InterruptedException {
		Thread.sleep(3000);
		this.noSignIn.click();
		
	}
}
