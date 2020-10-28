package com.demo.project;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllTabsTitle {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.rahulshettyacademy.com/AutomationPractice/";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedrive.exe");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(URL);
		// Count of a in the website
		System.out.println(driver.findElements(By.tagName("a")).size());
		// Getting count of a in footer
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		// Getting a count in footer column
		WebElement footerColumnDrive = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int linksCount = footerColumnDrive.findElements(By.tagName("a")).size();
		// Clicking the links in column
		for (int i = 1; i < linksCount; i++) {
			String keysAction = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerColumnDrive.findElements(By.tagName("a")).get(i).sendKeys(keysAction);
		}
		List<String> openedTabId = new ArrayList<String>(driver.getWindowHandles());
		for (int i = 0; i < openedTabId.size(); i++) {
			driver.switchTo().window(openedTabId.get(i));
			System.out.println(driver.getTitle());
		}
	}
}
