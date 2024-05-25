package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.repository.ItemRepository;
import com.example.demo.validation.IdValidator;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;
    private IdValidator idValidator;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, IdValidator idValidator) {
        this.itemRepository = itemRepository;
        this.idValidator = idValidator;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        idValidator.validateId(id);
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item Not found for id number " + id));
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item existingItem = getItemById(id);

        existingItem.setName(item.getName());
        existingItem.setDescription(item.getDescription());
        existingItem.setPrice(item.getPrice());

        return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(Long id) {
        idValidator.validateId(id);
        if (!itemRepository.existsById(id)) {
            throw new ItemNotFoundException("Item Not found for id number " + id);
        }
        itemRepository.deleteById(id);
    }

}
