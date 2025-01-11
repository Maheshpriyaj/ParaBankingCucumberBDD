package com.banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;


public class UserLogin extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	public UserLogin() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPass;

	@FindBy(xpath = "//input[@class='button']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//p[@class='smallText']/b")
	private WebElement txtLoginSucessMsg;
	
	@FindBy(xpath = "//p[@class='error']")
	private WebElement txtLoginErrorMsg;


	public WebElement getTextEmail() {
		return txtEmail;
	}

	public WebElement getTextPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void login(String emailID, String password) {
		elementSendKeys(txtEmail, emailID);
		elementSendKeys(txtPass, password);
		
	}		
	public void clicklogin() {
		elementClick(btnLogin);
	}	
	
	public String getLoginSucessMsgTxt() {
		String elementGetText = elementGetText(txtLoginSucessMsg);
		return elementGetText;
		
	}
	
	public String getLoginErrorMsgTxt() {
		String elementGetText = elementGetText(txtLoginErrorMsg);
		return elementGetText;
		
	}

} 