package com.banking.stepdefinition;

import org.junit.Assert;

import com.banking.Basepage.BasePage;
import com.banking.pagemanager.PageObjectManager;
import io.cucumber.java.en.*;

public class TC5_Bill_Payment extends BasePage {
	
	PageObjectManager pom = new PageObjectManager();
	
	
	@When("I navigate to the \"Bill Pay\"page")
	public void i_navigate_to_the_bill_pay_page() {
		pom.getbillPayment().clickBillPay();
	}
	
	@When("I enter the payee name {string}")
	public void i_enter_the_payee_name(String value) {
		elementSendKeys(pom.getbillPayment().payeename(),value);
		
	}
	@When("I enter the address {string}")
	public void i_enter_the_address(String value) {
		elementSendKeys(pom.getbillPayment().payeeaddress(),value);
		
	}
	@When("I enter the city {string}")
	public void i_enter_the_city(String value) {
		elementSendKeys(pom.getbillPayment().city(),value);
	}
	@When("I enter the State {string}")
	public void i_enter_the_state(String value) {
		elementSendKeys(pom.getbillPayment().state(),value);

	}
	@When("I enter the ZipCode {string}")
	public void i_enter_the_zip_code(String value) {
		elementSendKeys(pom.getbillPayment().zipcode(),value);
	}
	@When("I enter the Phone {string}")
	public void i_enter_the_phone(String value) {
		elementSendKeys(pom.getbillPayment().Phone(),value);
	}
	@When("I enter the Account {string}")
	public void i_enter_the_account(String value) {
		elementSendKeys(pom.getbillPayment().account(),value);
	}
	@When("I enter the Verify Account {string}")
	public void i_enter_the_verify_account(String value) {
		elementSendKeys(pom.getbillPayment().txtverifyaccount(),value);
	}
	@When("I enter the Amount {string}")
	public void i_enter_the_amount(String value) {
		elementSendKeys(pom.getbillPayment().txtamount(),value);
	}
	@When("I click on the Send Payment button")
	public void i_click_on_the_send_payment_button() {
		pom.getbillPayment().clickbtnpayment();

	}
	@Then("I should see a confirmation message for bill payment {string}")
	public void i_should_see_a_confirmation_message_for_bill_payment(String Exp_val) {
		Assert.assertEquals("Verify Bill Payment Message", Exp_val,pom.getbillPayment().Cnfmsg());	}




}
