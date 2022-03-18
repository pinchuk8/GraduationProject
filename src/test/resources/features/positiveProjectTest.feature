Feature: positive project test

  Background:
    Given browser is started
    And user logged in
    And create project

  Scenario Outline: limit value test for name project field
    When put different "<projectName>" in the name field
    Then value is <size>
    Examples:
      | projectName                                                                       | size |
      | a                                                                                 | 1    |
      | md                                                                                | 2    |
      | mhg                                                                               | 3    |
      | mrnqtnwqpeguxgaemzjufrpossmxeekuwynkvbzzzsvjqfqanhtwbwbvibgpxedowxyroxmuytrewqgf  | 80   |
      | xrnqtnwqpeguxgaemzjufrpossmxeekuwynkvbzzzsvjqfqanhtwbwbvibgpxedowxyroxmiqwyundorr | 81   |

