package com.example.product.services;



import java.util.List;

import com.example.product.Exceptions.ProductNotFoundException;
import com.example.product.dtos.CreateProductRequestDto;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.projections.ProjectProjection;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(long id) throws ProductNotFoundException;

    Product createProduct(String title, String description, String image, String category, double price);

    List<Product> findAllByCategory(Category category);

    List<Product> findAllByCategory_Title(String categoryTitle);

    List<ProjectProjection> getTitlesAndIdOfAllProductsWithGivenCategoryName(String categoryName);
}
