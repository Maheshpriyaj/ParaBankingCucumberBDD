package com.banking.stepdefinition;

import org.junit.Assert;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;
import io.cucumber.java.en.*;

public class TC4_Open_New_Account extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	
	@When("I navigate to the \"Open New Account\" page")
	public void i_navigate_to_the_open_new_account_page() {
		pom.getopenNewAccount().clickOpenNewAccount();
	   
	}
	@When("I select {string} as the account type")
	public void i_select_as_the_account_type(String Value) {
		selectOptionByText(pom.getopenNewAccount().typeofaccount(),Value);
	   
	}
	
	@When("I select value as the existing account to transfer funds from")
	public void i_select_value_as_the_existing_account_to_transfer_funds_from() {
		selectOptionByIndex(pom.getopenNewAccount().existingaccount(),0);
	}
	@When("I click on the Open New Account button")
	public void i_click_on_the_open_new_account_button() {
		pom.getopenNewAccount().btnOpenNewAccount();}
	
	@Then("I should see a confirmation message {string} with the new account number")
	public void i_should_see_a_confirmation_message_with_the_new_account_number(String Exp_val) {
		Assert.assertEquals("Verify Open New Account Message", Exp_val,pom.getopenNewAccount().ConfirmMsg());

	}



	
}
