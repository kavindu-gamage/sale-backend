package com.example.demo.exceptions;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String message){
        super(message);
    }
}
