package dev.natan.backendchallenge.application.dto;

import java.io.Serial;
import java.io.Serializable;

public class PasswordValidatorRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String password;

    public PasswordValidatorRequestDTO() {}

    public PasswordValidatorRequestDTO(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

