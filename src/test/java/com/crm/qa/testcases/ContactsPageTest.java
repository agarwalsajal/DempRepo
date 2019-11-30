package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public static String sheetName="contacts";
	public ContactsPageTest()throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactsPage=homePage.clickOnContactsLink();
	}
	
	/*@Test(priority=1)
	public void verifyContactsPageTitleTest()
	{
		boolean val=contactsPage.verifyContactsLabel();
		System.out.print(val);
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts label is missing");
	}*/
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")
	
	public void validateCreateNewContact(String firstName,String lastName)
	{
		contactsPage.clickOnNewContact();
		contactsPage.createNewContact(firstName, lastName);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}



}
