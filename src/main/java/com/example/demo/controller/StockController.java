package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Stock;

public interface StockController {
    @GetMapping("/stocks")
    ResponseEntity<List<Stock>> getAllStocks();

    @GetMapping("/stocks/{id}")
    ResponseEntity<Stock> getStockById(@PathVariable Long id);
    
    @PostMapping("/stocks")
    ResponseEntity<Stock> saveStock(@RequestBody Stock stock);

    @PutMapping("stocks/{id}")
    ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock);

    @DeleteMapping("stocks/{id}")
    ResponseEntity<Void> deleteStock(@PathVariable Long id);
}
