package com.endava.store.storepets.security;

import com.endava.store.storepets.constants.Constants;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(1)
public class SecurityFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        List<String> adminList = getAdminList();
        SecurityLogic securityLogic = new SecurityLogic();
        String token = request.getHeader("token");
        String uri = request.getMethod() + request.getRequestURI();
        if (!securityLogic.verifyToken(token) || !securityLogic.checkUserType(token, "Client") &&
                !securityLogic.checkUserType(token, "Admin")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else if (securityLogic.checkUserType(token, "Client") && adminList.contains(uri)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            chain.doFilter(request, response);
        }
    }

    public List<String> getAdminList() {
        List<String> adminList = new ArrayList<>();
        adminList.add(Constants.METHOD_PUT + Constants.USERS_URI);
        adminList.add(Constants.METHOD_DELETE + Constants.USERS_URI);
        adminList.add(Constants.METHOD_POST + Constants.USERS_URI);
        adminList.add(Constants.METHOD_PUT + Constants.PRODUCTS_URI);
        adminList.add(Constants.METHOD_DELETE + Constants.PRODUCTS_URI);
        adminList.add(Constants.METHOD_POST + Constants.PRODUCTS_URI);
        adminList.add(Constants.METHOD_PUT + Constants.INVOICES_URI);
        adminList.add(Constants.METHOD_DELETE + Constants.INVOICES_URI);
        adminList.add(Constants.METHOD_POST + Constants.INVOICES_URI);
        adminList.add(Constants.METHOD_PUT + Constants.DETAILS_URI);
        adminList.add(Constants.METHOD_DELETE + Constants.DETAILS_URI);
        adminList.add(Constants.METHOD_POST + Constants.DETAILS_URI);
        adminList.add(Constants.METHOD_PUT + Constants.CATEGORIES_URI);
        adminList.add(Constants.METHOD_DELETE + Constants.CATEGORIES_URI);
        adminList.add(Constants.METHOD_POST + Constants.CATEGORIES_URI);
        adminList.add(Constants.METHOD_PUT + Constants.USER_TYPES_URI);
        adminList.add(Constants.METHOD_DELETE + Constants.USER_TYPES_URI);
        adminList.add(Constants.METHOD_POST + Constants.USER_TYPES_URI);
        adminList.add(Constants.METHOD_PUT + Constants.PAYMENTS_MODE_URI);
        adminList.add(Constants.METHOD_DELETE + Constants.PAYMENTS_MODE_URI);
        adminList.add(Constants.METHOD_POST + Constants.PAYMENTS_MODE_URI);

        return adminList;
    }
}
