Feature: positive task test

  Background:
    Given set up connection
    Given browser is started
    And user logged in

  Scenario: task created test
    And create the task
    Then task is displayed

  Scenario: task deleted  test
    And create the task
    When delete the task
    Then task is not displayed

  Scenario: dialog window test
    Then check  dialog window visibility

  Scenario: context message test
    And create the task
    Then get visible context message

  Scenario: uploading file test
    When open task window
    Then uploading file and check that the file is loaded



