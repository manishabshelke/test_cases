package com.qa.testcases;

import org.openqa.selenium.By;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class BankManagerLoginTest extends TestBase{

	
	@Test
	public void bankManagerLoginTest() throws InterruptedException {
		
	driver.findElement(withTagName("button").below(By.xpath("//button[text()='Customer Login']"))).click();
	

	//driver.findElement(By.xpath(OR.getProperty("AddCustomer"))).click();
	boolean isAddCustomerbtn=isPresent(withTagName("button").toRightOf(By.xpath(OR.getProperty("OpenAccount"))));
		Assert.assertTrue(isAddCustomerbtn);
;
		
	}


}
