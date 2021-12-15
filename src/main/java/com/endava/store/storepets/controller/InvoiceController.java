package com.endava.store.storepets.controller;

import com.endava.store.storepets.dto.InvoiceDto;
import com.endava.store.storepets.dto.InvoiceListDto;
import com.endava.store.storepets.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/invoices",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getInvoices() {
        try {
            return new ResponseEntity<>(invoiceService.getInvoices(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/invoices/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getInvoice(@Valid @PathVariable(name = "id") UUID id) {
        try {
            return new ResponseEntity<>(invoiceService.getInvoice(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @PostMapping(path = "/invoices",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveInvoices(@RequestBody @Valid InvoiceListDto listDto) {
        try {
            return new ResponseEntity<>(invoiceService.saveInvoices(listDto.getInvoices()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost")
    @PutMapping(path = "/invoices",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateInvoice(@RequestBody InvoiceDto dto) {
        try {
           return new ResponseEntity<>(invoiceService.updateInvoices(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @DeleteMapping(path = "/invoices")
    public ResponseEntity<Object> deleteInvoice(@RequestParam(name = "id") UUID id) {
        try {
            invoiceService.deleteInvoice(id);
            return new ResponseEntity<>(String.format("%s Was deleted", id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}


