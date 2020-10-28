package com.demo.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TraversingBetweenChild {
	WebDriver driver = new ChromeDriver();
	String URL = "http://www.qaclickacademy.com/interview.php";

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
		driver.manage().window().maximize();
		// First Child Click
		driver.findElement(By.xpath("//*[@role='tablist']")).click();
		// Second Child Click
		driver.findElement(By.xpath("//*[@role='tablist']/following-sibling::[1]")).click();
	}
}
