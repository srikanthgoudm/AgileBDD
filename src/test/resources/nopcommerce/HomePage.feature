@smokeTest1
Feature: Categories List Functionality
#  As a user
#  I want to see the categories list on home Page
#  So that I can choose one of the category and navigate to the category page

Scenario: User can see the Categories list on home page
Given user is on the 'HOME PAGE'
Then user should see 'CATEGORIES' header on the home page
And User should see the categories list as below
 |Books |
 |Computers|
 |Electronics|
 |Apparel & Shoes|
 |Digital downloads|
 |Jewelry         |
 |Gift Cards|

