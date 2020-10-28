package com.demo.project;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuggestDropDownCheck {
	WebDriver driver = new ChromeDriver();
	String URL = "https://rahulshettyacademy.com/dropdownsPractise/";

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
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		System.out.println(options);
		for (int i = 1; i <= options.size(); i++) {
			WebElement option = options.get(i);
			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				// driver.findElement(By.cssSelector("a[id='ui-id-157']")).click();
				Thread.sleep(2000);
			}
		}
	}
}
