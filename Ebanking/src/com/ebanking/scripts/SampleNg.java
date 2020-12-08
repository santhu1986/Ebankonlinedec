package com.ebanking.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleNg 
{
	WebDriver driver;
	
    @BeforeMethod
	public void Launch()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@Test
    public void google()
    {
    	driver.get("http://www.google.com");
    }
   @Test
    public void faceB() throws InterruptedException
    {
    	Thread.sleep(3000);
    	driver.get("http://www.facebook.com");
    }
   @AfterMethod
   public void Appc() throws InterruptedException
   {
   	Thread.sleep(3000);
   	driver.close();
   }
  
}
