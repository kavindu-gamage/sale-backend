package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Stock;

@Service
public interface StockService {
    List<Stock> getAllStocks();

    Stock getStockById(Long id);

    Stock addStock(Stock stock);

    Stock updateStock(Long id, Stock stock);

    void deleteStock(Long id);
}
