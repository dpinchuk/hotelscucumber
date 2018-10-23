Feature: Open Main Page
  This feature opens main web page

  @hotel_search_0
  Scenario: Open main page 1
    Given Open main web page
    And Find search field
    And Input data into the field
    And Press search button
    Then Open search page

  @hotel_search_1
  Scenario: Open main page 2
    Given Open main web page
    And Find search field
    And Input data into the field
    And
    And Press search button
    Then Open search page