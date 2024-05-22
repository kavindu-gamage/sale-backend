package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getAllItemCategories();
    ItemCategory getItemCategory(Long id);
    ItemCategory addItemCategory(ItemCategory itemCategory);
    ItemCategory updateItemCategory(Long id, ItemCategory itemCategory);
    void deleteItemCategory(Long id);
}
