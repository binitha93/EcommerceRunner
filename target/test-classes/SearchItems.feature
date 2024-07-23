#Author: binitha93@gmail.com
Feature: ECommerce site search feature

@kids
Scenario: Searching for a kids product
Given I am in e-commerce application
When I search for 'kids'
Then I get the search results
