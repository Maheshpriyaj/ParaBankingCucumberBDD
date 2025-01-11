package com.banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;

public class TransferFunds extends BasePage {
	PageObjectManager pom = new PageObjectManager();	
	public TransferFunds() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Transfer Funds']")
	private WebElement linkTransferFunds;
	
	@FindBy(xpath = "//input[@id='amount']")
	private WebElement txtTransferamt;
	
	@FindBy(xpath = "//select[@id='fromAccountId']")
	private WebElement txtFromacc;

	@FindBy(xpath = "//select[@id='toAccountId']")
	private WebElement txtToAcc;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnTransfer;

	@FindBy(xpath = "//div[@id='showResult']/h1")
	private WebElement resultTransfer;

	public void gettransferfund() {
		elementClick(linkTransferFunds);
	}	
	public WebElement txtamount() {
		return txtTransferamt;
	}
	
	public WebElement Fromacc() {
		return txtFromacc;}
	
	public WebElement ToAcc() {
		return txtToAcc;}
		
	public WebElement btnTransfer() {
		return btnTransfer;}
	
	public String CnfMsg() {
		String text=elementGetText(resultTransfer);
		return text;}
	
	
	
	
}
