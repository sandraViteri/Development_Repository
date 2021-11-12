package com.endava.store.storepets.controller;

import com.endava.store.storepets.dto.UsersListDto;
import com.endava.store.storepets.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUsers() {
        try {
            return new ResponseEntity<>(usersService.getUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUser(@Valid @PathVariable(name = "id") UUID id) {
        try {
            return new ResponseEntity<>(usersService.getUser(id), HttpStatus.OK);
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
            return new ResponseEntity<>(usersService.saveUsers(listDto.getUsers()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }
//
//    @CrossOrigin("http://localhost")
//    @PutMapping(path = "/categories",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Object> updateCategory(@RequestBody CategoryDto dto) {
//        try {
//           return new ResponseEntity<>(categoryService.updateCategory(dto), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @CrossOrigin("http://localhost")
//    @DeleteMapping(path = "/categories")
//    public ResponseEntity<Object> deleteCategory(@RequestParam(name = "id") UUID id) {
//        try {
//            categoryService.deleteCategory(id);
//            return new ResponseEntity<>(id + " Was deleted", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
}


