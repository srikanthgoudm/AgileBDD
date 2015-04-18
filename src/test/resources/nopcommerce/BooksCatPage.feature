#@BooksPage
#Scenario Outline: Books Category Page
#Given user is in home page
#When user selects the Books page
#Then user should be navigated to Books category page
#And user should see list of products
#And user should see Books category page with '<filters>'
#Examples:
#|filters|
#|Sort by|
#|Display|
#|View as|
#
#
#@Sortby
#Scenario: Sort by Filter
#Given user is in Books category page
#When user choose Sort by Filter '<Sory by>' from the list
#Then products should be sorted with '<Order>'
#Eaxmples:
#|Sort by|Order|
#|Position|PositionZ
#|Name: A to Z| alphabetical ascending order|
#|Name:  z To A|alphabetical ascending order|
#|Price:  Low to High |Price decending order|
#|Price: High to Low |Price ascending order|
#|Created on|date latest|
#
#Feature:  Apply filters to the Books Category.
##
##  As a user
##  I want to apply the filters
##  So that I can change the order of display.
##
##  Scenario:  User can see the Sort by filter.
##
##    Given user is on the Books Category Page.
##    When user selects the Sort by filter
##    Then User should see the options
##
##
##  Scenario:  User can see the Display filter.
##
##    Given user is on the Books Category Page.
##    When user selects the Display filter
##    Then user should see these options
##      |Display|
##      |    4       |
##      |    8       |
##      |    12     |
##
##  Scenario:  User can see View filter.
##
##    Given user is on the Books Category Page.
##    When User selects the View filter
##    Then User should see these options.
##      | View |
##      | Grid |
##      | List   |
##
##  @Display
##  Scenario Outline: Display Filter
##    Given user is in Books category page
##    When user select '<display>'
##    Then user should see '<number of products>' products in a page
##
##  Examples:
##    | display |number of products|
##    |4|4|
##    |8|8|
##    |12|12|
##
##  @viewas
##  Scenario Outline: View as Filter
##    Given user is in Books category page
##    When user select '<View as>'
##    Then products should be displayed in '<View as>' format
##  Examples:
##    |  View as |
##    |Grid|
##    |List|
##
##
##
