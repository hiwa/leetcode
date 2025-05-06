package come.hiwa.skiplist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SkipListTest {

	@Test
	public void testInsertAndSearch() {
		SkipList skipList = new SkipList();

		// Test inserting values
		skipList.insert(3);
		System.out.println("Skip List after insertion 3:");
		skipList.printSkipList();
		skipList.insert(6);
		System.out.println("Skip List after insertion 6:");
		skipList.printSkipList();
		skipList.insert(7);
		System.out.println("Skip List after insertion 7:");
		skipList.printSkipList();
		skipList.insert(9);
		System.out.println("Skip List after insertion 9:");
		skipList.printSkipList();
		skipList.insert(12);
//		skipList.insert(19);
//		skipList.insert(21);
//		skipList.insert(25);

		// Print the skip list structure
		System.out.println("Skip List after insertions:");
		skipList.printSkipList();

		// Test searching existing values
		assertTrue(skipList.search(3), "Value 3 should be present in the skip list.");
		assertTrue(skipList.search(6), "Value 6 should be present in the skip list.");
		assertTrue(skipList.search(19), "Value 19 should be present in the skip list.");
		assertTrue(skipList.search(25), "Value 25 should be present in the skip list.");

		// Test searching non-existent values
		assertFalse(skipList.search(1), "Value 1 should not be present in the skip list.");
		assertFalse(skipList.search(5), "Value 5 should not be present in the skip list.");
		assertFalse(skipList.search(20), "Value 20 should not be present in the skip list.");
	}

	@Test
	public void testInsertDuplicate() {
		SkipList skipList = new SkipList();

		// Test inserting duplicate values
		skipList.insert(5);
		skipList.insert(5);

		// Print the skip list structure
		System.out.println("Skip List after inserting duplicate values:");
		skipList.printSkipList();

		// Search for the value
		assertTrue(skipList.search(5), "Value 5 should be present in the skip list.");
	}

	@Test
	public void testEmptyListSearch() {
		SkipList skipList = new SkipList();

		// Search in an empty list
		assertFalse(skipList.search(10), "Value 10 should not be present in an empty skip list.");
	}

	@Test
	public void testInsertAndSearchEdgeCases() {
		SkipList skipList = new SkipList();

		// Insert a large number of elements to test the randomness of levels
		for (int i = 1; i <= 100; i++) {
			skipList.insert(i);
		}

		// Print the skip list structure
		System.out.println("Skip List after inserting 1 to 100:");
		skipList.printSkipList();

		// Search some values
		assertTrue(skipList.search(50), "Value 50 should be present in the skip list.");
		assertTrue(skipList.search(1), "Value 1 should be present in the skip list.");
		assertTrue(skipList.search(100), "Value 100 should be present in the skip list.");
	}
}