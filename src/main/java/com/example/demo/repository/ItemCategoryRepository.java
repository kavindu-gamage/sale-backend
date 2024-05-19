package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ItemCategory;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
    
}
