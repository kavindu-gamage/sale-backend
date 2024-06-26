// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.Item;
// import com.example.demo.service.ItemService;

// @RestController
// @CrossOrigin(origins="*")
// public class ItemControllerImpl implements ItemController {
//     private final ItemService itemService;

//     @Autowired
//     public ItemControllerImpl(ItemService itemService) {
//         this.itemService = itemService;
//     }

//     @Override
//     public ResponseEntity<List<Item>> getAllItems() {
//         return ResponseEntity.status(HttpStatus.OK).body(itemService.getAllItems());
//     }

//     @Override
//     public ResponseEntity<Item> getItemById(@PathVariable Long id) {
//         Item item = itemService.getItemById(id);
//         return ResponseEntity.status(HttpStatus.OK).body(item);
//     }

//     @Override
//     public ResponseEntity<Item> saveItem(@RequestBody Item item) {
//         Item newItem = itemService.addItem(item);
//         return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
//     }

//     @Override
//     public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
//         Item updatedItem = itemService.updateItem(id, item);
//         return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
//     }

//     @Override
//     public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
//         itemService.deleteItem(id);
//         return ResponseEntity.status(HttpStatus.OK).body(null);
//     }
// }

package com.example.demo.controller;


import com.example.demo.dto.entities.ItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="*")
public class ItemControllerImpl implements ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemControllerImpl(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> itemDTOs = itemService.getAllItems()
                .stream()
                .map(itemService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(itemDTOs);
    }

    @Override
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        ItemDTO itemDTO = itemService.convertToDTO(itemService.getItemById(id));
        return ResponseEntity.status(HttpStatus.OK).body(itemDTO);
    }

    @Override
    public ResponseEntity<ItemDTO> saveItem(@RequestBody Item item) {
        Item newItem = itemService.addItem(item);
        ItemDTO newItemDTO = itemService.convertToDTO(newItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItemDTO);
    }

    @Override
    public ResponseEntity<ItemDTO> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(id, item);
        ItemDTO updatedItemDTO = itemService.convertToDTO(updatedItem);
        return ResponseEntity.status(HttpStatus.OK).body(updatedItemDTO);
    }

    @Override
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
