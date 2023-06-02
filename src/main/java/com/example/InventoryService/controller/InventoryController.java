package com.example.InventoryService.controller;

import com.example.InventoryService.InventoryBook;
import com.example.InventoryService.WrapBookInventory;
import com.example.InventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{id}")
    public WrapBookInventory getBookAndQuantity(@PathVariable Integer id){
        return inventoryService.getBookAndQuantity(id);
    }

    @GetMapping("/quantity/{id}")
    public Integer getQuantity(@PathVariable Integer id){
        return inventoryService.getQuantity(id);
    }

    @GetMapping("/all")
    public List<InventoryBook> getAll(){
        return inventoryService.getAllInv();
    }

    @PostMapping("/create")
    public InventoryBook addBook(@RequestBody InventoryBook invBook){
        return inventoryService.addInventoryBook(invBook);
    }

    @PutMapping("/update/{id}")
    public InventoryBook updateInventory(@PathVariable Integer id, @RequestBody InventoryBook invBook){
        return inventoryService.updateInventoryBook(id, invBook);
    }

    @DeleteMapping
    public String deleteInventoryBook(@RequestParam Integer id){
        return inventoryService.deleteInvetoryBook(id);
    }

}
