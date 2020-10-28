package com.demo.project;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderMethods {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.makemytrip.com/";

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
//		driver.findElement(By.xpath("//div[@class='minContainer']")).click();
		driver.findElement(By.xpath("//div[@class='fsw ']/div/div[3]")).click();
		Thread.sleep(2000);
	}

	public void searchForTargetMonths() {
		WebElement monthsDivision = driver.findElement(By.xpath("//div[@class='DayPicker-Months']"));
		List<WebElement> monthDivision = monthsDivision.findElements(By.xpath("//div[@class='DayPicker-Month']"));
		for (int i = 0; i < monthDivision.size(); i++) {
			if (monthDivision.get(i).getText().contains("December")) {

			}
		}
	}
}
