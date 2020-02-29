package com.api.steps.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.junit.Test;

public class SampleAPITests {

//	@Test
	public void getAllJobTitles() {

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI4MDksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODAwOSwidXNlcklkIjoiMzM0In0.1eCebxiPVitiKgm3kAi5P7wVUs8sQo2G93MyGaqiTMU")
				.when().get("http://54.167.125.15/syntaxapi/api/jobTitle.php");

		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
	}

//	@Test
	public void getOneEmployee() {

		Response response = RestAssured.given().param("employee_id", "06234A").contentType("application/json").header(
				"Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI4MDksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODAwOSwidXNlcklkIjoiMzM0In0.1eCebxiPVitiKgm3kAi5P7wVUs8sQo2G93MyGaqiTMU")
				.when().get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");

		response.prettyPrint();
	}

//	@Test
	public void getAllEmployeeStatus() {

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI4MDksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODAwOSwidXNlcklkIjoiMzM0In0.1eCebxiPVitiKgm3kAi5P7wVUs8sQo2G93MyGaqiTMU")
				.when().get("http://54.167.125.15/syntaxapi/api/employeeStatus.php");

		response.prettyPrint();

		int actualRespCode = response.getStatusCode();
		System.out.println(actualRespCode);
	}

//	@Test
	public void createEmployee() {

		String body = "" + "{\r\n" + "  \"emp_firstname\": \"Joseph\",\r\n" + "  \"emp_lastname\": \"Stallin\",\r\n"
				+ "  \"emp_middle_name\": \"Dictator\",\r\n" + "  \"emp_gender\": \"1\",\r\n"
				+ "  \"emp_birthday\": \"2000-02-02\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
				+ "  \"emp_job_title\": \"Developer\"\r\n" + "}";

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI4MDksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODAwOSwidXNlcklkIjoiMzM0In0.1eCebxiPVitiKgm3kAi5P7wVUs8sQo2G93MyGaqiTMU")
				.body(body).when().post("http://54.167.125.15/syntaxapi/api/createEmployee.php");

		response.prettyPrint();
	}

	@Test
	public void getAllEmployee() {

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI4MDksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODAwOSwidXNlcklkIjoiMzM0In0.1eCebxiPVitiKgm3kAi5P7wVUs8sQo2G93MyGaqiTMU")
				.when().get("http://54.167.125.15/syntaxapi/api/getAllEmployees.php");

		response.prettyPrint();

	}

}
