package com.demo.project;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotDemoCheck {
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
	public void test() throws IOException {
		driver.get(URL);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D://Selenium.jpg"));
	}
}
