#Author: binitha93@gmail.com

Feature: Selection of dropdown values
  I want to select an element from dropdown

@dropdown @edge
  Scenario: Dropdown Tests using edge
    Given I open edge browser
    And I am in the dropdown test application
    When I select an element from dropdown
    Then I validate the selection
@dropdown @firefox
  Scenario: Dropdown Tests using firefox
    Given I open firefox browser
    And I am in the dropdown test application
    When I select an element from dropdown
    Then I validate the selection
@fileupload    
  Scenario: File Upload Tests
  	Given I am in the file upload test application
    When I upload the file
    And I click on submit
    Then I validate the file selection 
