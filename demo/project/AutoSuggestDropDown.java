package com.demo.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggestDropDown {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.cleartrip.com/";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}

	@After
	public void tearDown() {
		driver.close();
	}

//	@Test
//	public void test() {
//		driver.get(URL);
//		driver.manage().window().maximize();
//		driver.findElement(By.id("FromTag")).click();
//		driver.findElement(By.id("FromTag")).sendKeys("Mum");
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//		driver.findElement(By.id("FromTag")).sendKeys(Keys.ENTER);
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//	}

	@Test
	public void testMakeMyTrip() throws InterruptedException {
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='fsw_inner ']/div[1]")).click();
		Actions a = new Actions(driver);
		WebElement searchTextBox = driver
				.findElement(By.xpath("//*[@class='react-autosuggest__input react-autosuggest__input--open']"));
		a.moveToElement(searchTextBox).click();
		// .sendKeys("Chen").sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);
	}
}
