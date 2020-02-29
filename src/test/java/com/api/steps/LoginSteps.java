package com.api.steps;

import org.junit.Assert;

import com.api.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends CommonMethods{
	
	@Given("I open browser and navigated to the HRMS")
	public void i_open_browser_and_navigated_to_the_HRMS() {
	   setUp();
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
		sendText(login.username, "Admin");
		sendText(login.password, "Syntax@123");
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
	   click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
	  Assert.assertTrue(true);
	}
	
	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
	 
		sendText(login.username, "Admin");
	    sendText(login.password, "66jhhj");
	}

	@Then("I see error message")
	public void i_see_error_message() {
	   boolean error=login.errorMsg.isDisplayed();
	   Assert.assertTrue("Error message is not displayed", error);
	}
	
	@Then("I close browser")
	public void i_close_browser() {
	    tearDown();
	}
}