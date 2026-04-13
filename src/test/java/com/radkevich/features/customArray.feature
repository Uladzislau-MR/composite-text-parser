@array_processing
Feature: Processing custom arrays from file
  As a user
  I want to read numbers from a file using different validation modes
  To perform mathematical operations and sorting

  Scenario: Calculate sum and sort array in Strict mode
    Given I have a source file "Data.txt" and validation mode STRICT
    Then The calculated sum should be 82
    And The minimum value should be 2
    And The maximum value should be 77
    And The resulting array after bubble sort should be "2, 3, 77"
    And The resulting array after selection sort should be "2, 3, 77"

#  Scenario: Calculate average and sort array in Flexible mode
#    Given I have a source file "Data.txt" and validation mode FLEXIBLE
#    Then The calculated sum should be 155
#    And The minimum value should be 1
#    And The maximum value should be 77
#    And The resulting array after bubble sort should be "1, 1, 2, 2, 2, 3, 3, 5, 6, 11, 42, 77"
#    And The resulting array after selection sort should be "1, 1, 2, 2, 2, 3, 3, 5, 6, 11, 42, 77"

