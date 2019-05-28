package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Avadhoot')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement NewContactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement TasksLink;

	// initialising page objects
	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public String verifyhomepageTitle() {

		return driver.getTitle();
	}

	public boolean verifycorrectuserName(){
		return userNameLabel.isDisplayed();
		 
		
	}
	
	public ContactsPage clickoncontactLink() {

		
		ContactsLink.click();

		return new ContactsPage();

	}

	public DealsPage clickonDealsLink() {

		DealsLink.click();

		return new DealsPage();

	}

	public TasksPage clickonTasksLink() {

		TasksLink.click();

		return new TasksPage();

	}
	
	public void clickonNewContactLink(){
		
		Actions action=new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		NewContactsLink.click();
		
		
		
	}
}