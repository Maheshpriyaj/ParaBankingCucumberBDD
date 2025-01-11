package com.banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;

public class BillPayment extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	public BillPayment() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Bill Pay']")
	private WebElement linkBillPay;
	
	@FindBy(xpath = "//input[@name='payee.name']")
	private WebElement txtpayeename;
	
	@FindBy(xpath = "//input[@name='payee.address.street']")
	private WebElement txtpayeeaddress;
	
	@FindBy(xpath = "//input[@name='payee.address.city']")
	private WebElement txtcity;
		
	@FindBy(xpath = "//input[@name='payee.address.state']")
	private WebElement txtstate;
	
	@FindBy(xpath = "//input[@name='payee.address.zipCode']")
	private WebElement txtzipcode;
	
	@FindBy(xpath = "//input[@name='payee.phoneNumber']")
	private WebElement txtPhone;
	
	@FindBy(xpath = "//input[@name='payee.accountNumber']")
	private WebElement txtaccount;
	
	@FindBy(xpath = "//input[@name='verifyAccount']")
	private WebElement txtverifyaccount;	
	
	@FindBy(xpath = "//input[@name='amount']")
	private WebElement txtamount;
	
	@FindBy(xpath = "//input[@type='button']")
	private WebElement btnpayment;

	@FindBy(xpath = "//div[@id='billpayResult']/h1")
	private WebElement billpayResult;


	public void clickBillPay() {
		elementClick(linkBillPay);	
	}
	
	public WebElement payeename() {
		return txtpayeename;
	}
	
	public WebElement payeeaddress() {
		return txtpayeeaddress;
	}
	
	public WebElement city() {
		return txtcity;
	}

	public WebElement state() {
		return txtstate;
	}
	
	public WebElement zipcode() {
		return txtzipcode;
	}
	public WebElement Phone() {
		return txtPhone;
	}
	public WebElement account() {
		return txtaccount;
	}
	public WebElement txtverifyaccount() {
		return txtverifyaccount;
	}
	
	public WebElement txtamount() {
		return txtamount;
	}
	
	public void clickbtnpayment() {
		elementClick(btnpayment);
		
	}
	public String Cnfmsg() {
		String Text=elementGetText(billpayResult);
		return Text;
	}



}
