
package com.example.product.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.product.dtos.CreateProductRequestDto;
import com.example.product.dtos.NewFakeStoreApiResponseDto;
import com.example.product.dtos.NewFakeStoreProductDto;
import com.example.product.models.Product;
import java.util.List;

@Service("NewFakeStoreApi")
@Primary
public class NewFakeStoreApi implements ProductService{
    RestTemplate restTemplate;
    public NewFakeStoreApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts(){
        return null;
    }

    @SuppressWarnings("null")
    @Override
    public Product getSingleProduct(long id){
        String url = "https://fakestoreapi.in/api/products/" + id;
        NewFakeStoreApiResponseDto response = restTemplate.getForObject(url , NewFakeStoreApiResponseDto.class);
        if (response != null && response.getProduct() != null) {
            return response.getProduct().toProduct();
        }
        return null; 
    }

    @Override
    public Product createProduct(CreateProductRequestDto createProductRequestDto){
        return null;
    }
}
