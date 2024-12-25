        package com.example.product.services;


import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.product.dtos.CreateProductRequestDto;
import com.example.product.dtos.FakeStoreProductDto;
import com.example.product.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
//@Primary
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate; //using this, you will be able to call 3rd party apis

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        String url = "https://fakestoreapi.com/products/";
        FakeStoreProductDto[] response = restTemplate.getForObject(url , FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<Product>();
        for (FakeStoreProductDto p : response) {
            products.add(p.toProduct());
        }
        if(products.isEmpty()) return null;
        return products;
    }

    @Override
    public Product getSingleProduct(long id) {
        /*
        call the external fakestore product api
        'https://fakestoreapi.com/products/1'
         */
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if(fakeStoreProductDto.getStatusCode() == HttpStatusCode.valueOf(500)){
            return null;
        }
        else {
            FakeStoreProductDto fake = fakeStoreProductDto.getBody();
            return fake.toProduct();
        }
    }

    @SuppressWarnings("null")
    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        FakeStoreProductDto fake = new FakeStoreProductDto();
        fake.setTitle(title);
        fake.setDescription(description);
        fake.setImage(image);
        fake.setCategory(category);
        fake.setPrice(price);

        String url = "https://fakestoreapi.com/products/";
        FakeStoreProductDto response = restTemplate.postForObject(url, fake, FakeStoreProductDto.class);
        if(response != null) return response.toProduct();
        return null;
    }
}
