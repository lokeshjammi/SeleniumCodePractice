package com.demo.project;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.gmail.com/";

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
		driver.findElement(By.xpath("//a[text()='Help']")).click();
		List<String> windowIds = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowIds.get(1));
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowIds.get(0));
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
