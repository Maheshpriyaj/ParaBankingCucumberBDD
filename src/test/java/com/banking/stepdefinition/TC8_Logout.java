package com.banking.stepdefinition;

import org.junit.Assert;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC8_Logout extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	
	@Then("Verify title after Login {string}")
	public void verify_title_after_login(String Exp_val) {
		Assert.assertEquals("Verify Title after Login", Exp_val,pom.getcontactUs().getApplnTitle());
	    
	}
	@When("I click on the Logout button")
	public void i_click_on_the_logout_button() {
	    pom.getlogout().clicklogout();
	}
	@Then("Verify title after Logout {string}")
	public void verify_title_after_logout(String Exp_val) {
		Assert.assertEquals("Verify Title after Logout", Exp_val,pom.getcontactUs().getApplnTitle());}



}
