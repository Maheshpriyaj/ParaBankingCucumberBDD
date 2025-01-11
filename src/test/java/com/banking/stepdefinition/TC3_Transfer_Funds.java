package com.banking.stepdefinition;

import org.junit.Assert;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;
import io.cucumber.java.en.*;

public class TC3_Transfer_Funds extends BasePage {
	PageObjectManager pom = new PageObjectManager();
	
	@When("I navigate to the \"Transfer Funds\"page")
	public void i_navigate_to_the_transfer_funds_page() {
		pom.gettransferFunds().gettransferfund();
	}
	
	@When("I enter {string} as the transfer amount")
	public void i_enter_as_the_transfer_amount(String Value) {
	   elementSendKeys(pom.gettransferFunds().txtamount(),Value);
	}
	
	@When("I select value as the from account")
	public void i_select_value_as_the_from_account() {
	 selectOptionByIndex(pom.gettransferFunds().Fromacc(),0);  
	}
	
	@When("I select value as the to account")
	public void i_select_value_as_the_to_account() {
		selectOptionByIndex(pom.gettransferFunds().ToAcc(),0);
	}
		
	
	@When("I click on the Transfer button")
	public void i_click_on_the_transfer_button() {
		elementClick(pom.gettransferFunds().btnTransfer());
	}


@Then("I should see a confirmation message {string}")
	public void i_should_see_a_confirmation_message(String Exp_val) {
	Assert.assertEquals("Verify Transfer Fund Message", Exp_val,pom.gettransferFunds().CnfMsg());
	    
}}



