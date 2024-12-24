package com.example.product.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewFakeStoreApiResponseDto {
    private String status;
    private String message;
    private NewFakeStoreProductDto product;
}
