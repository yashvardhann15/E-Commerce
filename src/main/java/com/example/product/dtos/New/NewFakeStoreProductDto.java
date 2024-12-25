package com.example.product.dtos.New;

import com.example.product.models.Product;
import com.example.product.models.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewFakeStoreProductDto {
    private int id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
    private String brand;
    private String model;
    private String color;
    private boolean popular;
    private int discount;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);

        Category categoryObj = new Category();
        categoryObj.setTitle(category);
        product.setCategory(categoryObj);

        product.setImageUrl(image);

        return product;
    }
}
