package com.demo.project;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingToCart {
	WebDriver driver = new ChromeDriver();
	String URL = "https://rahulshettyacademy.com/seleniumPractise";

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
		String[] productsNeeded = { "Brocolli", "Carrot", "Beans" };
		List<String> productsNeededList = Arrays.asList(productsNeeded);
		List<WebElement> productNames = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < productNames.size(); i++) {
			String productName = productNames.get(i).getText();
			if (productName.contains("Cucumber")) {
				List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
				buttons.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}
	}
}