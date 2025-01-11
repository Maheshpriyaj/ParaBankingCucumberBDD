package com.banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;

public class RequestLoan extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	public RequestLoan() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Request Loan']")
	private WebElement linkRequestLoan;
	
	@FindBy(xpath = "//input[@id='amount']")
	private WebElement loanAmount;

	@FindBy(xpath = "//input[@id='downPayment']")
	private WebElement downPayment;

	@FindBy(xpath = "//select[@id='fromAccountId']")
	private WebElement fromAccount;
	
	@FindBy(xpath = "//input[@value='Apply Now']")
	private WebElement applynow;
	
	@FindBy(xpath = "//div[@id='loanRequestApproved']/p")
	private WebElement cnfmsg;

	
	public void clickRequestLoan() {
		elementClick(linkRequestLoan);	
	}
	
	public WebElement loanAmount() {
		return loanAmount;
	}
	
	public WebElement downPayment() {
		return downPayment;
	}

	public WebElement fromAccount() {
		return fromAccount;
	}

	public void applynow() {
		elementClick(applynow);
	}
	
	public String Confirmmsg() {
		String Text=elementGetText(cnfmsg);
		return Text;
	}

	

	
	
	
}
