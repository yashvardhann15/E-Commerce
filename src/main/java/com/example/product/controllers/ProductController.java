package com.example.product.controllers;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.example.product.dtos.CreateProductRequestDto;
import com.example.product.models.Product;
import com.example.product.services.ProductService;

import java.util.List;


@RestController
public class ProductController {

    public ProductService productService;

    public ProductController(@Qualifier("NewFakeStoreApi") ProductService productService){

        this.productService = productService;
    }
    /*
    at the end of the day
    api = method in my controller
     */

    /*
    GET /products
     */
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    /*
    GET /products/{id}
     */
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id){
        return productService.getSingleProduct(id);
    }

    /*
    Create a product
    {
        title :
        description:
        price:
        category:
    } => payload / request body
    POST /products
     */
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto);
    }
}
