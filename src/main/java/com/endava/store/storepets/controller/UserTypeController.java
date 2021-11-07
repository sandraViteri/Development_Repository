package com.endava.store.storepets.controller;

import com.endava.store.storepets.dto.UserTypeDto;
import com.endava.store.storepets.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")

public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/usertypes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUserTypes() {
        try {
            return new ResponseEntity<>(userTypeService.getUserTypes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/usertypes/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUserType(@PathVariable(name = "id") UUID id) {
        try {
            return new ResponseEntity<>(userTypeService.getUserType(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @PostMapping(path = "/usertypes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUserTypes(@RequestBody List<UserTypeDto> listDto) {
        try {
            return new ResponseEntity<>(userTypeService.saveUserTypes(listDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @CrossOrigin("http://localhost")
    @PutMapping(path = "/usertypes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUserType(@RequestBody UserTypeDto dto) {
        try {
           return new ResponseEntity<>(userTypeService.updateUserType(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @DeleteMapping(path = "/usertypes")
    public ResponseEntity<Object> deleteUserType(@RequestParam(name = "id") UUID id) {
        try {
            userTypeService.deleteUserType(id);
            return new ResponseEntity<>(id + " Was deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}


