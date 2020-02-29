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

public class GetJobTitlesAPI {
	
	private static RequestSpecification request;
	private Response response;
	String jobTitlesURI= "http://54.167.125.15/syntaxapi/api/jobTitle.php";
	
	@Given("user calls GETJobTitles API")
	public void user_calls_GETJobTitles_API() {
	    request = given().header("Content-Type", "Application/json")
	    		.header("Authorization", SyntaxAPIAuthenticationSteps.Token);
	}

	@When("user retrieves response from getJobTitles")
	public void user_retrieves_response_from_getJobTitles() {
	    response = request.when().get(jobTitlesURI);
	    System.out.print("Job Titles Response -->");
	    response.prettyPrint(); 
	}
    @Then("status codeis {int}")
    public void status_code_is(int expected) {
        response.then().assertThat().statusCode(expected);
        Assert.assertEquals(expected, response.getStatusCode()); 
        System.out.println("Response Status Code:"+response.getStatusCode());
    }
    @Then("user verifies the number of Job Titles")
    public void user_verifies_the_number_of_Job_Titles() {
        List<String> list = response.jsonPath().getList("\"Job Title List\"");
        System.out.println("The number of Job Title is " + list.size());
        int expectedJobTitleNumber=19;
      	Assert.assertEquals(expectedJobTitleNumber, list.size());
    }

}