#Author: zamira (zamiradauyekeyeva@gmail.com)
@sprint2 @addemployee
Feature: Add Employee

  Background: 
    Given I am logged into HRMS
    And I navigated to Add Employee Page

  @smoke
  Scenario: Add new Employee
    When I add "Zara", "Jr" and "Rockfeller"
    And I click Save
    Then I see Employee has been succesfully added

  @regression
  Scenario Outline: Add new Employee
    When I add "<FirstName>", "<MiddleName>" and "<LastName>"
    And I click Save
    Then I see Employee with "<FirstName>", "<MiddleName>" and "<LastName>" is displayed

    Examples: 
      | FirstName | MiddleName | LastName |
      | Napoleon  |            | Hill     |
      | James     | Jr         | Smith    |
      | Jannet    | Jr         | Jackson  |
      | Brain     |            | Tracy    |

  @regression @inProgress
  Scenario: Add and Modify Employee Details
    When I enter employee details
      | FirstName | MiddleName | LastName |
      | John      | J          | Smith    |
    And I click Save
    Then I am able to modify Employee Details
      | DriverLisence | ExpirationDate | SSN         | SIN       | Gender | MaritalStatus | Nationality | DOB        |
      | D02jhiuv90    | 2025-12-01     | 555-45-0000 |   7687687 | Male   | Other         | Spanish     | 1997-10-16 |
      | NY932856h7    | 2022-10-07     | yiy-wery-09 | u3567brth | Female | Married       | Chinesse    | 1995-01-01 |

  @regression
  Scenario: Add Employee without employee id
    When I add firstName, middleName and last name
    And I delete employee id
    And I click Save
    Then I see employee without employee id is being added

  @smoke
  Scenario: Add Employee negative scenario
    When I click Save
    Then I see required error message next to the first and last name

  @regression
  Scenario: AddEmployee and Login Credentials
    When I add firstName, middleName and last name
    And I click on create login checkbox
    When I enter username, password and confirm password
      | UserName     | Password         | ConfirmPassword  |
      | napoleon2020 | Napoleon!@#12345 | Napoleon!@#12345 |
    When I click Save
    Then I see Employee has been succesfully added
