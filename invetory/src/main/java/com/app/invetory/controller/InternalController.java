package com.app.invetory.controller;

import com.app.invetory.model.Item;
import com.app.invetory.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//url default
@RequestMapping("/api/internal")
public class InternalController {
    //service
    private final InventoryService service;
    //constructor
    public InternalController(InventoryService service){
        this.service = service;
    }

    //get data inventory
    @GetMapping
    public List<Item> getInventory(){
        return service.getAllItems();
    }

    //post data inventory
    @PostMapping
    public Item addItem(@RequestBody Item item){
        return service.addItem(item);
    }

    //getById
    @GetMapping("/{id}")
    public Optional<Item> getById(@PathVariable Long id){
        return service.getById(id);
    }
}
