package com.api.steps.practice;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.api.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class CreateEmployeeAPI {
    
    private static Response response;
    private static RequestSpecification request;
    String createEmployeeURI = "http://54.167.125.15/syntaxapi/api/createEmployee.php";
    public static Object emp_id;
    
    
    
    @Given("user calls createEmployee API")
    public void user_calls_createEmployee_API() {
        
        request = given().header("Content-Type", "application/json")
                .header("Authorization", SyntaxAPIAuthenticationSteps.Token);
    }
    @When("user receives response from createEmployee")
    public void user_receives_response() {
        response = request.body(CommonMethods.readJson("createEmployee.json"))
        		.when().post(createEmployeeURI);
        System.out.print("Create Employee Response -->");
	    response.prettyPrint(); 
    }
    @Then("status code is {int}")
    public void status_code_is(int expected) { 
        response.then().assertThat().statusCode(expected);
        Assert.assertEquals(expected, response.getStatusCode());  
    }
    @Then("user validates employee is created")
    public void user_validates_employee_is_created() {
        boolean empCreated = response.getBody().asString().contains("Entry Created");
        Assert.assertTrue("Employee could not be created", empCreated);
    }
    
    @Then("user keeps the new employee's id")
    public void user_keeps_the_new_employee_s_id() {
        Map<String, Object> result = response.jsonPath().get("Employee[0]");
        emp_id =  result.get("employee_id");
        System.out.println("Employee id is" +emp_id);
        
        List<String> list = response.jsonPath().getList( "Employee");
        System.out.println("List of employee  is    "+list);
    }
}