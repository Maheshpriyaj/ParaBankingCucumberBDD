package com.banking.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC2_Account_Overview extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	
	@When("I navigate to the \"Accounts Overview\"page")
	public void i_navigate_to_the_accounts_overview_page() {
	  pom.getaccountOverview().clickaccountOverview();
	}
	
	@Then("I should see a list of accounts with balances and available funds")
	public void i_should_see_a_list_of_accounts_with_balances_and_available_funds() {
	 pom.getaccountOverview().getlistofaccounts();

	}




}
