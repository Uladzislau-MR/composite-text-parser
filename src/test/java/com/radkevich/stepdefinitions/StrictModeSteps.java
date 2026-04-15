package com.radkevich.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static com.radkevich.hooks.Hooks.customArrayService;

public class StrictModeSteps {

    private String fileName;


    @Given("I have a source file {string} and validation mode STRICT")
    public void setupFileAndMode(String fileName) {
        this.fileName = fileName;

    }

    @Then("The calculated sum should be {int}")
    public void checkSum(int expectedSum) {
        int sum = customArrayService.findSum(fileName);
        Assertions.assertEquals(expectedSum, sum, "The calculated sum does not match the expected value.");
    }
    @And("The minimum value should be {int}")
    public void checkMin(int expectedMin) {
        int min = customArrayService.findMin(fileName).getAsInt();
        Assertions.assertEquals(expectedMin, min, "The minimum value does not match.");
    }

    @And("The maximum value should be {int}")
    public void checkMax(int expectedMax) {
        int max = customArrayService.findMax(fileName).getAsInt();
        Assertions.assertEquals(expectedMax, max, "The maximum value does not match.");
    }

    @And("The resulting array after bubble sort should be {string}")
    public void checkBubbleSortResult(String expectedArrayStr) {

        int[] expectedArray = java.util.Arrays.stream(expectedArrayStr.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        Assertions.assertArrayEquals(expectedArray, customArrayService.sortBubble(fileName),
                "The bubble sorted array does not match.");
    }
    @And("The resulting array after selection sort should be {string}")
    public void checkSelectionSortResult(String expectedArrayStr) {

        int[] expectedArray = java.util.Arrays.stream(expectedArrayStr.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        Assertions.assertArrayEquals(expectedArray, customArrayService.sortSelection(fileName),
                "The selection sorted array does not match.");

    }
}