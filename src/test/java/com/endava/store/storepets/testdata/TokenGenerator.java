package com.endava.store.storepets.testdata;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenGenerator {

    public static String  generateToken(String userType) {
        String secret = "storePets";
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create().
                withClaim("user_type", userType).
                withExpiresAt(Date.from(ZonedDateTime.now().plusMinutes(60).toInstant())).sign(algorithm);
       return token;
    }
}
