package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePagetest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;

	@BeforeMethod
	public void SetUP() {

		initialization();
		loginPage = new LoginPage();
		testutil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

	}

	
	@Test(priority=1)
	
	public void verifyHomePageTitleTest(){
		
		String homePageTitle=homePage.verifyhomepageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page title not matched ");
		
	}
	
	@Test(priority=2)
	
	public void verifyusernameTest(){
		testutil.switchtoFrame();
		Assert.assertTrue(homePage.verifycorrectuserName());
		
	}
	
	@Test(priority=3)
	public void verifycontactsLinkTest(){
		testutil.switchtoFrame();
		contactsPage=homePage.clickoncontactLink();
		
	}
	
	
	@AfterMethod
	
	public void teardown(){
		
		driver.quit();
	}
}
