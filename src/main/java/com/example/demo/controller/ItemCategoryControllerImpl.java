package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ItemCategory;
import com.example.demo.service.ItemCategoryService;

@RestController
@CrossOrigin(origins="*")
public class ItemCategoryControllerImpl implements ItemCategoryController {
    private final ItemCategoryService itemCategoryService;

    @Autowired
    public ItemCategoryControllerImpl(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @Override
    public ResponseEntity<List<ItemCategory>> getAllItemCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(itemCategoryService.getAllItemCategories());
    }

    @Override
    public ResponseEntity<ItemCategory> getItemCategoryById(@PathVariable Long id) {
        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemCategory);
    }

    @Override
    public ResponseEntity<ItemCategory> saveItemCategory(@RequestBody ItemCategory itemCategory) {
        ItemCategory newItemCategory = itemCategoryService.addItemCategory(itemCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItemCategory);
    }

    @Override
    public ResponseEntity<ItemCategory> updateItemCategory(@PathVariable Long id, @RequestBody ItemCategory itemCategory) {
        ItemCategory updatedItemCategory = itemCategoryService.updateItemCategory(id, itemCategory);
        return ResponseEntity.status(HttpStatus.OK).body(updatedItemCategory);
    }

    @Override
    public ResponseEntity<Void> deleteItemCategory(@PathVariable Long id) {
        itemCategoryService.deleteItemCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
