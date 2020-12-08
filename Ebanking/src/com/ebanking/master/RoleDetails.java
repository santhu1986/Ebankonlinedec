package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoleDetails 
{

	//Element Properties
	
	@FindBy(id="btnRoles")
	WebElement NewRole;
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement Home;
	
	//Element Methods
	
	public void Nrole() 
	{
	NewRole.click();	
	}
	
	public void Hom()
	{
	Home.click();	
	}
}
