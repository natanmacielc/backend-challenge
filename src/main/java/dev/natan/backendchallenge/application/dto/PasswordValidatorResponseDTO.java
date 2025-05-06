package dev.natan.backendchallenge.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.natan.backendchallenge.domain.model.ValidationCriteria;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PasswordValidatorResponseDTO(boolean isValid, List<ValidationCriteria> criteria) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}

