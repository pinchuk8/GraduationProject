#Feature: UI tests
#
#  Background:
#    Given create models
#    And  open page
#    And login
#
#  Scenario:Limit Value Test-NEGATIVE
#    Given creating task with invalid summary field
#    Then wrong massage is visible
#    Then close browser

#  Scenario:Context Message Test-POSITIVE
#    Given create task and get visible context message
#    Then close browser

#  Scenario: Create Task Test-POSITIVE
#    Given creating task
#    Then check that there's task
#    Then close browser

#  Scenario: Delete Task Test-POSITIVE
#    Given creating task
#    Given removing task
#    Then check that there's no task
#    Then close browser

#  Scenario: Dialog Window Test-POSITIVE
#    Given open dialog window and check it's visibility
#    Then close browser

#  Scenario: Wrong Data Test for KeyProject Field-NEGATIVE
#    Given creating project with wrong keys
#    Then get a key warning message
#    Then close browser

#  Scenario: Limit Value Test for NameProject Field-POSITIVE
#    Given opening page with fields for creating project
#    * enter 1 symbol
#    Then get a warning message
#    And clear the field
#    When enter 2 symbols
#    Then create button is enabled
#    * clear the field
#    When enter 3 symbols
#    Then create button is enabled
#    Then clear the field
#    When enter 80 symbols
#    Then create button is enabled
#    * clear the field
#    When enter 81 symbols
#    Then get a warning message
#    * clear the field
#    Then close browser

