package com.endava.store.storepets.controller;

import com.endava.store.storepets.dto.CategoryDto;
import com.endava.store.storepets.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    @CrossOrigin
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        try {
            return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(path = {"/categories/{id}"})
    public ResponseEntity<CategoryDto> getCategory(@PathVariable(required = false, name = "id") UUID id) {
        try {
            return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping(path = "/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto dto) {
        try {
            dto = categoryService.saveCategory(dto);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PutMapping(path = "/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto dto) {
        try {
            dto = categoryService.saveCategory(dto);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @DeleteMapping(path = "/categories")
    public ResponseEntity<String> deleteCategory(@RequestParam(required = false, name = "id") UUID id) {
        try {
            categoryService.deleteCategory(id);
           return new ResponseEntity<>(id + " Was deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
          return new ResponseEntity<>(id+" Was not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


