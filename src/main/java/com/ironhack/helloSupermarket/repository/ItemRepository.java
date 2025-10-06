package com.ironhack.helloSupermarket.repository;

import com.ironhack.helloSupermarket.enums.Category;
import com.ironhack.helloSupermarket.model.Item;
import com.ironhack.helloSupermarket.model.ProduceStock;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findItemsByCategory(Category category);
    List<Item> findItemsByStockLessThan(int threshold);
    List<Item> findItemsByPriceGreaterThan(double price);


    //order alphabetically - JPQL
    @Query("SELECT i FROM Item i ORDER BY i.name")
    List<Item> sortByName();

    //find only produce - SQL
    @Query(value = "SELECT name, stock FROM item WHERE category='PRODUCE'", nativeQuery = true)
    List<Object[]> getProduceStock();

}

