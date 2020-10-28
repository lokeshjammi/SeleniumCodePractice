package com.demo.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;

public class StaticDropDownCheck {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.spicejet.com/";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void test() {
		driver.get(URL);
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']"));
		ISelect adultDropDown = new org.openqa.selenium.support.ui.Select(dropdownElement);
		adultDropDown.selectByValue("2");
		adultDropDown.selectByIndex(3);
		adultDropDown.selectByVisibleText("6");
	}
}
