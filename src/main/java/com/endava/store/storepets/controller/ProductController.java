package com.endava.store.storepets.controller;

import com.endava.store.storepets.dto.ProductDto;
import com.endava.store.storepets.dto.ProductsListDto;
import com.endava.store.storepets.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/products",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getproducts() {
        try {
            return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @GetMapping(path = "/products/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProduct(@Valid @PathVariable(name = "id") UUID id) {
        try {
            return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @PostMapping(path = "/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveproducts(@RequestBody @Valid ProductsListDto listDto) {
        try {
            return new ResponseEntity<>(productService.saveProducts(listDto.getProducts()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost")
    @PutMapping(path = "/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDto dto) {
        try {
           return new ResponseEntity<>(productService.updateProducts(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost")
    @DeleteMapping(path = "/products")
    public ResponseEntity<Object> deleteProduct(@RequestParam(name = "id") UUID id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(String.format("%s Was deleted", id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}


