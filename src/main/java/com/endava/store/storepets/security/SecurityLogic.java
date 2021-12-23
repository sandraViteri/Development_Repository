package com.endava.store.storepets.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
public class SecurityLogic {

    public boolean verifyToken(String token) {

        boolean isTokenValid = true;

        DecodedJWT jwt = JWT.decode(token);

        if (!jwt.getExpiresAt().after(new Date())) {
            isTokenValid = false;
        }

        return isTokenValid;
    }

    public boolean checkUserType(String token, String userType) {
        DecodedJWT jwt = JWT.decode(token);
        Claim claim = jwt.getClaim("user_type");
        return Objects.equals(userType,claim.asString());
    }
}
