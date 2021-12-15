package com.endava.store.storepets.utilities.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CurrentDateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentDateValidatorConstrain {

    String message() default "No valid date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
