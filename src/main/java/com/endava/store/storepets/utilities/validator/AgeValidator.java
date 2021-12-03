package com.endava.store.storepets.utilities.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class AgeValidator implements ConstraintValidator<AgeValidatorConstrain, Date> {

    @Override
    public boolean isValid(Date birthdayDate, ConstraintValidatorContext constraintValidatorContext) {
        Date date = Date
                .from(LocalDate.now().minus(18, ChronoUnit.YEARS).atStartOfDay(ZoneId.systemDefault())
                        .toInstant());
        return birthdayDate.before(date);
    }
}
