package dev.natan.backendchallenge.application.usecase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorUseCaseTest {
    private final PasswordValidatorUseCase passwordValidatorUseCase = new PasswordValidatorUseCase();

    @Test
    void givenValidPassword__thenReturnValidResponse() {
        final String password = "ZbTp1fo@#";
        assertTrue(passwordValidatorUseCase.validatePassword(password).isValid());
    }

    @Test
    void givenInvalidPassword__thenReturnInvalidResponse() {
        final String password = "";
        assertFalse(passwordValidatorUseCase.validatePassword(password).isValid());
    }
}