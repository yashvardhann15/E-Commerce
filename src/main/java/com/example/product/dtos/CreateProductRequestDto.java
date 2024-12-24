package com.example.product.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
