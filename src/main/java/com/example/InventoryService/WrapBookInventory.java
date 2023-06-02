//SE_ASS6_Group65_i6297119_i6314833
//Group 65: Matei Turcan & Thu Vo

package com.example.InventoryService;

/**
 * This class is a wrapper class to create an object of both InventoryBook and Book. In this case, InventoryBook represents
 * a slot designated for a book inside the inventory list. Book however is a tie-in for the book in the catalog
 * microservice.
 */
public class WrapBookInventory {
    private Book book;
    private InventoryBook inventoryBook;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public InventoryBook getInventoryBook() {
        return inventoryBook;
    }

    public void setInventoryBook(InventoryBook inventoryBook) {
        this.inventoryBook = inventoryBook;
    }

    public WrapBookInventory(Book book, InventoryBook inventoryBook) {
        this.book = book;
        this.inventoryBook = inventoryBook;
    }
}
