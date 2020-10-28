package com.demo.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionCheck {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.amazon.in/";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(URL);
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList")))
				.click(driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a"))).build().perform();
		// WebDriverWait w = new WebDriverWait(driver, 5);
		driver.navigate().back();
		/*
		 * Cick on search button and type something in CAPS
		 */
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Alexa")
				.doubleClick().build().perform();
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).contextClick().build().perform();
		Thread.sleep(2000);
	}
}
