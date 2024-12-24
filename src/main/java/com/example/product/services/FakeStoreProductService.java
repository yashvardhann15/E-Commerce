        package com.example.product.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.product.dtos.CreateProductRequestDto;
import com.example.product.dtos.FakeStoreProductDto;
import com.example.product.models.Product;

import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate; //using this, you will be able to call 3rd party apis

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(long id) {
        /*
        call the external fakestore product api
        'https://fakestoreapi.com/products/1'
         */
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);


        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product createProduct(CreateProductRequestDto createProductRequestDto) {
        return null;
    }
}
