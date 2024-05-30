package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.ItemCategory;

public interface ItemCategoryController {
    @GetMapping("/categories")
    ResponseEntity<List<ItemCategory>> getAllItemCategories();

    @GetMapping("/categories/{id}")
    ResponseEntity<ItemCategory> getItemCategoryById(@PathVariable Long id);

    @PostMapping("/categories")
    ResponseEntity<ItemCategory> saveItemCategory(@RequestBody ItemCategory itemCategory);

    @PutMapping("categories/{id}")
    ResponseEntity<ItemCategory> updateItemCategory(@PathVariable Long id, @RequestBody ItemCategory itemCategory);

    @DeleteMapping("categories/{id}")
    ResponseEntity<Void> deleteItemCategory(@PathVariable Long id);

}
