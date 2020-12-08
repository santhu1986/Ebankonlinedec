package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Rolecreation 
{

	@FindBy(id="txtRname")
	WebElement Rolename;
	
	@FindBy(id="lstRtypeN")
	WebElement Roletype;
	
	@FindBy(xpath="//*[@id=\"btninsert\"]")
	WebElement Rsub;
	
	public void Rcre(String Rn,String Rt) throws InterruptedException 
	{
	Rolename.sendKeys(Rn);
	Select RT=new Select(Roletype);
	RT.selectByVisibleText(Rt);
	Thread.sleep(3000);
	Rsub.click();
	
	}
}
