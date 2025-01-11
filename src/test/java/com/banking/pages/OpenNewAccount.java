package com.banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;

public class OpenNewAccount extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	public OpenNewAccount() {
		PageFactory.initElements(driver, this);}
		
	@FindBy(xpath = "//a[text()='Open New Account']")
	private WebElement linkOpenNewAccount;
	
	@FindBy(xpath = "//select[@id='type']")
	private WebElement typeofaccount;

	@FindBy(xpath = "//select[@id='fromAccountId']")
	private WebElement existingaccount;
	
	@FindBy(xpath = "//input[@type='button']")
	private WebElement btnOpenNewAccount;
	
	@FindBy(xpath = "//div[@id='openAccountResult']/h1")
	private WebElement Cnfmsg;
	
	public void clickOpenNewAccount() {
		elementClick(linkOpenNewAccount);
	
	}
	
	public WebElement typeofaccount() {
		return typeofaccount;		
	}
	
	public WebElement existingaccount() {
			return existingaccount;
	}

	public void btnOpenNewAccount() {
		elementClick(btnOpenNewAccount);
	
	}
	
	public String ConfirmMsg() {
		String text=elementGetText(Cnfmsg);
		return text;
	}
	
	

	

}
