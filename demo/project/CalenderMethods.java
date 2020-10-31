package com.demo.project;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderMethods {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.makemytrip.com/";

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
		driver.findElement(By.xpath("//div[@class='fsw ']/div/div[3]")).click();
		searchForTargetMonths();
	}

	public void searchForTargetMonths() throws InterruptedException {
		WebElement monthsDivision = driver.findElement(By.xpath("//div[@class='DayPicker-Months']"));
		List<WebElement> monthDivision = monthsDivision.findElements(By.xpath("//div[@class='DayPicker-Month']"));
		WebElement firstMonthDivision = monthsDivision.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]"));
		WebElement secondMonth = monthsDivision.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]"));
		while (!(firstMonthDivision.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText()
				.contains("December"))) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		if (firstMonthDivision.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText()
				.contains("December")) {
			List<WebElement> calenderDates = firstMonthDivision
					.findElements(By.xpath("//div[@class='DayPicker-Day']/div/p[1]"));
			for (int i = 0; i < calenderDates.size(); i++) {
				String date = calenderDates.get(i).getText();
				if (date.contains("19")) {
					firstMonthDivision
							.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[3]/div[3]/div[7]"))
							.click();
					break;
				}
			}
		}
	}
}
