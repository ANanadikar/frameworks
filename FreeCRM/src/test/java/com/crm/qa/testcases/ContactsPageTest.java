package com.crm.qa.testcases;

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

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;

	String sheetName = "contacts";

	@BeforeMethod
	public void SetUP() {

		initialization();
		loginPage = new LoginPage();
		testutil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),
				prop.getProperty("password"));
		testutil.switchtoFrame();
		contactsPage = homePage.clickoncontactLink();

	}

	@Test(priority = 1)
	public void verifcontactspagelabel() {

		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");

	}

	@DataProvider
	public Object[][] getTestData() {

		Object data[][] = testutil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 2, dataProvider = "getTestData")
	public void validteCreateNewContact(String title, String firstName,String lastName, String company) {

		homePage.clickonNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
		
		System.out.println("this is git update");

	}

	 @AfterMethod
	public void teardown() {

		driver.quit();
	}

}
