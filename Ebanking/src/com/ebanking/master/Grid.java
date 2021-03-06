package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid 
{

	DesiredCapabilities Cap=null;
	@Parameters("browser")
	@Test
	public void Gd(String Br) throws MalformedURLException, InterruptedException 
	{
		
		if (Br.equalsIgnoreCase("firefox"))
		{
			Cap=new DesiredCapabilities();
			Cap.setBrowserName("firefox");
			Cap.setPlatform(Platform.WINDOWS);
				
		}
		
		else if (Br.equalsIgnoreCase("chrome"))
		{
			Cap=new DesiredCapabilities();
			Cap.setBrowserName("chrome");
			Cap.setPlatform(Platform.WINDOWS);
			
		}
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.106:4444/wd/hub"),Cap);

         driver.manage().window().maximize();
		
		//URL
	
		driver.get("http://122.175.8.158/ranford2");
	
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("M1ndq");
		driver.findElement(By.xpath("//input[@name='login']")).click();
	
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@src='images/Branches_but.jpg']")).click();
		driver.findElement(By.id("BtnNewBR")).click();
		
		driver.findElement(By.id("txtbName")).sendKeys("SrNagarMqsysNov");
		driver.findElement(By.id("txtAdd1")).sendKeys("SrNagar");	
		
		driver.findElement(By.id("txtZip")).sendKeys("12345");
		
		//dropdown
		Select ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
		ctry.selectByVisibleText("INDIA");
		
		new Select(driver.findElement(By.id("lst_stateI"))).selectByVisibleText("GOA");
		
		new Select(driver.findElement(By.id("lst_cityI"))).selectByVisibleText("GOA");
		
		driver.findElement(By.id("btn_insert")).click();
		
		
	
	}
}


