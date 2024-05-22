package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
    
}
