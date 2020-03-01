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

public class GetAllEmployeeAPI {
	private static RequestSpecification request;
	private static Response response;
	String getAllEmployeURI="http://54.167.125.15/syntaxapi/api/getAllEmployees.php";
	
	@Given("user calls getAllEmployee API")
	public void user_calls_getAllEmployee_API() {
		request=given().header("Content-Type", "application/json")
				.header("Authorization", SyntaxAPIAuthenticationSteps.Token);
	}

	@When("user recieves response from getAllEmployee")
	public void user_recieves_response() {
	   response = request.when().get(getAllEmployeURI);
	   //System.out.print("Get All Employee Response --> ");  response.prettyPrint();
	}
	
	@Then("validate the number of employees")
	public void validate_the_number_of_employees() {
		List<String> list = response.jsonPath().getList("Employee");
	    int numberOFEmployeefromAPI=list.size();
		int numberOFEmployeefromSQL=2715;
		Assert.assertEquals(numberOFEmployeefromSQL, numberOFEmployeefromAPI);
		System.out.println("Number of employee in SQL--> "+ numberOFEmployeefromSQL);
		System.out.println("Number of employee in API--> "+ numberOFEmployeefromAPI);
	}
	@Then("status code isss {int}")
	public void status_code_isss(Integer expectedStatusCode) {
	    //Assert.assertTrue(expectedStatusCode==response.getStatusCode());
	    response.then().assertThat().statusCode(expectedStatusCode);
	    System.out.println("Status code is: "+ response.getStatusCode());
	}

}