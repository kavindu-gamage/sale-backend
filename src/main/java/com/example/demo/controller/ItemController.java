package com.example.demo.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.entities.ItemDTO;
import com.example.demo.entity.Item;

public interface ItemController {
    
    @GetMapping("/items")
    ResponseEntity<List<ItemDTO>> getAllItems();

    @GetMapping("/items/{id}")
    ResponseEntity<ItemDTO> getItemById(@PathVariable Long id);
    
    @PostMapping("/items")
    ResponseEntity<ItemDTO> saveItem(@RequestBody Item item);

    @PutMapping("items/{id}")
    ResponseEntity<ItemDTO> updateItem(@PathVariable Long id, @RequestBody Item item);

    @DeleteMapping("items/{id}")
    ResponseEntity<Void> deleteItem(@PathVariable Long id);

}
