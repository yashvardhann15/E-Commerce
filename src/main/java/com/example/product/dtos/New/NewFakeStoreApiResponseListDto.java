package com.example.product.dtos.New;

import com.example.product.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NewFakeStoreApiResponseListDto {
    private String status;
    private String message;
    private List<NewFakeStoreProductDto> products;

    public List<Product> toProdList() {
        List<Product> productList = new ArrayList<>();
        for (NewFakeStoreProductDto p : this.products) {
            productList.add(p.toProduct());
        }
        return productList;
    }
}
