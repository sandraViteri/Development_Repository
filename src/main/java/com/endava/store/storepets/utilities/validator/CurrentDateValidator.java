package com.endava.store.storepets.utilities.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CurrentDateValidator implements ConstraintValidator<CurrentDateValidatorConstrain, Date> {

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        Date currentDate = Date
                .from(LocalDate.now().atStartOfDay(ZoneId.systemDefault())
                        .toInstant());
        return date.equals(currentDate);
    }
}
