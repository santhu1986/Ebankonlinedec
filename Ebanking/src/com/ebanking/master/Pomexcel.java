package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Pomexcel 
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
	
	@Test()
	public void Role() throws InterruptedException, IOException
	{
		
		
		//To get Test data File
		
				FileInputStream Fis=new FileInputStream("E:\\SeleniumNovmrng\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
				
				//WorkBook
				
				XSSFWorkbook WB=new XSSFWorkbook(Fis);
				
				//Sheet
				
				XSSFSheet WS=WB.getSheet("Rdata");
				
				//Row Count
				
				int Rcount=WS.getLastRowNum();
				System.out.println(Rcount);
				
				//Multiple Iterations --  FOR LOOP
				
				for (int i=1;i<=Rcount;i++) 
				{
			
					//Row
					
					XSSFRow WR=WS.getRow(i);
					
					//Cells
					
					XSSFCell WC=WR.getCell(0);
					XSSFCell WC1=WR.getCell(1);
					
					XSSFCell WC2=WR.createCell(2);
					
					//Cell Values
					
					String Rname=WC.getStringCellValue();
				    String Rty=WC1.getStringCellValue();
				    
			
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


}
}