package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exepom 
{
	WebDriver driver;
	
	@BeforeTest
	public void login() throws InterruptedException 
	{
	
    driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://122.175.8.158/ranford2");
	
	//PageFactory
	
	
	RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
	RHP.Login();
	
	}
	
	@Test(dataProvider="Rdata")
	public void Role(String Rname,String Rty) throws InterruptedException
	{
		
	Thread.sleep(3000);
	
	AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
	AHP.Rol();
	
	Thread.sleep(3000);
	
	RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
	RD.Nrole();
	
	Rolecreation RC=PageFactory.initElements(driver,Rolecreation.class);
	RC.Rcre(Rname,Rty);
	
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	
	Thread.sleep(3000);
	
	RD.Hom();
	Thread.sleep(3000);
	}

    
@DataProvider

public Object [][] Rdata()
{
	Object[][] Obj=new Object[3][2];
	
	Obj[0][0]="TellerFB";
	Obj[0][1]="E";
	
	Obj[1][0]="TellerBOB";
	Obj[1][1]="E";
	
	Obj[2][0]="TellerBOM";
	Obj[2][1]="E";
	
	return Obj;
	
	
	}




}