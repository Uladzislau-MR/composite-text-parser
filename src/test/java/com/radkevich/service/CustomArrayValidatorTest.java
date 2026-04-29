package com.radkevich.service;

import com.radkevich.validator.CustomArrayValidator;
import com.radkevich.validator.impl.CustomArrayValidatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayValidatorTest {

    private final CustomArrayValidator validator = new CustomArrayValidatorImpl();

    @ParameterizedTest
    @ValueSource(strings = {"123", "-50", "+7", "0"})
    void isValidIntegerShouldReturnTrue(String input) {
        assertTrue(validator.isValidInteger(input), "Should be true for valid integer: " + input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12a", "10.5", "10,5", "?11", "++5", " ", ""})
    void isValidIntegerShouldReturnFalse(String input) {
        assertFalse(validator.isValidInteger(input), "Should be false for invalid input: " + input);
    }

    @Test
    void isValidIntegerShouldReturnFalseForNull() {
        assertFalse(validator.isValidInteger(null), "Should be false when input is null");
    }
}