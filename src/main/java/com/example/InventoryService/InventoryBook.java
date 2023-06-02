//SE_ASS6_Group65_i6297119_i6314833
//Group 65: Matei Turcan & Thu Vo

package com.example.InventoryService;

/**
 * This class represents the slot a book may occupy in the inventory list.
 *
 * (clarification)
 * id - inventory slot id
 * bookId - the id of the book inside said slot
 */
public class InventoryBook {
    private int id;
    private int bookId;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public InventoryBook(int id, int bookId, int quantity) {
        this.id = id;
        this.bookId = bookId;
        this.quantity = quantity;
    }
}
