package com.example.product.Exceptions;

// ProductNotFoundException class was for manual error handling.
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message){
        super(message);
    }
}
