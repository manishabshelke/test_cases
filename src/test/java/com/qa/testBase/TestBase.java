package com.qa.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties config= new Properties();                                
	public static Properties OR= new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;



	@BeforeSuite 
	public void setUp() throws IOException {
		
		
		if(driver==null) {
			 
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\qa\\properties\\Config.properties");
			config.load(fis);
		
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\qa\\properties\\OR.properties");
			OR.load(fis);
			
			
			
			if(config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();
				
			}else
				if(config.getProperty("browser").equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					
					
			}
			
			driver.get(config.getProperty("testsiteurl"));
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
			wait= new WebDriverWait(driver,10);

			} 
		}
		
		
		  @AfterSuite public void tearDown() { 
			  if(driver!=null) {
				  driver.quit();
		  }
		  
		  }
		 	
			
	
		
//}
		
		
		public boolean isPresent(By by) {
			
			try {
				driver.findElement(by);
				return true;
			}catch(NoSuchElementException e) {
				
				return false;
				
			}
			
		}
}
	

	

