package com.endava.store.storepets.testutilities.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeValidatorConstrain {

    String message() default "No valid date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
