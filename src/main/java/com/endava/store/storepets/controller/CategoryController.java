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

    @CrossOrigin
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        try {
            return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(path = {"/categories/{id}"})
    public ResponseEntity<CategoryDto> getCategory(@PathVariable(required = false, name = "id") UUID id) {
        try {
            return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping(path = "/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDto>> saveCategory(@RequestBody List<CategoryDto> listDto) {
        try {
            return new ResponseEntity<>(categoryService.saveCategories(listDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @CrossOrigin
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

    @CrossOrigin
    @DeleteMapping(path = "/categories")
    public ResponseEntity<String> deleteCategory(@RequestParam(required = false, name = "id") UUID id) {
        try {
            categoryService.deleteCategory(id);
            return new ResponseEntity<>(id + " Was deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(id + " Was not deleted", HttpStatus.NOT_FOUND);
        }
    }
}


