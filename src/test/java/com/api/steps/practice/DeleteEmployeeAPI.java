package com.api.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import org.junit.Assert;

public class DeleteEmployeeAPI {
	private static RequestSpecification request;
	private static Response response;
	String deleteEmployeeURI = "http://54.167.125.15/syntaxapi/api/deleteEmployee.php";
	
	@Given("user calls deleteEmployee API")
	public void user_calls_deleteEmployee_API() {
	    request = given().param("employee_id", CreateEmployeeAPI.emp_id).header("Content-Type", "Application/json")
	    		.header("Authorization", SyntaxAPIAuthenticationSteps.Token);
	}

	@When("user receives response for deleteEmployee")
	public void user_receives_response_for_deleteEmployee() {
	    response = request.when().delete(deleteEmployeeURI);
	    System.out.println("Delete Employee Response -->");
	    response.prettyPrint();
	}

	@Then("STatus code is {int}")
	public void status_code_is(int expected) {
		  response.then().assertThat().statusCode(expected);
	        Assert.assertEquals(expected, response.getStatusCode()); 
	}
	@Then("Response message is {string}")
	public void response_contains_message(String expcedtedMessage) {
	 String actualMessage = response.jsonPath().get("message");
	  Assert.assertEquals(expcedtedMessage, actualMessage);
	}
}