package com.app.invetory.repository;

import com.app.invetory.model.Item;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InventoryRepository {
    //data
    private final Map<Long, Item> items = new HashMap<>();
    //counter
    private Long counter = 1L;

    // method akses ke database
    public List<Item> ambilSemua() {
        return  new ArrayList<>(items.values());
    }
    //simpan data
    public Item simpan(Item item){
        item.setId(counter++);
        items.put(item.getId(), item);
        return item;
    }
    //getItemById
    public Optional<Item> getById(Long id){
        return Optional.ofNullable(items.get(id));
    }
}
