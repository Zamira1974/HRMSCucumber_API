@API
Feature: Validating Syntax HRMS API`s getOneEmployee
 
 Background:
	Given user generates token

@APITEST
  Scenario: This test will validate the employee created by POSTCreateEmployee
    Given user calls getOneEmployee API
    When user receives response from getOneEmployee
    Then status codeiis 200
    Then employee id matches with the test POSTCreateEmployee