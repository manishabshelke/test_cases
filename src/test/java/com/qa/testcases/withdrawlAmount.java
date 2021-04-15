package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class withdrawlAmount extends TestBase{
	
	@Test
	public void withdrawlAmt() throws InterruptedException
	{	
		try {
	
		driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("300");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2500);
		  String actual =driver.findElement(By.xpath("//span[normalize-space()='Transaction successful']")).getText();
		  Thread.sleep(2500);
		  String expt="Transaction successful";
		  Assert.assertEquals(actual, expt);
	}catch(StaleElementReferenceException e){	
	}
	}

}
