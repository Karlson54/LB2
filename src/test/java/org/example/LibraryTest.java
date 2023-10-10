package org.example;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    private Patron patron1;
    private Patron patron2;
    private Item book1;
    private Item book2;
    private Item dvd1;
    private Item dvd2;

    @Before
    public void setUp() {
        library = new Library();
        patron1 = new Patron("Patron 1", "P001");
        patron2 = new Patron("Patron 2", "P002");
        book1 = new Book("Book 1", "B001", "Author 1");
        book2 = new Book("Book 2", "B002", "Author 2");
        dvd1 = new DVD("DVD 1", "D001", 120);
        dvd2 = new DVD("DVD 2", "D002", 90);
    }

    @Test
    public void testLibraryAddItem() {
        library.add(book1);
        library.add(dvd1);

        assertTrue(library.getItems().contains(book1));
        assertTrue(library.getItems().contains(dvd1));
    }

    @Test
    public void testLibraryAddPatron() {
        library.registerPatron(patron1);
        library.registerPatron(patron2);

        assertTrue(library.getPatrons().contains(patron1));
        assertTrue(library.getPatrons().contains(patron2));
    }

    @Test
    public void testLendAndReturnItem() {
        library.add(book1);
        library.add(dvd1);

        library.registerPatron(patron1);
        library.registerPatron(patron2);

        library.lendItem(patron1, book1);
        library.lendItem(patron2, dvd1);

        assertTrue(book1.isBorrowed());
        assertTrue(dvd1.isBorrowed());
        assertEquals(1, patron1.getBorrowedItems().size());
        assertEquals(1, patron2.getBorrowedItems().size());

        library.returnItem(patron1, book1);
        library.returnItem(patron2, dvd1);

        assertFalse(book1.isBorrowed());
        assertFalse(dvd1.isBorrowed());
        assertEquals(0, patron1.getBorrowedItems().size());
        assertEquals(0, patron2.getBorrowedItems().size());
    }

    @Test
    public void testListAvailableItems() {
        library.add(book1);
        library.add(dvd1);
        library.add(book2);

        System.out.println("Доступні предмети:");
        library.listAvailable(); // Перевірка виводу на консоль
    }

    @Test
    public void testListBorrowedItems() {
        library.add(book1);
        library.add(dvd1);
        library.add(book2);

        patron1.borrow(book1);
        patron1.borrow(book2);

        System.out.println("Взяті предмети:");
        library.listBorrowed(); // Перевірка виводу на консоль
    }

    @Test
    public void testInvalidBorrow() {
        library.add(book1);

        library.registerPatron(patron1);

        library.lendItem(patron1, book1);
        library.lendItem(patron1, book1); // Спроба взяти вже взятий предмет

        assertEquals(1, patron1.getBorrowedItems().size());
    }
}
