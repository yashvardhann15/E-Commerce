package com.example.product.services;

import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.repositories.CategoryRepository;
import com.example.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    public SelfProductService(CategoryRepository categoryRepository, ProductRepository productRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts(){
        return null;
    }
    @Override
    public Product getSingleProduct(long id) {
        return null;
    }
    @Override
    public Product createProduct(String title, String description, String image, String category, double price){
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setPrice(price);
//        product.getCreatedAt(LocalDateTime.now());
        Category checkCategory = categoryRepository.findByTitle(category);
        if(checkCategory == null){
            Category newCat = new Category();
            newCat.setTitle(category);
            product.setCategory(newCat);
        }else{
            product.setCategory(checkCategory);
        }
        Product createdProduct = productRepository.save(product);
        return createdProduct;
    }
}
