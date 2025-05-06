package dev.natan.backendchallenge.application.usecase;

import dev.natan.backendchallenge.application.dto.PasswordValidatorResponseDTO;
import dev.natan.backendchallenge.domain.model.ValidatedPassword;
import dev.natan.backendchallenge.domain.validator.PasswordValidator;
import dev.natan.backendchallenge.domain.validator.PasswordValidatorImpl;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidatorUseCase {
    private final PasswordValidator passwordValidator = new PasswordValidatorImpl();

    public PasswordValidatorResponseDTO validatePassword(String password) {
        final ValidatedPassword validatedPassword = passwordValidator.validate(password);
        return new PasswordValidatorResponseDTO(validatedPassword.isValid(), validatedPassword.getCriteria());
    }
}
