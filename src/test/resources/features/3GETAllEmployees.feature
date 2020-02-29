#Author: zamiradauyekeyeva@gmail.com
@API
Feature: Validating Syntax HRMS API's GET All Employees

Background:
Given user generates token


  @GetAllEmpAPI
  Scenario: This test will retrieve All Employees
    Given user calls getAllEmployee API
    When user recieves response from getAllEmployee
		Then status code isss 200
    Then validate the number of employees