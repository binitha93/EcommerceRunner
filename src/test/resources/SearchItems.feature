#Author: binitha93@gmail.com
Feature: ECommerce site search feature

Background:
Given I am in e-commerce application
#And I dismiss login popup
@remote @chrome 
Scenario: Searching for a kids product in chrome
When I search for 'kids dress'
Then I get the search results
@remote @firefox
Scenario: Searching for a kids product in firefox
When I search for 'kids dress'
Then I get the search results
@remote @edge
Scenario: Searching for a kids product in edge
When I search for 'kids dress'
Then I get the search results
@remote @opera
Scenario: Searching for a kids product in opera
When I search for 'kids dress'
Then I get the search results

@local @chrome 
Scenario: Searching for a kids product in chrome
When I search for 'kids dress'
Then I get the search results
@local @firefox
Scenario: Searching for a kids product in firefox
When I search for 'kids dress'
Then I get the search results
@local @edge
Scenario: Searching for a kids product in edge
When I search for 'kids dress'
Then I get the search results
@local @opera
Scenario: Searching for a kids product in opera
When I search for 'kids dress'
Then I get the search results

@local
Scenario Outline: Adding filters to search
When I search for 'kids dress'
Then I get the search results
When I check the checkbox "<FilterName>"
Then The search should return corresponding items
Examples:
|FilterName|
|Girls|
|Boys|

@local
Scenario: Searching for a kids product in local browser
When I search for 'kids dress'
Then I get the search results