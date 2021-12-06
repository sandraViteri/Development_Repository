package com.endava.store.storepets.controller;

import com.endava.store.storepets.dto.PaymentModeDto;
import com.endava.store.storepets.service.PaymentModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")

public class PaymentModeController {

    @Autowired
    private PaymentModeService paymentModeService;

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/paymentmodes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPaymentModes() {
        try {
            return new ResponseEntity<>(paymentModeService.getPaymentModes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/paymentmodes/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPaymentMode(@PathVariable(name = "id") UUID id) {
        try {
            return new ResponseEntity<>(paymentModeService.getPaymentMode(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @PostMapping(path = "/paymentmodes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> savePaymentModes(@RequestBody List<PaymentModeDto> listDto) {
        try {
            return new ResponseEntity<>(paymentModeService.savePaymentModes(listDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @CrossOrigin("http://localhost")
    @PutMapping(path = "/paymentmodes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updatePaymentMode(@RequestBody PaymentModeDto dto) {
        try {
           return new ResponseEntity<>(paymentModeService.updatePaymentMode(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @DeleteMapping(path = "/paymentmodes")
    public ResponseEntity<Object> deletePaymentMode(@RequestParam(name = "id") UUID id) {
        try {
            paymentModeService.deletePaymentMode(id);
            return new ResponseEntity<>(String.format("%s Was deleted", id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}


