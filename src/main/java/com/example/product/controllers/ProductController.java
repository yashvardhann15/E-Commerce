package com.example.product.controllers;


import com.example.product.Exceptions.ProductNotFoundException;
import com.example.product.models.Category;
import com.example.product.projections.ProjectProjection;
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

    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){

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

//    @GetMapping("/products/categoryC")
//    public List<Product> getProductsByCategory(@RequestBody Category category){
//        return productService.findAllByCategory(category);
//    }

    @GetMapping("/products/category/{categoryTitle}")
    public List<Product> getProductsByCategory(@PathVariable("categoryTitle") String category){
        return productService.findAllByCategory_Title(category);
    }

    @GetMapping("/products/category/{categoryName}/titles")
    public List<ProjectProjection> getTitlesOfAllProductsWithGivenCategoryName(@PathVariable("categoryName") String categoryName){
        return productService.getTitlesAndIdOfAllProductsWithGivenCategoryName(categoryName);
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
