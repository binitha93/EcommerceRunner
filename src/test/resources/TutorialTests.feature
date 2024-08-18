#Author: binitha93@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Selection of dropdown values
  I want to select an element from dropdown

@dropdown
  Scenario: Dropdown Tests
    Given I am in the dropdown test application
    When I select an element from dropdown
    Then I validate the selection
@fileupload    
  Scenario: File Upload Tests
  	Given I am in the file upload test application
    When I upload the file
    And I click on submit
    Then I validate the file selection 
