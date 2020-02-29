package com.api.steps.practice;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.junit.Assert;

import com.api.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateEmployeeAPI {
	private static RequestSpecification request;
	private static Response response;
	String updateEpmloyeeURI = "http://54.167.125.15/syntaxapi/api/updateEmployee.php";

	@Given("user calls updateEmployee API")
	public void user_calls_updateEmployee_API() {
		request = given().header("Content-Type", "Application/json").header("Authorization",
				SyntaxAPIAuthenticationSteps.Token);
	}

	@When("user recieves response from updateEmployee")
	public void user_recieves_response_from_updateEmployee() {
		String empID = "{ \"employee_id\": \"06420A\",";
		System.out.println(empID + "$$$$$$$$");
		
		response = request.body(CommonMethods.readJson("updateEmployee.json")).when().put(updateEpmloyeeURI);
		System.out.print("Update Employee Response-->");
		response.prettyPrint();
	}

	@Then("Status code is {int}")
	public void status_code_is(int expected) {
		response.then().assertThat().statusCode(expected);
		Assert.assertEquals(expected, response.getStatusCode());
	}

	@Then("response message is {string}")
	public void response_contains_message(String expcedtedMessage) {
		String actualMessage = response.jsonPath().get("Message");
		Assert.assertEquals(expcedtedMessage, actualMessage);
	}

	@Then("user validates the employee ID didnot change")
	public void user_validates_the_employee_ID_didnot_change() {

		Map<String, String> map = response.jsonPath().get("employee[0]");
		Object updatedEmpID = map.get("employee_id");
		System.out.println("Updated employee Id is : " + updatedEmpID);
		Assert.assertEquals("06420A", updatedEmpID);
	}
}