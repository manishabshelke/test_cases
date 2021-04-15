package com.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class VerifyCustList extends TestBase { 

	@Test
	public void isCustInList() throws InterruptedException {
		driver.findElement(By.xpath(OR.getProperty("CustomerBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("Customerlist"))).sendKeys("Manisha");
		Thread.sleep(2000);
		
		String CustName=driver.findElement(By.xpath(OR.getProperty("CustomerName"))).getText();
		System.out.println(CustName);
		
		Assert.assertEquals(CustName, "Manisha", "Customer is not Prasent");
		
	}
	
	

}
