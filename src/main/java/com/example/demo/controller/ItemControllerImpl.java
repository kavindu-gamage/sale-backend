// package com.example.demo.controller;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.Item;
// import com.example.demo.exceptions.ItemNotFoundException;
// import com.example.demo.service.ItemService;

// @RestController
// public class ItemControllerImpl implements ItemController {
//     private final ItemService itemService;

//     @Autowired
//     public ItemControllerImpl(ItemService itemService){
//         this.itemService = itemService;
//     }

//     @Override
//     public ResponseEntity<List<Item>> getAllItems(){
//         try {
//             List<Item> items = itemService.getAllItems();
//             return ResponseEntity.status(HttpStatus.OK).body(items);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//         }
//     }

//     @Override
//     public ResponseEntity<Item> getItemById(@PathVariable Long id){
//         try {
//             Item item = itemService.getItemById(id);
//             return ResponseEntity.status(HttpStatus.OK).body(item);
//         } catch (ItemNotFoundException e) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//         }
//     }

//     @Override
//     public ResponseEntity<Item> saveItem(@RequestBody Item item){
//         try {
//             Item newItem = itemService.addItem(item);
//             return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//         }
//     }

//     @Override
//     public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item){
//         try {
//             Item updatedItem = itemService.updateItem(id, item);
//             return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
//         } catch (ItemNotFoundException e) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//         }
//     }

//     @Override
//     public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
//         try {
//             itemService.deleteItem(id);
//             return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//         } catch (ItemNotFoundException e) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//         }
//     }
// }
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemControllerImpl implements ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemControllerImpl(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAllItems());
    }

    @Override
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    @Override
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        Item newItem = itemService.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }

    @Override
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(id, item);
        return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
    }

    @Override
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}