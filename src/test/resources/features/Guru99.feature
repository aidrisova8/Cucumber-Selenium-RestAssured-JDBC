@regression @ui  @PTB-2
  Feature: Validating Guru99 application login functionality


    Scenario:validating success login msg
      Given user navigates to "Guru99" application
      When user enters email "admin@mindtek.com " and password "admin" and clicks on login button
      Then user validates success msg "Successfully Logged in..."
