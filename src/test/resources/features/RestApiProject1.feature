@regression,@api,@smoke @MMB-202
Feature: Validating Logistics Rest API calls

  Scenario: Validate Patch API call
    Given userr creates company with post call
    When userr updates company name with patch call
    Then userr validates status code 200
    And userr connects to database
    And userr validates name is updated in Database
    And userr validates name is updated in UI