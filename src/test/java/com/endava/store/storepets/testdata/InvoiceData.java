package com.endava.store.storepets.testdata;

import com.endava.store.storepets.model.InvoiceModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InvoiceData {
    public static List<InvoiceModel> getInvoicesModel() {
        List<InvoiceModel> listModel = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       dtf.format(LocalDateTime.now());
        listModel.add(new InvoiceModel(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6355"),
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6399"),
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6388"),
                java.sql.Date.valueOf(dtf.format(LocalDateTime.now())),
                50000.00, 10000.00, 5000.00));
        listModel.add(new InvoiceModel(UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6355"),
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6399"),
                UUID.fromString("09df742e-33a3-11ec-8f02-6949411d6388"),
                java.sql.Date.valueOf(dtf.format(LocalDateTime.now())),
                60000.00, 8000.00, 6000.00));
        return listModel;
    }
}
