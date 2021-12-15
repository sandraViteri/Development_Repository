package com.endava.store.storepets.testdata;

import com.endava.store.storepets.model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsersData {
    public static List<UserModel> getUsersModel() {
        List<UserModel> listModel = new ArrayList<>();
        listModel.add(new UserModel(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6362"), "1113519304",
                "CC", "testNameModelOne", "testLastNameOne", "testAddressOne",
                java.sql.Date.valueOf("2017-11-15"), "MARCH_155@HOTAMIL.COM",
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6362"), "3182587061"));
        listModel.add(new UserModel(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6362"), "1113519304",
                "CC", "testNameModelOne", "testLastNameOne", "testAddressOne",
                java.sql.Date.valueOf("2017-11-15"), "MARCH_155@HOTAMIL.COM",
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6362"), "3182587061"));
        return listModel;
    }
}
