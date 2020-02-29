@API
Feature: Validating Syntax HRMS API
  Background: 
  	Given: user generates token

@APITEST
  Scenario: This test will check to see if the employee is updated
    Given user calls updateEmployee API
    When user recieves response from updateEmployee
    Then Status code is 200
    Then response message is "Entry updated"
    And user validates the employee ID didnot change