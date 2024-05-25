package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Stock;
import com.example.demo.exceptions.StockNotFoundException;
import com.example.demo.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {
    private StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id){
        return stockRepository.findById(id).orElseThrow(() -> new StockNotFoundException("There is no stock for " + id));
    }

    @Override
    public Stock addStock(Stock stock){
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock){
        Stock exisitngStock = getStockById(id);

        exisitngStock.setItem(stock.getItem());
        exisitngStock.setQuantity(stock.getQuantity());
        return stockRepository.save(exisitngStock);
    }

    @Override
    public void deleteStock(Long id){
        if(!stockRepository.existsById(id)){
            throw new StockNotFoundException("There is no stock for " + id);
        }
        stockRepository.deleteById(id);
    }
}
