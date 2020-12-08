package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RanfordHP 
{

	//Element Properties
	
	@FindBy(id="txtuId")
	WebElement Uname;
	
	@FindBy(id="txtPword")
	WebElement Pwd;
	
	@FindBy(xpath="//*[@id=\"login\"]")
	WebElement Lgn;
	
	//Element Methods
	
	public void Login() 
	{
	Uname.sendKeys("Admin");
	Pwd.sendKeys("M1ndq");
	Lgn.click();
	}
	
}
