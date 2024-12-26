package com.example.product.controllers;


import com.example.product.Exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.product.dtos.CreateProductRequestDto;
import com.example.product.dtos.ErrorDto;
import com.example.product.models.Product;
import com.example.product.services.ProductService;

import java.util.List;


@RestController
public class ProductController {

    public ProductService productService;

    public ProductController(@Qualifier("SelfProductService") ProductService productService){

        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id)  {
        Product p = productService.getSingleProduct(id);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(p , HttpStatus.OK);

        return responseEntity;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto.getTitle(), createProductRequestDto.getDescription(), createProductRequestDto.getImage(), createProductRequestDto.getCategory(), createProductRequestDto.getPrice());
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException e){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage(e.getMessage());
//
//        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }
}
