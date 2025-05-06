package dev.natan.backendchallenge.domain.validator;

import dev.natan.backendchallenge.domain.model.ValidatedPassword;
import dev.natan.backendchallenge.domain.model.ValidationCriteria;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class PasswordValidatorImpl implements PasswordValidator {
    private static final List<Function<String, ValidationCriteria>> VALIDATION_CRITERIA = List.of(
            PasswordValidatorImpl::isValidLength,
            PasswordValidatorImpl::hasAtLeastOneDigit,
            PasswordValidatorImpl::hasAtLeastOneUpperCaseLetter,
            PasswordValidatorImpl::hasAtLeastOneLowerCaseLetter,
            PasswordValidatorImpl::hasAtLeastOneSpecialCharacter,
            PasswordValidatorImpl::notHasRepeatedCharacter,
            PasswordValidatorImpl::notHasIllegalCharacter
    );

    public ValidatedPassword validate(String password) {
        final List<ValidationCriteria> validationCriteria = VALIDATION_CRITERIA.stream()
                .map(criteria -> criteria.apply(password))
                .toList();
        return validatePassword(validationCriteria);
    }

    private static ValidatedPassword validatePassword(List<ValidationCriteria> validationCriteria) {
        final ValidatedPassword validatedPassword = new ValidatedPassword(validationCriteria.stream().allMatch(ValidationCriteria::isValid));
        if (!validatedPassword.isValid()) {
            validatedPassword.setCriteria(validationCriteria.stream()
                    .filter(criteria -> !criteria.isValid())
                    .toList());
        }
        return validatedPassword;
    }

    private static ValidationCriteria isValidLength(String password) {
        final int minimumPasswordLength = 9;
        return new ValidationCriteria("isValidLength", password.length() >= minimumPasswordLength);
    }

    private static ValidationCriteria hasAtLeastOneDigit(String password) {
        final String digitRegex = ".*\\d.*";
        return new ValidationCriteria("hasAtLeastOneDigit", password.matches(digitRegex));
    }

    private static ValidationCriteria hasAtLeastOneUpperCaseLetter(String password) {
        final String upperCaseLetterRegex = ".*[A-Z].*";
        return new ValidationCriteria("hasAtLeastOneUpperCaseLetter", password.matches(upperCaseLetterRegex));
    }

    private static ValidationCriteria hasAtLeastOneLowerCaseLetter(String password) {
        final String lowerCaseLetterRegex = ".*[a-z].*";
        return new ValidationCriteria("hasAtLeastOneLowerCaseLetter", password.matches(lowerCaseLetterRegex));
    }

    private static ValidationCriteria hasAtLeastOneSpecialCharacter(String password) {
        final Set<String> specialCharacters = Set.of("!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+");
        return new ValidationCriteria("hasAtLeastOneSpecialCharacter", specialCharacters.stream().anyMatch(password::contains));
    }

    private static ValidationCriteria notHasRepeatedCharacter(String password) {
        final String repeatedCharacterRegex = ".*(.).*\\1.*";
        return new ValidationCriteria("notHasRepeatedCharacter", !password.matches(repeatedCharacterRegex));
    }

    private static ValidationCriteria notHasIllegalCharacter(String password) {
        final Set<String> illegalCharacters = Set.of(" ");
        return new ValidationCriteria("notHasIllegalCharacter", illegalCharacters.stream().noneMatch(password::contains));
    }
}
