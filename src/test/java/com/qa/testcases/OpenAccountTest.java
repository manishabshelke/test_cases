package com.qa.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class OpenAccountTest extends TestBase {
	
	@Test
	public void  openAccountTest(String customer, String currency ) throws InterruptedException{
		driver.findElement(By.xpath(OR.getProperty("BankManagerLogin"))).click();
		
		Thread.sleep(1000);

		
	}


}
