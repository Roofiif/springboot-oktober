package com.app.invetory.service;

import com.app.invetory.model.Item;
import com.app.invetory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    //Di
    private InventoryRepository repo;
    //constructor
    public InventoryService(InventoryRepository repo){
        this.repo = repo;
    }
    //method getItem
    public List<Item> getAllItems(){
        return repo.ambilSemua();
    }
    //simpan
    public Item addItem(Item item){
        return repo.simpan(item);
    }
    //getItemById
    public Optional<Item> getById(Long id){
        return repo.getById(id);
    }
}
