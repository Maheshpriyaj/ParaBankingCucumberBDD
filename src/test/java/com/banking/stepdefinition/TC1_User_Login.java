package com.banking.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC1_User_Login extends BasePage {
	
	PageObjectManager pom = new PageObjectManager();

	
	@Given("I am on the Parabank login page")
	public void i_am_on_the_parabank_login_page() throws FileNotFoundException, IOException {
		browserLaunch(getPropertyFileValue("browserType"));
		enterApplnUrl(getPropertyFileValue("URL"));
		maximizeWindow();
		implicitWait();

	    }

	@When("I enter valid username {string} and password {string}")
	public void i_enter_valid_username_and_password(String emailID, String Password) {
		pom.getUserLogin().login(emailID, Password);
		
	  }
	
	@When("I click on the Login button")
	public void i_click_on_the_login_button() {
	    pom.getUserLogin().clicklogin();
	}
	
    @Then("I should see the homepage with a {string} message")
	public void i_should_see_the_homepage_with_a_message(String ExpectedMsg) {
    	Assert.assertEquals("Verify Login Success Message", ExpectedMsg,pom.getUserLogin().getLoginSucessMsgTxt());	       
	}

   
    @When("I enter invalid username {string} and password {string}")
    public void i_enter_invalid_username_and_password(String emailID, String Password) {
    	pom.getUserLogin().login(emailID, Password);
        
    }
    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String ExpectedMsg) {
    	Assert.assertEquals("Verify Login Success Message", ExpectedMsg,pom.getUserLogin().getLoginErrorMsgTxt());	       
    }
    

    @When("I click on the Login button without entering username or password")
    public void i_click_on_the_login_button_without_entering_username_or_password() {
    	pom.getUserLogin().clicklogin();       
    }








	
	
	    




}
