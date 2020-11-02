package com.demo.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgDemoCheck {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.google.com";

	@BeforeMethod
	public void setUp() {
		System.out.println("This is before method");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("This is after method");
	}

	@Test
	public void test() {
		System.out.println("This is test method");
	}

	@Test(enabled = false)
	public void mobileLogin() {
		System.out.println("This is mobile login");
	}

	@Test
	public void webLogin() {
		System.out.println("This is web login");
	}

	@Test
	public void desktopLogin() {
		System.out.println("This is desktop login");
	}

	@Test
	@Parameters({ "a", "b" })
	public void sum(int a, int b) {
		int sum = a + b;
		System.out.println(sum);
	}
}