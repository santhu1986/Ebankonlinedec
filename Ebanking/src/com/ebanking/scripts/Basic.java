package com.ebanking.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Basic {

	public static void main(String[] args) throws InterruptedException 
	{
		String ExpVal="Ranford Bank";
	
		//Launch Firefox 
		
		WebDriver driver=new ChromeDriver();
		
		//maximise
		
		driver.manage().window().maximize();
		
		//URL
	
		driver.get("http://122.175.8.158/ranford2");
		
		String Actval=driver.findElement(By.xpath("//span[@class='style10'][contains(.,'Ranford Bank')]")).getText();
		
		//Comparision
		
		if (ExpVal.equalsIgnoreCase(Actval)) 
		{
			System.out.println("Ranford Application Launch");
		}
		else
		{
			System.out.println("Ranford Application not Launch");
		}
		
		//Get Title
		
		String Tit=driver.getTitle();
		System.out.println(Tit);
		
		//Admin Login
		
		ExpVal="Welcome to Admin";
				
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("M1ndq");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		
		//Comparision
		

		if (ExpVal.equalsIgnoreCase(Actval)) 
		{
			System.out.println("Admin Login Succ");
		}
		else
		{
			System.out.println("Admin Login Failed");
		}
		
        
		//Branch Creation
		
		ExpVal="Sucessfully";
		
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
		
		//Alert
		
		Actval=driver.switchTo().alert().getText();
		
		//Comaprision
		
		if (Actval.contains(ExpVal))
		{
			System.out.println("Branch Created");
		}
		else
		{
			System.out.println("Branch Already Exist");
		}
		
		
		
        //Role Creation
		//Employee Creation
	    //Banker Login
	
	
}
}