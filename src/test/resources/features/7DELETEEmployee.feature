@API
Feature: Validating Syntax HRMS API's DELETE Employee

  Background: 
    Given user generates token

  @APITEST
  Scenario: This test will delete one employee
    Given user calls deleteEmployee API
    When user receives response for deleteEmployee
    Then STatus code is 200
    Then Response message is "Entry deleted"
