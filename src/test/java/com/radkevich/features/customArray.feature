@array_processing
Feature: Processing custom arrays from file
  As a user
  I want to read numbers from a file using different validation modes
  To perform mathematical operations and sorting

  Scenario: Calculate sum and sort array in Strict mode
    Given I have a source file "Data.txt" and validation mode STRICT
    Then The calculated sum should be 141
    And The minimum value should be 1
    And The maximum value should be 77
    And The resulting array after bubble sort should be "1, 1, 2, 2, 2, 3, 11, 42, 77"
    And The resulting array after selection sort should be "1, 1, 2, 2, 2, 3, 11, 42, 77"

