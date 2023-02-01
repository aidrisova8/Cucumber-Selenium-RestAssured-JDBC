@regression @ui
Feature: Validating Etsy application search and filter functionalities

  @TTB-1
  Scenario Outline: Validating search results and price range filter functionality for searched item
    Given user navigates to "Etsy" application
    When user searches for "<item>"
    And user1 applies price filter "<price>" dollars
    Then user1 validates that item prices are "<price>" dollars
    And user validates search result items name contains keyword "<item>"

    Examples:
      | item   | price       |
      | sofa   | Over 1500   |
      | chair  | Under 250   |
      | carpet | 50 to 500   |
      | table  | 500 to 1000 |
