package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemCategory;
import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.repository.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    private ItemCategoryRepository itemCategoryRepository;

    @Autowired
    public ItemCategoryServiceImpl(ItemCategoryRepository itemCategoryRepository){
        this.itemCategoryRepository = itemCategoryRepository;
    }

    @Override
    public List<ItemCategory> getAllItemCategories(){
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory getItemCategoryById(Long id){
        return itemCategoryRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item Category Not Found "+ id));
    }

    @Override
    public ItemCategory addItemCategory(ItemCategory itemCategory){
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public ItemCategory updateItemCategory(Long id, ItemCategory itemCategory){
        ItemCategory exisingItemCategory = getItemCategoryById(id);

        exisingItemCategory.setName(itemCategory.getName());
        exisingItemCategory.setDescription(itemCategory.getDescription());

        return itemCategoryRepository.save(exisingItemCategory);
    }

    @Override
    public void deleteItemCategory(Long id){
        if(!itemCategoryRepository.existsById(id)){
            throw new ItemNotFoundException("Item Category Not Found "+ id);
        }
    }

}
