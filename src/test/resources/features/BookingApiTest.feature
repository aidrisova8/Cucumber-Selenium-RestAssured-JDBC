@MB-203 @smoke @regression @api
Feature: Validating Booking API calls

  Scenario: Validating create booking api call
    Given user creates booking with post api call with data
      | firstname      | John       |
      | lastname       | Doe        |
      | totalprice     | 111        |
      | depositpaid    | true       |
      | chekin         | 2022-02-06 |
      | chekout        | 2023-04-05 |
      | additionalneeds | breakfast  |
    When user sends get booking api call
    Then user validates status code 200
    And user validates data matches with created data

    @MB-204
  Scenario: Validating delete booking api call
    Given user creates booking with post api call with data
      | firstname       | John       |
      | lastname        | Doe        |
      | totalprice      | 111        |
      | depositpaid     | true       |
      | chekin          | 2022-02-06 |
      | chekout         | 2023-04-05 |
      | additionalneeds | breakfast  |
    When user deletes booking
    Then user validates status code 201
    When user sends get booking api call
    And user validates status code 404
  @MB-207
  Scenario: Validating update booking api call
    Given user creates booking with post api call with data
      | firstname       | John       |
      | lastname        | Doe        |
      | totalprice      | 111        |
      | depositpaid     | true       |
      | chekin          | 2022-02-06 |
      | chekout         | 2023-04-05 |
      | additionalneeds | breakfast  |

    When user updates booking
      | firstname       | Jim        |
      | lastname        | Doe        |
      | totalprice      | 120        |
      | depositpaid     | true       |
      | chekin          | 2022-02-06 |
      | chekout         | 2023-04-05 |
      | additionalneeds | breakfast  |
    When user sends get booking api call
    And user validates status code 200
    And user validates response body matches with updated data
