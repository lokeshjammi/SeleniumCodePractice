package com.demo.project;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners(com.demo.project.ListnerImpl.class)
public class TestNgListnerExample {
	@Test
	public void sum() {
		System.out.println("Sum of two numbers");
	}

	@Test
	public void difference() {
		System.out.println("Difference of two numbers");
	}
}
