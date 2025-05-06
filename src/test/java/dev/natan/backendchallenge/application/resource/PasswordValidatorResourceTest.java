package dev.natan.backendchallenge.application.resource;

import dev.natan.backendchallenge.application.dto.PasswordValidatorResponseDTO;
import dev.natan.backendchallenge.application.usecase.PasswordValidatorUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorResourceTest {
    @Test
    void givenRequest__thenValidate() {
        final String password = "password";
        final PasswordValidatorResource passwordValidatorResource = new PasswordValidatorResource(new PasswordValidatorUseCase());
        final PasswordValidatorResponseDTO passwordValidatorResponseDTO = passwordValidatorResource.validatePassword(password);
        assertNotNull(passwordValidatorResponseDTO);
        assertFalse(passwordValidatorResponseDTO.isValid());
    }
}