package com.endava.store.storepets.testdata;

import com.endava.store.storepets.model.DetailModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DetailData {
    public static List<DetailModel> getDetailsModel() {
        List<DetailModel> listModel = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       dtf.format(LocalDateTime.now());
        listModel.add(new DetailModel(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6355"),
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6399"),
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6388"),
                                5, 10000.00));
        listModel.add(new DetailModel(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6344"),
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6333"),
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6399"),
                5, 10000.00));
        return listModel;
    }
}
