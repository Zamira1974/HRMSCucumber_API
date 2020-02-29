@sprint3    @reports
Feature: Title of your feature
  I want to use this template for my feature file
		Background: 
		Given I logged into HRMS
		And I navigated to Reports Page
  @smok
  Scenario: Search for valid report
    When I enter report name as "Candidates"
    And I click on search button
    Then I see "Candidates" text
  @smok
  Scenario Outline: Search for invalid report
    When I enter report name as "<reportName>"
    And I click on search button
    Then I see "<message>" text
    Examples: 
      | reportName    | message |
      | Final Reports |No Records Found|
      | Daily Reports |No Records Found|