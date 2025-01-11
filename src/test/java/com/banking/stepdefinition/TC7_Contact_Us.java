package com.banking.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.junit.Assert;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;
import io.cucumber.java.en.*;

public class TC7_Contact_Us extends BasePage{
	PageObjectManager pom = new PageObjectManager();
	
	
	@Given("I am on the Contact Us page")
	public void i_am_on_the_contact_us_page() throws FileNotFoundException, IOException {
		browserLaunch(getPropertyFileValue("browserType"));
		enterApplnUrl(getPropertyFileValue("URL"));
		maximizeWindow();
		implicitWait();

	   pom.getcontactUs().clickContactUs();
	}

	@When("I fill in the contact form with the following details:")
	public void i_fill_in_the_contact_form_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
		 Map<String, String> formDetails = dataTable.asMap(String.class, String.class);

		    String name = formDetails.get("Name");
		    String email = formDetails.get("Email");
		    String phone = formDetails.get("Phone");
		    String message = formDetails.get("Message");

		    pom.getcontactUs().fillContactForm(name, email, phone, message);
	}
	@When("I click on the Send Message button")
	public void i_click_on_the_send_message_button() {
		pom.getcontactUs().clicksend();
		}
	
	@Then("I should see a confirmation message for contact us {string}")
	public void i_should_see_a_confirmation_message_for_contact_us(String Exp_val) {
		Assert.assertEquals("Verify Contact us  Message", Exp_val,pom.getcontactUs().Confirmmsg());
	}



	



}
