package com.api.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetOneEmployeeAPI {
	private static RequestSpecification request;
	private static Response response;
	String getOneEmployeeURI = "http://54.167.125.15/syntaxapi/api/getOneEmployee.php";
	
	@Given("user calls getOneEmployee API")
	public void user_calls_getOneEmployee_API() {
	    request = given().param("employee_id", CreateEmployeeAPI.emp_id)
	    		.header("Content-Type", "Application/json")
	    		.header("Authorization", SyntaxAPIAuthenticationSteps.Token);
	}

	@When("user receives response from getOneEmployee")
	public void user_receives_response_from_getOneEmployee() {
	    response = request.when().get(getOneEmployeeURI);
	    System.out.print("Get One Employee Response -->");
	    response.prettyPrint(); 
	}

	@Then("status codeiis {int}")
	public void status_codeiis(int expected) {
		  response.then().assertThat().statusCode(expected);
	        Assert.assertEquals(expected, response.getStatusCode()); 
	}

	@Then("employee id matches with the test POSTCreateEmployee")
	public void employee_id_matches_with_the_test_POSTCreateEmployee() {
	    //response.jsonPath().get()
	}
}