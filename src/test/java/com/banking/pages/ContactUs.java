package com.banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;

public class ContactUs extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	public ContactUs() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Contact Us']")
	private WebElement linkContactUs;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameField;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneField;
	
	@FindBy(xpath = "//textarea[@id='message']")
	private WebElement messageField;
	
	@FindBy(xpath = "//input[@value='Send to Customer Care']")
	private WebElement btnSend;
	
	@FindBy(xpath = "//div[@id='rightPanel']/p[2]")
	private WebElement result;
	
	
	public void clickContactUs() {
		elementClick(linkContactUs);	
	}
	public void fillContactForm(String name, String email, String phone, String message) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
        messageField.sendKeys(message);
    }
	
	public void clicksend() {
		elementClick(btnSend);	
	}
	
	public String Confirmmsg() {
		String Text=elementGetText(result);
		return Text;
	}
	
	
}
