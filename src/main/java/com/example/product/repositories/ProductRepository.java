package com.example.product.repositories;

import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.projections.ProjectProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Override
    List<Product> findAll();

    Optional<Product> findById(long id);

    Product save(Product product);

    List<Product> findAllByCategory(Category category);

    List<Product> findAllByCategory_Title(String CategoryTitle);

    @Query("select p.title as title, p.id as id from Product p where p.category.title = :categoryName")
    List<ProjectProjection> getTitlesAndIdOfAllProductsWithGivenCategoryName(@Param("categoryName") String categoryName);


    // Issue in this
//    @Query(value = "SELECT * FROM product p JOIN category c ON p.id = c.id WHERE c.title = :categoryName AND p.id = 1;" , nativeQuery = true)
//    List<ProjectProjection> getTitlesAndIdOfAllProductsWithGivenCategoryName(@Param("categoryName") String categoryName);
}
