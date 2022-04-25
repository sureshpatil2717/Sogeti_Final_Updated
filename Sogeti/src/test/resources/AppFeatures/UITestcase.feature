Feature: To verify the functionality on the Sogeti Application

  Background: 
    Given I launch Chrome Browser

  Scenario: Tescase one
    Given user is on Home page
    When I Hover over Services Link
    Then I should see Automation Link
    When I click on Automation Link
    Then I verify Automation text is visible in Automation Page
    When I Hover over Services Link
    Then I Verify that the Services and Automation are selected
    
   Scenario: Tescase Two
    Given user is on Home page
    When I Hover over Services Link
    Then I should see Automation Link
    When I click on Automation Link
    When I Enter all details in the form
    And I click on I agree checkbox
   # And I Click on I am not Robot   #cannote Automate#
    
    Scenario: Tescase Three
    Given user is on Home page
    When I click on dropdown
    And  I verfiy dropdown list are working fine 
 
  
