package com.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class AddCustomerTest extends TestBase
{
	
	@Test
	public void  addCustomerTest() throws InterruptedException{
		
		driver.findElement(By.xpath(OR.getProperty("AddCustomer"))).click();
		driver.findElement(By.xpath(OR.getProperty("FName"))).sendKeys("Manisha");
		driver.findElement(By.xpath(OR.getProperty("LName"))).sendKeys("Gaikwad");
		driver.findElement(By.xpath(OR.getProperty("Pincode"))).sendKeys("431716");
		driver.findElement(By.xpath(OR.getProperty("Addbtn"))).click();
		
		 Thread.sleep(2000);
		
		  Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		 Thread.sleep(2000);
		   System.out.println(alert.getText());
		   //Thread.sleep(2000);
		      Assert.assertTrue(alert.getText().contains("Customer added successfully"));
			  alert.accept();
			  

	
		
	} 


}
