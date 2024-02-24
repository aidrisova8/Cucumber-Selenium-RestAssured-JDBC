@regression @ui @XYZ-1
Feature: Add customer

  Background: Repetitive steps
    Given user navigates to "XYZBank" application

  Scenario: Add a new customer
    When user clicks Bank Manager Login  and Add Customer on the top buttons
    And user enters First Name "John", Last Name "Doe" , and Post Code  "12345" and clicks on Add customer button on the bottom
    Then user should see message "Customer added successfully with customer id"


