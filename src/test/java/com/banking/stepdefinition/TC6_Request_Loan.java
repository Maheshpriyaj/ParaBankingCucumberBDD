package com.banking.stepdefinition;

import org.junit.Assert;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;
import io.cucumber.java.en.*;

public class TC6_Request_Loan extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	
	@When("I navigate to the \"Request Loan\"page")
	public void i_navigate_to_the_request_loan_page() {
		 pom.getrequestLoan().clickRequestLoan();
	}

	@When("I enter {string} as the loan amount")
	public void i_enter_as_the_loan_amount(String value) {
		elementSendKeys(pom.getrequestLoan().loanAmount(),value);
	    
	}
	@When("I enter {string} as the down payment")
	public void i_enter_as_the_down_payment(String value) {
		elementSendKeys(pom.getrequestLoan().downPayment(),value);
	}
	@When("I select {string} as the account to transfer funds from")
	public void i_select_as_the_account_to_transfer_funds_from(String Value) {
		selectOptionByValue(pom.getrequestLoan().fromAccount(),Value);
	}
	
	@When("I click on the Apply Now button")
	public void i_click_on_the_apply_now_button() {
		pom.getrequestLoan().applynow();
	}

	@Then("I should see a confirmation message for request loan {string}")
	public void i_should_see_a_confirmation_message_for_request_loan(String Exp_val) {
		Assert.assertEquals("Verify RequestLoan Message", Exp_val,pom.getrequestLoan().Confirmmsg());
	}







}
