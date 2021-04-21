package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class CustomerLogin extends TestBase{
	
	@Test
	public void CustloginApp() throws Throwable
	{
		driver.findElement(By.xpath(OR.getProperty("HomeBtn"))).click();
		
		driver.findElement(By.xpath("//button[text()='Customer Login']")).click();
		
		WebElement 	dropdown	=driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid']"));
		Select select=new Select(dropdown);
		select.selectByVisibleText("Harry Potter");
		driver.findElement(RelativeLocator.withTagName("button").below(By.xpath("//div[@class='form-group']"))).click();
		//Thread.sleep(3000);
		String  expected = driver.findElement(By.xpath("//span[contains(text(),'Harry Potter')]")).getText();
		String actual="Harry Potter";	
		Assert.assertEquals(actual, expected);
		System.out.println("Customer Successfuly Logined Application");
	
	}

}
