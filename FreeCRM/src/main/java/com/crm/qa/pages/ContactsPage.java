package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//td[contains(text(),'title')]")
	WebElement title;
	
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement companyName;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save' and @class='button']")
	WebElement savebtn;
	
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		
		return contactsLabel.isDisplayed(); 
	}

	public void createNewContact(String title,String fname,String lname,String company){
		
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(company);
		savebtn.click();
		
	}
	
}
