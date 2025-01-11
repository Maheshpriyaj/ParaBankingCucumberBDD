package com.banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;

public class AccountOverview extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	public AccountOverview() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='showOverview']/h1")
	private WebElement txtaccount;

	@FindBy(xpath = "//table[@id='accountTable']")
	private WebElement listofaccounts;

	
	public WebElement clickaccountOverview() {
		return txtaccount;
	}
	
	public void getlistofaccounts() {
		
		elementVisibility(listofaccounts);
	}	
}
