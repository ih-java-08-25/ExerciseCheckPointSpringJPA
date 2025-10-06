package com.ironhack.helloSupermarket.service;

import com.ironhack.helloSupermarket.enums.Category;
import com.ironhack.helloSupermarket.model.Item;
import com.ironhack.helloSupermarket.model.ProduceStock;
import com.ironhack.helloSupermarket.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    //CRUD
    //read all
    public List<Item> readAll(){
        return itemRepository.findAll();
    }

    //read by id
    public Item findById (Long id){
        return itemRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No item with such ID: " + id));
    }

    //create
    public Item create(Item item){
        return itemRepository.save(item);
    }

    //update
    public Item update(Long id, Item item){
        Item itemToUpdate = findById(id);

        itemToUpdate.setName(item.getName());
        itemToUpdate.setCategory(item.getCategory());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate.setStock(item.getStock());

        return itemRepository.save(itemToUpdate);
    }

    //delete
    public void delete (Long id){
        itemRepository.deleteById(id);
    }

    //repository custom methods
    public List<Item> findItemsByCategory(Category category){

        return itemRepository.findItemsByCategory(category);
    };

    private static final int LOW_STOCK_THRESHOLD = 50;
    public List<Item> findLowStock(){
        return itemRepository.findItemsByStockLessThan(LOW_STOCK_THRESHOLD);
    };

//    private static final double DISCOUNT_PRICE_THRESHOLD = 1.99;
    public List<Item> findItemsToDiscount(double price){
        List<Item> lowStock = findLowStock();
        List<Item> toDiscount = new ArrayList<>();

        for(Item item : lowStock){
            if(item.getPrice() > price){
                toDiscount.add(item);
            }
        }
        return toDiscount;
    };

    public List<Item> sortByName(){
        return itemRepository.sortByName();
    };

    public List<ProduceStock> getProduceStock(){
        //getting the items with category produce from db
        List<Object[]> produceOnly = itemRepository.getProduceStock();

        //new list to store just the names and stock of the produce items
        List<ProduceStock> produceNameAndStockOnly = new ArrayList<>();

        //iterating over produce to populate only the name and stock fields using the ProduceStock DTO
        for(Object[] row : produceOnly) {
            String name = (String) row[0];
            int stock = ((Number) row[1]).intValue();
            produceNameAndStockOnly.add(new ProduceStock(name, stock));
        }

        return produceNameAndStockOnly;
    }
}
