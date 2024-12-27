
package com.example.product.services;

import com.example.product.dtos.New.NewFakeStoreApiResponseListDto;
import com.example.product.models.Category;
import com.example.product.projections.ProjectProjection;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.product.dtos.New.NewFakeStoreApiResponseDto;
import com.example.product.models.Product;
import java.util.List;

@Service("NewFakeStoreApi")
//@Primary
public class NewFakeStoreApi implements ProductService{
    RestTemplate restTemplate;
    public NewFakeStoreApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("null")
    @Override
    public List<Product> getAllProducts(){
        String url = "https://fakestoreapi.in/api/products";
        NewFakeStoreApiResponseListDto response = restTemplate.getForObject(url , NewFakeStoreApiResponseListDto.class);
        if(response != null){
            return response.toProdList();
        }
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
    public Product createProduct(String title, String description, String image, String category, double price){
        return null;
    }

    @Override
    public List<Product> findAllByCategory(Category category){
//        return productRepository.findAllByCategory(category);
        return null;
    }

    @Override
    public List<Product> findAllByCategory_Title(String CategoryName){
//        return productRepository.findAllByCategory_Name(CategoryName);
        return null;
    }

    @Override
    public List<ProjectProjection> getTitlesAndIdOfAllProductsWithGivenCategoryName(String categoryName){
        return null;
    }
}
