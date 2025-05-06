package dev.natan.backendchallenge.domain.validator;

import dev.natan.backendchallenge.domain.model.ValidatedPassword;

public interface PasswordValidator {
    ValidatedPassword validate(String password);
}
