package dev.natan.backendchallenge.application.resource;

import dev.natan.backendchallenge.application.dto.PasswordValidatorResponseDTO;
import dev.natan.backendchallenge.application.usecase.PasswordValidatorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordValidatorResource {
    private final PasswordValidatorUseCase passwordValidatorUseCase;

    @Autowired
    public PasswordValidatorResource(PasswordValidatorUseCase passwordValidatorUseCase) {
        this.passwordValidatorUseCase = passwordValidatorUseCase;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PasswordValidatorResponseDTO validatePassword(@RequestParam String password) {
        return passwordValidatorUseCase.validatePassword(password);
    }
}
