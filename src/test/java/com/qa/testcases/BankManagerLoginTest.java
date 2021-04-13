package com.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class BankManagerLoginTest extends TestBase{

	
	@Test
	public void bankManagerLoginTest() throws InterruptedException {
		
	driver.findElement(By.xpath(OR.getProperty("BankManagerLogin"))).click();
	
	Thread.sleep(2000);
	//driver.findElement(By.xpath(OR.getProperty("AddCustomer"))).click();
	boolean isAddCustomerbtn=isPresent(By.xpath(OR.getProperty("AddCustomer")));
		Assert.assertTrue(isAddCustomerbtn);
		Thread.sleep(3000);
		
	
		
	
	}


}
