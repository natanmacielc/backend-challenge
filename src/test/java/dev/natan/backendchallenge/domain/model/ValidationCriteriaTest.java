package dev.natan.backendchallenge.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ValidationCriteriaTest {
    @Test
    void constructInstance() {
        assertDoesNotThrow(() -> new ValidationCriteria("", false));
    }
}