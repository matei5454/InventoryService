//SE_ASS6_Group65_i6297119_i6314833
//Group 65: Matei Turcan & Thu Vo

package com.example.InventoryService;

import com.example.InventoryService.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InventoryServiceApplicationTests {
	public InventoryService inventoryService;

	@BeforeEach
	void setUp() {
		inventoryService = new InventoryService();
	}

	@Test
	void addInventoryBook() {

		InventoryBook newInvBook = new InventoryBook(4,4,10);
		InventoryBook addedInvBook = inventoryService.addInventoryBook(newInvBook);
		assertNotNull(addedInvBook);
		assertEquals(newInvBook, addedInvBook);

	}

//	@Test
//	void getBookAndQuantity() {
//		InventoryBook invBook = new InventoryBook(1,1,13);
//		Book book = new Book();
//		book.setId(invBook.getBookId());
//		book.setTitle("New Book");
//		WrapBookInventory result = inventoryService.getBookAndQuantity(1);
//		assertNotNull(result);
//		assertEquals(book, result.getBook());
//		assertEquals(invBook, result.getInventoryBook());
//	}

	@Test
	void getQuantity() {
		int result = inventoryService.getQuantity(1);
		assertEquals(12, result);

		Integer nonExist = inventoryService.getQuantity(10);
		assertNull(nonExist);

	}

	@Test
	void updateInventoryBook() {

		InventoryBook updatedBook = new InventoryBook(2, 5, 8);
		InventoryBook result = inventoryService.updateInventoryBook(2, updatedBook);
		assertNotNull(result);
		assertEquals(updatedBook, result);

		InventoryBook nonExist = new InventoryBook(5, 5, 8);
		InventoryBook nonExistResult = inventoryService.updateInventoryBook(10, nonExist);
		assertNull(nonExistResult);

	}



	@Test
	void deleteInventoryBook() {
		String result = inventoryService.deleteInvetoryBook(3);
		assertEquals("Book with the inventory id 3 has been deleted", result);

		String nonExistResult = inventoryService.deleteInvetoryBook(10);
		assertEquals("Book with the inventory id 10 does not exist in the repository", nonExistResult);
	}

}
