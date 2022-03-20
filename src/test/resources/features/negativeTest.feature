Feature: negative test

  Background:
    Given browser is started
    And user logged in

  Scenario: wrong data test
    And create project
    When put wrong key
    Then wrong data message is displayed

  Scenario: defect test
    And create project
    When put wrong key
    Then defect is displayed

  Scenario: data exceeding the allowable
    When open task window
    And enter invalid values
    Then error message is displayed
