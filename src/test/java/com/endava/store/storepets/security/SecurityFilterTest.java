package com.endava.store.storepets.security;

import com.endava.store.storepets.constants.Constants;
import com.endava.store.storepets.testdata.TokenGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SecurityFilterTest {

    @InjectMocks
    private final SecurityFilter filter = new SecurityFilter();

    @Test
    public void TestFilterInternalWhenTokenIsValid()
            throws ServletException, IOException {
        String token = TokenGenerator.generateToken("Client");
        MockHttpServletRequest httpRequest = new MockHttpServletRequest();
        httpRequest.addHeader("token", token);
        httpRequest.setRequestURI(Constants.USERS_URI);
        httpRequest.setMethod("GET");
        MockHttpServletResponse httpResponse = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();
        filter.doFilter(httpRequest, httpResponse, filterChain);
        assertThat(httpResponse.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void TestFilterInternalWhenTokenIsNotValid()
            throws ServletException, IOException {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX3R5cGUiOiJDbGllbnQiLCJleHAiOjE2NDAwOTc2ODh9." +
                "lo6GgIEuXUaEkAnp92zDCEDOTwBi7cv8FlqcERe5Xis";
        MockHttpServletRequest httpRequest = new MockHttpServletRequest();
        httpRequest.addHeader("token", token);
        httpRequest.setRequestURI(Constants.USERS_URI);
        httpRequest.setMethod("GET");
        MockHttpServletResponse httpResponse = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();
        filter.doFilter(httpRequest, httpResponse, filterChain);
        assertThat(httpResponse.getStatus()).isEqualTo(HttpStatus.UNAUTHORIZED.value());
    }

    @Test
    public void TestFilterInternalWhenUserTypeIsNotValid()
            throws ServletException, IOException {
        String token = TokenGenerator.generateToken("pass");
        MockHttpServletRequest httpRequest = new MockHttpServletRequest();
        httpRequest.addHeader("token", token);
        httpRequest.setRequestURI(Constants.USERS_URI);
        httpRequest.setMethod("GET");
        MockHttpServletResponse httpResponse = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();
        filter.doFilter(httpRequest, httpResponse, filterChain);
        assertThat(httpResponse.getStatus()).isEqualTo(HttpStatus.UNAUTHORIZED.value());
    }

    @Test
    public void TestFilterInternalWhenTokenIsAdmin()
            throws ServletException, IOException {
        String token = TokenGenerator.generateToken("Admin");
        MockHttpServletRequest httpRequest = new MockHttpServletRequest();
        httpRequest.addHeader("token", token);
        httpRequest.setRequestURI(Constants.USERS_URI);
        httpRequest.setMethod(Constants.METHOD_PUT);
        MockHttpServletResponse httpResponse = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();
        filter.doFilter(httpRequest, httpResponse, filterChain);
        assertThat(httpResponse.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void TestFilterInternalWhenUrlIsNotAllow()
            throws ServletException, IOException {
        String token = TokenGenerator.generateToken("Client");
        MockHttpServletRequest httpRequest = new MockHttpServletRequest();
        httpRequest.addHeader("token", token);
        httpRequest.setRequestURI(Constants.USERS_URI);
        httpRequest.setMethod(Constants.METHOD_POST);
        MockHttpServletResponse httpResponse = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();
        filter.doFilter(httpRequest, httpResponse, filterChain);
        assertThat(httpResponse.getStatus()).isEqualTo(HttpStatus.UNAUTHORIZED.value());
    }
}
