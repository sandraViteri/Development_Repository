package com.endava.store.storepets.security;

import com.endava.store.storepets.testdata.TokenGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SecurityLogicTest {
    SecurityLogic securityLogic;

    @Before
    public void SetUp() {
        securityLogic = new SecurityLogic();
    }

    @Test
    public void VerifyTokenWhenTokenIsValid() {
        String token = TokenGenerator.generateToken("Client");
        boolean result = securityLogic.verifyToken(token);
        Assert.assertTrue(result);
    }

    @Test
    public void VerifyTokenWhenTokenIsNotValid() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX3R5cGUiOiJDbGllbnQiLCJleHAiOjE2NDAwMzg4NTJ9." +
                "_SnpT5cyYuJgFxKYRvS36jz-WIzdvKdZy2uCogk3TQ}";
        boolean result = securityLogic.verifyToken(token);
        Assert.assertFalse(result);
    }

    @Test
    public void VerifyTokenWhenTokenIsClientRol() {
        String token = TokenGenerator.generateToken("Client");
        ;
        boolean result = securityLogic.checkUserType(token, "Client");
        Assert.assertTrue(result);
    }

    @Test
    public void VerifyTokenWhenTokenIsAdminRol() {
        String token = TokenGenerator.generateToken("Admin");
        ;
        boolean result = securityLogic.checkUserType(token, "Admin");
        Assert.assertTrue(result);
    }

    @Test
    public void VerifyTokenWhenTokenIsDifferentToClientOrAdmin() {
        String token = TokenGenerator.generateToken("Nothing");
        boolean result = securityLogic.checkUserType(token, "Admin");
        Assert.assertFalse(result);
    }

    @Test
    public void VerifyTokenWhenTokenIsExpired() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX3R5cGUiOiJDbGllbnQiLCJleHAiOjE2NDAwOTc2ODh9." +
                "lo6GgIEuXUaEkAnp92zDCEDOTwBi7cv8FlqcERe5Xis";
        boolean result = securityLogic.verifyToken(token);
        Assert.assertFalse(result);
    }
}
