package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public HomePageTest()throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Cogmento CRM","Home page title not matched");
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	@Test(priority=3)
	public void verifyContactsLinkPage()
	{
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
