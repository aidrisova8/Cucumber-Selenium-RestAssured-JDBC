@OTB-1
Feature: Validating OrangeHR application search employee functionality

  Scenario: Validating search functionality with providing full data
    #before

    Given user navigates to "Orange" application
    When user enters username "Admin" and password "admin123" and clicks on login button and creates employee and admin user
    And user search for System User with data
      | Username      | AmmyDoe  |
      | Employee Name |Ammy Doe |

    Then user validates admin user was found with message "(1) Record Found"