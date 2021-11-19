package com.endava.store.storepets.testutilities.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdTypeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdTypeValidatorConstrain {

    String message() default "No valid Id Type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}