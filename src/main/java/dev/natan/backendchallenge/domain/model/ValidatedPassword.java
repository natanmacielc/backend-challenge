package dev.natan.backendchallenge.domain.model;

import java.util.List;

public class ValidatedPassword {
    private final boolean isValid;
    private List<ValidationCriteria> criteria;

    public ValidatedPassword(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<ValidationCriteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<ValidationCriteria> criteria) {
        this.criteria = criteria;
    }
}
