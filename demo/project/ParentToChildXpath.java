package com.demo.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentToChildXpath {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.google.com";

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
		driver.findElement(By.xpath("//div[@id='gbw']/div/div/div[1]/div[1]/a")).click();
	}
}
