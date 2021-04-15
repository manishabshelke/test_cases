package com.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class DopositAmount extends TestBase {
	
	@Test
	public void DepositAmt()
{
	driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
	driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("500");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String msg =	driver.findElement(By.xpath("//span[normalize-space()='Deposit Successful']")).getText();
	String actualMsg ="Deposit Successful";
	Assert.assertEquals(actualMsg, msg);
	System.out.println("Amount Deposited Successful");
}

}
