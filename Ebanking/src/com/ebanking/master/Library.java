package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library 
{
	public static WebDriver driver;
	public static String ExpVal,Actval;
	public static FileInputStream FIS;
	public static Properties PR;
	
	public String OpenApp(String URL) throws IOException 
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\santh\\Desktop\\geckodriver.exe");
		FIS=new FileInputStream("E:\\SeleniumNovmrng\\Ebanking\\src\\com\\ebanking\\properties\\Rep.properties");
		PR=new Properties();
		PR.load(FIS);
		
		
		ExpVal="Ranford Bank";
		
		//Launch Firefox 
		
		driver=new FirefoxDriver();
		
		//maximise
		
		driver.manage().window().maximize();
		
		//URL
	
		driver.get(URL);
		
	   Actval=driver.findElement(By.xpath("//span[@class='style10'][contains(.,'Ranford Bank')]")).getText();
		
		//Comparision
		
		if (ExpVal.equalsIgnoreCase(Actval)) 
		{
			System.out.println("Ranford Application Launch");
			
		}
		else
		{
			System.out.println("Ranford Application not Launch");
			
		}
		
	 return "Ranford Opened";
	}
	
	public void AdminLgn(String Un,String Pwd) throws InterruptedException 
	{
		ExpVal="Welcome to Admin";
		
		driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
		driver.findElement(By.id(PR.getProperty("Pwd"))).sendKeys(Pwd);
		
		Thread.sleep(3000);
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
		

	}
	
	public void BranchCre() throws InterruptedException 
	{
ExpVal="Sucessfully";
		
		Thread.sleep(4000);
		driver.findElement(By.xpath(PR.getProperty("Bbutton"))).click();
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
		driver.switchTo().alert().accept();
		
		 driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
		//Comaprision
		
		if (Actval.contains(ExpVal))
		{
			System.out.println("Branch Created");
		}
		else
		{
			System.out.println("Branch Already Exist");
		}
		
	
	}
	public String Role(String RN,String RT) throws InterruptedException
	{
		ExpVal="Sucessfully";
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
		driver.findElement(By.id("txtRname")).sendKeys(RN);
		driver.findElement(By.id("lstRtypeN")).click();
		driver.findElement(By.id("lstRtypeN")).sendKeys(RT);
		driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
		Thread.sleep(4000);
		String Actval=driver.switchTo().alert().getText();
		
		System.out.println(Actval);
		
		
	      driver.switchTo().alert().accept();
	      driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
	      if (Actval.contains(ExpVal)) 
	      {
	    	  System.out.println("Role Created");
	    	  
			
		}
	      else{
	    	  System.out.println("role not created");
	    	  
	      }
	      return Actval;
	     }

	//Logout
    public void admlgt()

{
	 driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
	 
	 }

//Close
   public void Appc()
{
	 driver.close();
}


	
	
	
	//Role
	//Employee
	//Log out
	//Close
}
