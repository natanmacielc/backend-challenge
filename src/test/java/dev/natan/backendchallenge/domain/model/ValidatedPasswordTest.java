package dev.natan.backendchallenge.domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatedPasswordTest {
    @Test
    void constructInstance() {
        assertDoesNotThrow(() -> new ValidatedPassword(false));
    }

    @Test
    void whenIsValidCalled__thenReturnIsValid() {
        final ValidatedPassword validatedPassword = new ValidatedPassword(true);
        assertTrue(validatedPassword.isValid());
    }

    @Test
    void whenSetCriteriaCalled__thenSetCriteriaAttribute() {
        final ValidatedPassword validatedPassword = new ValidatedPassword(true);
        validatedPassword.setCriteria(List.of(new ValidationCriteria("", false)));
        assertNotNull(validatedPassword.getCriteria());
    }
}