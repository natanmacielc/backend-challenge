package dev.natan.backendchallenge.application.resource;

import dev.natan.backendchallenge.application.dto.PasswordValidatorRequestDTO;
import dev.natan.backendchallenge.application.dto.PasswordValidatorResponseDTO;
import dev.natan.backendchallenge.application.usecase.PasswordValidatorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PasswordValidatorResource {
    private final PasswordValidatorUseCase passwordValidatorUseCase;

    @Autowired
    public PasswordValidatorResource(PasswordValidatorUseCase passwordValidatorUseCase) {
        this.passwordValidatorUseCase = passwordValidatorUseCase;
    }

    @PostMapping("password-validator")
    @ResponseStatus(HttpStatus.OK)
    public PasswordValidatorResponseDTO validatePassword(@RequestBody PasswordValidatorRequestDTO passwordValidatorRequest) {
        return passwordValidatorUseCase.validatePassword(passwordValidatorRequest.getPassword());
    }
}
