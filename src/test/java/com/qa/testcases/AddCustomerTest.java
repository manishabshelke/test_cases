package com.qa.testcases;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

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

		//driver.findElement(withTagName("button").below(By.xpath("//button[text()='Customer Login']"))).click();
		
		driver.findElement(By.xpath("//button[@ng-click='addCust()']")).click();
		Thread.sleep(1000);
		driver.findElement(withTagName("input").above(By.xpath(OR.getProperty("LName")))).sendKeys("Manisha");
		driver.findElement(By.xpath(OR.getProperty("LName"))).sendKeys("Gaikwad");
		driver.findElement(withTagName("input").below(By.xpath(OR.getProperty("LName")))).sendKeys("431716");
		driver.findElement(By.xpath(OR.getProperty("Addbtn"))).click();

		
		  Alert alert= wait.until(ExpectedConditions.alertIsPresent());
	
		   System.out.println(alert.getText());
	
		      Assert.assertTrue(alert.getText().contains("Customer added successfully"));
			  alert.accept();
			  

	
		
	} 


}
