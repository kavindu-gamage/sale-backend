package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.exceptions.ItemNotFoundException;

@Service
public interface ItemService {
    List <Item> getAllItems();
    Item getItemById(Long id) throws ItemNotFoundException;
    Item addItem(Item item);
    Item updateItem(Long id, Item item) throws ItemNotFoundException;
    void deleteItem(Long id) throws ItemNotFoundException;
}
