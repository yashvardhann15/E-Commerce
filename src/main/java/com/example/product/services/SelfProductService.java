package com.example.product.services;

import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.Exceptions.ProductNotFoundException;
import com.example.product.projections.ProjectProjection;
import com.example.product.repositories.CategoryRepository;
import com.example.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    private final RestTemplate restTemplate;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public SelfProductService(CategoryRepository categoryRepository, ProductRepository productRepository, RestTemplate restTemplate){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    @Override
    public Product getSingleProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + id + " not found in the database.");
        }

        return product.get();
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

    @Override
    public List<Product> findAllByCategory(Category category){
        return productRepository.findAllByCategory(category);
    }

    @Override
    public List<Product> findAllByCategory_Title(String CategoryName){
        return productRepository.findAllByCategory_Title(CategoryName);
    }

    @Override
    public List<ProjectProjection> getTitlesAndIdOfAllProductsWithGivenCategoryName(String categoryName){
        return productRepository.getTitlesAndIdOfAllProductsWithGivenCategoryName(categoryName);
    }
}
