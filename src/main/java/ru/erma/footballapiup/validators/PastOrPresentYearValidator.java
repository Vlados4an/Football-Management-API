package ru.erma.footballapiup.validators;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class PastOrPresentYearValidator implements ConstraintValidator<PastOrPresentYear, Integer> {
    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        if (year == null) {
            return true;
        }
        return year <= Year.now().getValue();
    }
}
