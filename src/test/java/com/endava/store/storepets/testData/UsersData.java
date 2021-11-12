package com.endava.store.storepets.testData;

import com.endava.store.storepets.model.UsersModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsersData {
    public static List<UsersModel> getUsersModel() {
        List<UsersModel> listModel = new ArrayList<>();
        listModel.add(new UsersModel(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6362"),"1113519304",
                "CC", "testNameModelOne", "testLastNameOne","testAddressOne",
                java.sql.Date.valueOf("2017-11-15"),"MARCH_155@HOTAMIL.COM",
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6362"),"3182587061"));
        listModel.add(new UsersModel(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6362"),"1113519304",
                "CC", "testNameModelOne", "testLastNameOne", "testAddressOne",
                java.sql.Date.valueOf("2017-11-15"),"MARCH_155@HOTAMIL.COM",
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6362"), "3182587061"));
        return listModel;
    }
}
