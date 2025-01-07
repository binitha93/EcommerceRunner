#Author: binitha93@gmail.com
Feature: ECommerce site search feature

Background:
Given I am in e-commerce application
And I dismiss login popup


Scenario: Searching for a kids product
When I search for 'kids dress'
Then I get the search results
@kids
Scenario Outline: Adding filters to search
When I search for 'kids dress'
Then I get the search results
When I check the checkbox "<FilterName>"
Then The search should return corresponding items
Examples:
|FilterName|
|Girls|
|Boys|