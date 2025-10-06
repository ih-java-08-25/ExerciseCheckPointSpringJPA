package com.ironhack.helloSupermarket.controller;

import com.ironhack.helloSupermarket.enums.Category;
import com.ironhack.helloSupermarket.model.Item;
import com.ironhack.helloSupermarket.model.ProduceStock;
import com.ironhack.helloSupermarket.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    //crud
    //create
    @PostMapping("/inventory")
    public ResponseEntity<Item> create(@Valid @RequestBody Item item){
        Item createdItem = itemService.create(item);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(createdItem.getName())
                .toUri();

        return ResponseEntity.created(location).body(createdItem);
    }

    //read
    @GetMapping("/inventory/{id}")
    public Item findById(@PathVariable Long id){
        return itemService.findById(id);
    }

    //read all
    @GetMapping("/inventory")
    public List<Item> readAll (){
        return itemService.readAll();
    }

    //update
    @PutMapping("/inventory/{id}")
    public Item update(@PathVariable Long id, @Valid @RequestBody Item item){
        return itemService.update(id, item);
    }

    //delete
    @DeleteMapping("/inventory/{id}")
    public void delete(@PathVariable Long id){
        itemService.delete(id);
    }


    //repository custom methods
    @GetMapping("/inventory/category/{categoryString}")
    public List<Item> findItemsByCategory(@PathVariable String categoryString) {
        Category categoryEnum = Category.valueOf(categoryString.toUpperCase());
        return itemService.findItemsByCategory(categoryEnum);
    }

    @GetMapping("/inventory/low-stock")
    public List<Item> findLowStock(){
        return itemService.findLowStock();
    };


    @GetMapping("/inventory/to-discount/{price}")
    public List<Item> findItemsToDiscount(@PathVariable double price){
        return itemService.findItemsToDiscount(price);
    };

    @GetMapping("inventory/alphabetically")
    public List<Item> sortByName(){
        return itemService.sortByName();
    }

    @GetMapping("/inventory/produce-stock")
    public List<ProduceStock> getProduceStock(){
        return itemService.getProduceStock();
    }
}