package com.api.steps.practice;
import static io.restassured.RestAssured.given;

import org.junit.Test;

import com.api.utils.CommonMethods;

import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class SyntaxAPIAuthenticationSteps {
	private Response response;
	public static String Token;
	private static RequestSpecification request;
	
	String generateTokenURI = "http://54.167.125.15/syntaxapi/api/generateToken.php";
	
	@Given("user generates token")
	public void user_generates_token() {
		
		request = given().header("Content-Type", "application/json");
		System.out.println(request.log().all());
		response = request.body(CommonMethods.readJson("generateToken.json"))
		.when().post(generateTokenURI);
		System.out.println(response.prettyPrint());
		
		Token = "Bearer " +response.jsonPath().getString("token");
		System.out.println(Token);
	}
}


