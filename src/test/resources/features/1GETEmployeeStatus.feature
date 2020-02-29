@API
Feature: Validating Syntax HRMS API's GET Employee Statuses

  Background: 
    Given user generates token

  @GetEmpStatusAPI
  Scenario: This test will retrieve Employees Status
    Given user calls getEmployeeStatus API
    When user retrieves response for status
    Then status code iss 200
    Then user verifies the number of Employee Status
