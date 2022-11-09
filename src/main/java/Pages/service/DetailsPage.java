package Pages.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Core.Constans;

public class DetailsPage {

	WebDriver driver;
	WebElement confNum;
	WebElement pin;
	WebElement next;

	public DetailsPage(WebDriver driver) {
		this.driver = driver;
		
	}

	public void writeMassege(String conf , String pinn) throws InterruptedException {
		Thread.sleep(3000);
		this.confNum = driver.findElement(By.name(Constans.confirmation));
		this.pin = driver.findElement(By.name(Constans.pinNum));
		this.confNum.sendKeys(conf);
		Thread.sleep(3000);
		this.pin.sendKeys(pinn);
		Thread.sleep(3000);
		this.next = driver.findElement(By.xpath(Constans.nextBtn));
		Thread.sleep(3000);
		this.next.click();
	}
}
