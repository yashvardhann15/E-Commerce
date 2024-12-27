package com.example.product.projections;

import com.example.product.models.Category;

public interface ProjectProjection {
    Long getId();
    String getTitle();
    String getDescription();
    double getPrice();
    String getImageUrl();
    Category getCategory();
}
