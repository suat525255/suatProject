@smoke @regression
Feature: Online Banking Login Feature
  Agile Story:Authorized users should be able to login so that they can do online banking

  Background: Login page
    Given the user is on the login page

  @pos
  Scenario: Only authorized users should be able to login to the application
    And User logins with username "username" and password "password"
    Then the "Account Summary" page should be displayed
  @neg
  Scenario: Unauthorized users should NOT be able to login to the application
    And User logins with username "wrong" and password "wrong"
    Then Error message "Login and/or password are wrong." should be displayed
    And User logins with username "" and password ""
    Then Error message "Login and/or password are wrong." should be displayed