package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
@FindBy(xpath="//span[text()='Sajal K']")
WebElement userNameLabel;

@FindBy(xpath="//a//span[text()='Contacts']")
//for storing value temporarily we create cache lookup.It increases the speed when we have to perform same operations again and again

@CacheLookup
WebElement contacts; 

@FindBy(xpath="//a//span[text()='Deals']")
WebElement deals; 



public HomePage()
{
	PageFactory.initElements(driver,this);
}

public String verifyHomePageTitle()
{
	return driver.getTitle();
}
public boolean verifyCorrectUserName()
{
	return(userNameLabel.isDisplayed());
}

public ContactsPage clickOnContactsLink()
{
	contacts.click();
	return new ContactsPage();
}

public DealsPage clickOnDealsLink()
{
	deals.click();
	return new DealsPage();
}

}
