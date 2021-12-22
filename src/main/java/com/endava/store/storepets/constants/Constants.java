package com.endava.store.storepets.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final String USER = "User";
    public static final String CATEGORY = "Category";
    public static final String USER_TYPE = "User Type";
    public static final String PAYMENT_MODE = "Payment Mode";
    public static final String PRODUCT = "Product";
    public static final String INVOICE = "Invoice";
    public static final String DETAIL = "Detail";
    public static final String USER_ALREADY_EXIST_MESSAGE = "The user %s already exist!";
    public static final String NOT_FOUND_MESSAGE = "The %s was not found!";
    public static final String PRODUCTS_URI = "/api/products";
    public static final String INVOICES_URI = "/api/invoices";
    public static final String DETAILS_URI = "/api/details";
    public static final String CATEGORIES_URI = "/api/categories";
    public static final String USER_TYPES_URI = "/api/usertypes";
    public static final String PAYMENTS_MODE_URI = "/api/paymentmodes";
    public static final String USERS_URI = "/api/users";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_DELETE = "DEL";

}
