package com.banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;

public class Logout extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	public Logout() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement btnlogout;
	
	public void clicklogout() {
		elementClick(btnlogout);
	}	
}
