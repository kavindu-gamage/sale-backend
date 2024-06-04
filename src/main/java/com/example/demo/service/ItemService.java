package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.entities.ItemDTO;
import com.example.demo.entity.Item;

@Service
public interface ItemService {
    List<Item> getAllItems();

    Item getItemById(Long id);

    Item addItem(Item item);

    Item updateItem(Long id, Item item);

    void deleteItem(Long id);

    public ItemDTO convertToDTO(Item item);
}
