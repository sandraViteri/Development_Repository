package com.endava.store.storepets.controller;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/categories",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCategories() {
        try {
            return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/categories/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCategory(@PathVariable(name = "id") UUID id) {
        try {
            return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @PostMapping(path = "/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCategories(@RequestBody List<CategoryDto> listDto) {
        try {
            return new ResponseEntity<>(categoryService.saveCategories(listDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @CrossOrigin("http://localhost")
    @PutMapping(path = "/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCategory(@RequestBody CategoryDto dto) {
        try {
           return new ResponseEntity<>(categoryService.updateCategory(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @DeleteMapping(path = "/categories")
    public ResponseEntity<Object> deleteCategory(@RequestParam(name = "id") UUID id) {
        try {
            categoryService.deleteCategory(id);
            return new ResponseEntity<>(id + " Was deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}


