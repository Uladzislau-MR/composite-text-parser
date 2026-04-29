package com.radkevich.stepdefinitions;

import com.radkevich.entity.CustomArray;
import com.radkevich.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


public class ArrayProcessingSteps {
    private List<CustomArray> arrays;
    private CustomArray targetArray;

    @Given("I have a source file {string} and validation mode STRICT")
    public void iHaveSourceFileAndValidationMode(String fileName) throws Exception {

        arrays = Hooks.customArrayService.createFromFile(fileName);
        Hooks.customArrayService.add(arrays);

        targetArray = arrays.stream()
                .filter(a -> Arrays.stream(a.getElements()).anyMatch(i -> i == 77))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Target array not found in file"));
    }

    @Then("The calculated sum should be {int}")
    public void theCalculatedSumShouldBe(int expectedSum) {
        int actualSum = Hooks.customArrayService.findSum(targetArray);
        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Then("The minimum value should be {int}")
    public void theMinimumValueShouldBe(int expectedMin) {
        int actualMin = Hooks.customArrayService.findMin(targetArray);
        Assertions.assertEquals(expectedMin, actualMin);
    }

    @Then("The maximum value should be {int}")
    public void theMaximumValueShouldBe(int expectedMax) {
        int actualMax = Hooks.customArrayService.findMax(targetArray);
        Assertions.assertEquals(expectedMax, actualMax);
    }


}