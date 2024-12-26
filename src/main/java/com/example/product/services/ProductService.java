package com.example.product.services;



import java.util.List;

import com.example.product.Exceptions.ProductNotFoundException;
import com.example.product.dtos.CreateProductRequestDto;
import com.example.product.models.Product;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(long id) throws ProductNotFoundException;

    Product createProduct(String title, String description, String image, String category, double price);
}
