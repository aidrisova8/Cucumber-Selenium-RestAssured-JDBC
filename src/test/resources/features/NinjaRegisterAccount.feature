@FOX-1
  Feature: Validating Register Account Functionality

    Background: Repeated first steps in scenario
      Given user navigates to "Ninja" application
    Scenario: Validating registering an account by providing all mandatory fields

      When I click on My Account Drop menu
      And I click on Register option
      And I enter new Account Details into the Mandatory Fields
        | First_Name       | John             |
        | Last_Name        | Doe              |
        | EMail            | jdoe123@gmail.com |
        | Telephone        | 315 615 0000     |
        | Password         | test123|
        | Password_Confirm | test123|





      And I click on Continue button
      Then I should see the "Your Account Has Been Created!" page