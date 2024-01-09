package ru.erma.footballapiup.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PastOrPresentYearValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PastOrPresentYear {
    String message() default "Year should be past or present";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
