//SE_ASS6_Group65_i6297119_i6314833
//Group 65: Matei Turcan & Thu Vo

package com.example.InventoryService.service;

import com.example.InventoryService.Book;
import com.example.InventoryService.InventoryBook;
import com.example.InventoryService.WrapBookInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class handles the inventory microservice. In a real-world scenario, the databases for BookCatalogueService and
 * InventoryService would probably be linked, and communicate with each other. Instead, we've opted to create a new
 * database to simulate the slight disconnect between these microservices. The main difference here is the fact that the
 * books inside the inventory list contain an integer showing the current stock of that book.
 */

@Service
public class InventoryService {

    @Autowired
    private RestTemplate restTemplate;

    private List<InventoryBook> inventoryList;

    public InventoryService(){

        inventoryList = new ArrayList<>();

        InventoryBook hhgttg = new InventoryBook(1, 1, 12);
        InventoryBook gOmens = new InventoryBook(2, 2, 6);
        InventoryBook ccs = new InventoryBook(3, 3, 3);

        inventoryList.addAll(Arrays.asList(hhgttg, gOmens, ccs));
    }

    public InventoryBook addInventoryBook(InventoryBook invBook) {
        inventoryList.add(invBook);
        return invBook;
    }

    /**
     * This method returns the details of a Book alongside the details of the book in the context of the inventory
     * list.
     * @param id identifier inside the inventory list/repo/database
     * @return wrapper object containing both InventoryBook and Book
     */
    public WrapBookInventory getBookAndQuantity(Integer id) {
        InventoryBook bookSearch = null;

        for (InventoryBook inventoryBook : inventoryList) {
            if (id.equals(inventoryBook.getId())) {
                bookSearch = inventoryBook;
                break;
            }
        }

        if (bookSearch != null) {
            Book book = restTemplate.getForObject("http://localhost:3001/catalog/" + bookSearch.getBookId(), Book.class);
            WrapBookInventory wbi = new WrapBookInventory(book, bookSearch);
            return wbi;
        }
        return null;
    }

    public List<InventoryBook> getAllInv(){
        return inventoryList;
    }

    public Integer getQuantity(Integer id) {
        for (InventoryBook inventoryBook : inventoryList) {
            if (id.equals(inventoryBook.getId())) {
                return inventoryBook.getQuantity();
            }
        }
        return null;
    }

    public InventoryBook updateInventoryBook(Integer id, InventoryBook uBook){
        for (InventoryBook invBook: inventoryList) {
            int i = inventoryList.indexOf(invBook);
            if(id.equals(invBook.getId())){
                inventoryList.set(i, uBook);
                return uBook;
            }
        }
        return null;
    }

    public String deleteInvetoryBook(Integer id) {
        for(InventoryBook invBook: inventoryList){
            if(id.equals(invBook.getId())){
                inventoryList.remove(invBook);
                return "Book with the inventory id "+id+" has been deleted" ;
            }
        }
        return "Book with the inventory id "+id+" does not exist in the repository";
    }
}

