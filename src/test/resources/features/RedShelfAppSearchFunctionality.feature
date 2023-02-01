@regression @UI
Feature: ReadShelf application search functionality

  @PTB-1
  Scenario: Validating search result


    Given user navigates to "RedShelf" application
    When user searches " java data structure " with space in the beginning and at the end
    Then user validates search message "java data structure ."