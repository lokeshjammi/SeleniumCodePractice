package com.demo.project;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablePractice {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.cricbuzz.com/cricket-series/3130/indian-premier-league-2020/points-table";

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
		WebElement tableComponent = driver.findElement(By.xpath("//div[@class='cb-col-67 cb-col cb-left cb-hm-rght']"));
		List<WebElement> getPoint = tableComponent.findElements(By.xpath("//td[@class='cb-srs-pnts-td text-bold']"));
		for (int i = 0; i < getPoint.size(); i++) {
			int totalOfPoints = 0;
			int sumOfAllPoints = totalOfPoints + Integer.parseInt(getPoint.get(i).getText());
			System.out.println(sumOfAllPoints);
		}
	}
}
