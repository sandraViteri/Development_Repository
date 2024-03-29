package com.endava.store.storepets.utilities;

import com.endava.store.storepets.utilities.validator.AgeValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintValidatorContext;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AgeValidatorTest {
    @InjectMocks
    private AgeValidator ageValidator;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @Test
    public void VerifyUserIsLegalAge(){
        Date date = java.sql.Date.valueOf("2000-11-15");
        boolean result = ageValidator.isValid(date, constraintValidatorContext);
        Assert.assertTrue(result);
    }

    @Test
    public void VerifyUserIsNotLegalAge(){
        Date date = new Date();
        boolean result = ageValidator.isValid(date, constraintValidatorContext);
        Assert.assertFalse(result);
    }
}
