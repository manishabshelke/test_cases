package com.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class AddCustomerTest extends TestBase
{
	
	@Test
	public void  addCustomerTest(String fristName, String lastName, int postCode) throws InterruptedException{
		
		if(!data.get("Runmode").equalsIgnoreCase("Y")) {
			
			throw new SkipException("Skipping the test as the runmode is no");
		}
		click("addcustbtn_CSS");
		type("fristname_CSS", data.get("fristName"));
		type("lastname_CSS",data.get("lastName"));
		type("postCode_CSS",data.get("postCode"));
		click("addbtn_CSS");
		Thread.sleep(2000);
		
	   Alert alert= wait.until(ExpectedConditions.alertIsPresent());
      Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
	  alert.accept();
       Thread.sleep(2000);
	
	
		
	} 


}
