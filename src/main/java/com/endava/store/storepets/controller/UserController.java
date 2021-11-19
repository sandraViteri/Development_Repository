package com.endava.store.storepets.controller;

import com.endava.store.storepets.dto.UserDto;
import com.endava.store.storepets.dto.UsersListDto;
import com.endava.store.storepets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUsers() {
        try {
            return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUser(@Valid @PathVariable(name = "id") UUID id) {
        try {
            return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @PostMapping(path = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUsers(@RequestBody @Valid UsersListDto listDto) {
        try {
            return new ResponseEntity<>(userService.saveUsers(listDto.getUsers()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost")
    @PutMapping(path = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUser(@RequestBody UserDto dto) {
        try {
           return new ResponseEntity<>(userService.updateUsers(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @DeleteMapping(path = "/users")
    public ResponseEntity<Object> deleteUser(@RequestParam(name = "id") UUID id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(String.format("%s Was deleted", id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}


