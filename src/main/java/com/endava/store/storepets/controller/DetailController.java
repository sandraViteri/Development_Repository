package com.endava.store.storepets.controller;

import com.endava.store.storepets.dto.DetailDto;
import com.endava.store.storepets.dto.DetailListDto;
import com.endava.store.storepets.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class DetailController {

    @Autowired
    private DetailService invoiceService;

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/details",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getDetails() {
        try {
            return new ResponseEntity<>(invoiceService.getDetails(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/details/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getDetail(@Valid @PathVariable(name = "id") UUID id) {
        try {
            return new ResponseEntity<>(invoiceService.getDetail(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @PostMapping(path = "/details",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveDetails(@RequestBody @Valid DetailListDto listDto) {
        try {
            return new ResponseEntity<>(invoiceService.saveDetails(listDto.getDetails()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost")
    @PutMapping(path = "/details",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateDetail(@RequestBody DetailDto dto) {
        try {
           return new ResponseEntity<>(invoiceService.updateDetails(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @DeleteMapping(path = "/details")
    public ResponseEntity<Object> deleteDetail(@RequestParam(name = "id") UUID id) {
        try {
            invoiceService.deleteDetail(id);
            return new ResponseEntity<>(String.format("%s Was deleted", id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}


