package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactLabel;
	
	

	public  ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return(contactLabel.isDisplayed());
	}
	
	public void clickOnNewContact()
	{
		driver.findElement(By.xpath("//button[text()='New']")).click();
	}
	public void createNewContact(String firstName,String lastName)
	{
		driver.findElement(By.name("first_name")).sendKeys(firstName);
		driver.findElement(By.name("last_name")).sendKeys(lastName);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}

}
