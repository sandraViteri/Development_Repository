package com.endava.store.storepets.testutilities;

import com.endava.store.storepets.testutilities.validations.IdTypeValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
@SpringBootTest
public class IdTypeValidatorTest {
    @InjectMocks
    private IdTypeValidator idTypeValidator;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;
    private final String idType;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public IdTypeValidatorTest(String idType) {
        this.idType = idType;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"CC"}, {"CE"}, {"PE"}};
        return Arrays.asList(data);
    }

    @Test
    public void testWhenIdTypeIsCC() {
        boolean result = idTypeValidator.isValid(idType, constraintValidatorContext);
        Assertions.assertTrue(result);
    }

    @Test
    public void testWhenIdTypeIsNotValid() {
        boolean result = idTypeValidator.isValid("CK", constraintValidatorContext);
        Assertions.assertFalse(result);
    }
}
