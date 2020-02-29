@API
Feature: Validating Syntax HRMS API's

Background:
Given user generates token


@APITEST
Scenario: This test will check to see if an Employee is created
Given user calls createEmployee API
When user receives response from createEmployee
Then status code is 200
Then user validates employee is created
Then user keeps the new employee's id 
