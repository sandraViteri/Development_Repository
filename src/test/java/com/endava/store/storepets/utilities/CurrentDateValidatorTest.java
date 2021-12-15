package com.endava.store.storepets.utilities;

import com.endava.store.storepets.utilities.validator.CurrentDateValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CurrentDateValidatorTest {
    @InjectMocks
    private CurrentDateValidator CurrentDateValidator;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @Test
    public void VerifyDateIsNotCurrentDate(){
        Date date = java.sql.Date.valueOf("2000-11-15");
        boolean result = CurrentDateValidator.isValid(date, constraintValidatorContext);
        Assert.assertFalse(result);
    }

    @Test
    public void VerifyDateIsCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dtf.format(LocalDateTime.now());
        boolean result = CurrentDateValidator.isValid(java.sql.Date.valueOf(dtf.format(LocalDateTime.now())),
                constraintValidatorContext);
        Assert.assertTrue(result);
    }
}
