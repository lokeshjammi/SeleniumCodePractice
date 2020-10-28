package com.demo.project;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class First {

	WebDriver driver = new ChromeDriver();
	String URL = "https://www.google.com";

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void test() {
		System.out.println("Test Method Executed");
	}

	@Test
	public void searchInGoogle() {
//		driver.findElement(By.name("q")).sendKeys("Javatpoint");
		System.out.println("Search In Google method Executed");
	}
}