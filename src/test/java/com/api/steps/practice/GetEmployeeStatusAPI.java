package com.api.steps.practice;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.Assert;

import com.api.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetEmployeeStatusAPI {
	private static RequestSpecification request;
	private static Response response;
	String getEmployeeStatusURI= "http://54.167.125.15/syntaxapi/api/employeeStatus.php";
	
	@Given("user calls getEmployeeStatus API")
	public void user_calls_getEmployeeStatus_API() {
	    request = given().header("Conten-Type", "Application/json")
	    		.header("Authorization", SyntaxAPIAuthenticationSteps.Token);
	}

	@When("user retrieves response for status")
	public void user_retrieves_response_for_status() {
	    response = request.when().get(getEmployeeStatusURI);
	    System.out.print("Get Employee Response -->");
	    response.prettyPrint(); 
	}
	@Then("status code iss {int}")
	public void status_code_iss(int statuscode) {
	   statuscode=response.getStatusCode();
	   Assert.assertEquals(statuscode, 200);
	   
//		Assert.assertTrue(statuscode==response.getStatusCode());
//	    response.then().assertThat().statusCode(statuscode);
//	    System.out.println("Status code is: "+ response.getStatusCode());
	}

    @Then("user verifies the number of Employee Status")
    public void user_verifies_the_number_of_Job_Titles() {
        List<String> list = response.jsonPath().getList("\"Employee Status List\"");
        System.out.println("The number of Job Title is " + list.size());
        int expectedJobTitleNumber=9;
        Assert.assertEquals(expectedJobTitleNumber, list.size());
    }
}