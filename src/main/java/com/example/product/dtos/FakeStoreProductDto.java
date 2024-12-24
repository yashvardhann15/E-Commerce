package com.example.product.dtos;

import com.example.product.models.Category;
import com.example.product.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public Product toProduct(){
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);

        Category category1 = new Category();
        category1.setTitle(category);

        product.setCategory(category1);
        product.setImageUrl(image);

        return product;
    }
}
