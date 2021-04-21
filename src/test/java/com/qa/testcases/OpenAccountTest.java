package com.qa.testcases;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class OpenAccountTest extends TestBase {
	
	@Test
	public void  openAccountTest( ) throws InterruptedException{
		
		driver.findElement(By.xpath(OR.getProperty("OpenAccount"))).click();
		
		WebElement custList=driver.findElement(By.xpath(OR.getProperty("Customer")));
	
		Select select=new Select(custList);
		select.selectByVisibleText("Manisha Gaikwad");

		
		driver.findElement(By.xpath(OR.getProperty("Currency"))).click();
		Select selectCurrency = new Select(driver.findElement(By.xpath(OR.getProperty("Currency"))));
		
		selectCurrency.selectByVisibleText("Rupee");
		
		
		driver.findElement(By.xpath(OR.getProperty("Process"))).click();

		 Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		
		   System.out.println(alert.getText());
		  
		      Assert.assertTrue(alert.getText().contains("Account created successfully"));
			  alert.accept();
			  

		
	}


}
