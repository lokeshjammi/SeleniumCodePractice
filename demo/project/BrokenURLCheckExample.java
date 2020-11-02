package com.demo.project;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenURLCheckExample {
	WebDriver driver = new ChromeDriver();
	String URL = "https://rahulshettyacademy.com/AutomationPractice/";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void test() throws MalformedURLException, IOException {
		driver.get(URL);
		driver.manage().window().maximize();
		WebElement footerElement = driver.findElement(By.id("gf-BIG"));
		List<WebElement> anchor = footerElement.findElements(By.tagName("a"));
		System.out.println(anchor);
		for (int i = 0; i < anchor.size(); i++) {
			String anchorURL = anchor.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new java.net.URL(anchorURL).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			if (responseCode > 400) {
				System.out.println("This is broken link:" + anchor.get(i).getText());
			}
		}
	}
}