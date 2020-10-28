package com.demo.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;

public class AssignmentTwo {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.cleartrip.com/";
	String textToEnter = "Indigo";

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
		// Adult drop-down selection
		WebElement dropdownElement = driver.findElement(By.id("Adults"));
		ISelect selectObject = new org.openqa.selenium.support.ui.Select(dropdownElement);
		selectObject.selectByIndex(3);

		// Childern Drop-down selection
		WebElement dropdownElementChild = driver.findElement(By.id("Childrens"));
		ISelect selectObjectChild = new org.openqa.selenium.support.ui.Select(dropdownElementChild);
		selectObjectChild.selectByValue("3");

		// Infants drop-down select
		WebElement dropdownElementInfant = driver.findElement(By.id("Infants"));
		ISelect selectObjectInfant = new org.openqa.selenium.support.ui.Select(dropdownElementInfant);
		selectObjectInfant.selectByVisibleText("1");

		/*
		 * Selecting current date from date-picker component
		 */
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		/*
		 * Click on more option
		 */
		driver.findElement(By.id("MoreOptionsLink")).click();

		/*
		 * Enter the prefered Airline name
		 */
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys(textToEnter);

		/*
		 * Click on Search button
		 */
		driver.findElement(By.id("SearchBtn")).click();

		/*
		 * Getting the error text
		 */
		String errorMessage = driver.findElement(By.id("homeErrorMessage")).getText();
		System.out.println(errorMessage);
		Thread.sleep(2000);
	}
}