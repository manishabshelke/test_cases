package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class OpenAccountTest extends TestBase {
	
	@Test
	public void  openAccountTest(Hashtable<String,String>data) throws InterruptedException{
		click("openacc_CSS");
		select("customer_CSS", data.get("customer"));
		Thread.sleep(1000);
		select("currency_CSS", data.get("currency"));
		Thread.sleep(1000);
		click("process_CSS");
		Thread.sleep(2000);
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
			//Assert.assertTrue(alert.getText().contains(alerttext));
			
		alert.accept();
		
	}


}
