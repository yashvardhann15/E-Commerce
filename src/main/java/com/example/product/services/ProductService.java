package com.example.product.services;



import java.util.List;

import com.example.product.dtos.CreateProductRequestDto;
import com.example.product.models.Product;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(long id);

    Product createProduct(CreateProductRequestDto createProductRequestDto);
}
