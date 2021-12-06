package com.endava.store.storepets.utilities.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdTypeValidator implements ConstraintValidator<IdTypeValidatorConstrain, String> {

    @Override
    public boolean isValid(String idType, ConstraintValidatorContext constraintValidatorContext) {
        return idType.equalsIgnoreCase("CC") || idType.equalsIgnoreCase("CE") ||
                idType.equalsIgnoreCase("PE");
    }
}
