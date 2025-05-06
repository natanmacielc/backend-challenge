package dev.natan.backendchallenge.domain.validator;

import dev.natan.backendchallenge.domain.model.ValidatedPassword;
import dev.natan.backendchallenge.domain.model.ValidationCriteria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorImplTest {
    private final PasswordValidator passwordValidator = new PasswordValidatorImpl();

    @Test
    void givenValidPassword__thenReturnIsValid() {
        final String password = "ZbTp1fo@#";
        assertTrue(passwordValidator.validate(password).isValid());
    }

    @ParameterizedTest
    @MethodSource("provideInvalidPassword")
    void givenInvalidPassword__thenReturnCriteria(String password, String criteria) {
        final ValidatedPassword validatedPassword = passwordValidator.validate(password);
        final ValidationCriteria validationCriteria = validatedPassword.getCriteria().getFirst();
        assertEquals(criteria, validationCriteria.criteria());
        assertFalse(validationCriteria.isValid());
    }

    private static Stream<Arguments> provideInvalidPassword() {
        return Stream.of(
                Arguments.of("ZbTp1fo@", "isValidLength"),
                Arguments.of("ZbTp#$fo@", "hasAtLeastOneDigit"),
                Arguments.of("zbtp1$fo@", "hasAtLeastOneUpperCaseLetter"),
                Arguments.of("ZBTP1$FO@", "hasAtLeastOneLowerCaseLetter"),
                Arguments.of("ZbTp1foew", "hasAtLeastOneSpecialCharacter"),
                Arguments.of("ZbTp1#foo", "notHasRepeatedCharacter"),
                Arguments.of("ZbTp1fo @", "notHasIllegalCharacter")
        );
    }
}