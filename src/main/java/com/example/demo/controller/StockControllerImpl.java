package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Stock;
import com.example.demo.service.StockService;

public class StockControllerImpl implements StockController {
    private final StockService stockService;

    @Autowired
    public StockControllerImpl(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.status(HttpStatus.OK).body(stockService.getAllStocks());
    }

    @Override
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Stock stock = stockService.getStockById(id);
        return ResponseEntity.status(HttpStatus.OK).body(stock);
    }

    @Override
    public ResponseEntity<Stock> saveStock(@RequestBody Stock stock) {
        Stock newStock = stockService.addStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStock);
    }

    @Override
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        Stock updatedStock = stockService.updateStock(id, stock);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStock);
    }

    @Override
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
