package com.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;


public class LogOutCustomer extends TestBase {
	
	@Test
	public void logoutApp()
	{
		driver.findElement(By.xpath("//button[normalize-space()='Logout']")).click();
		String   expect  =	driver.findElement(By.xpath("//strong[normalize-space()='XYZ Bank']")).getText();
		String actual="XYZ Bank";
		Assert.assertEquals(expect, actual);
		System.out.println("Successfuly Logout the application");

	}
	}
