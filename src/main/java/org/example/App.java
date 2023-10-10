package org.example;
import java.util.ArrayList;
import java.util.List;

// Item.java
abstract class Item {
    private String title;
    private String uniqueID;
    private boolean isBorrowed;

    public Item(String title, String uniqueID) {
        this.title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowItem() {
        isBorrowed = true;
    }

    public void returnItem() {
        isBorrowed = false;
    }

    public abstract void borrowItem(Patron patron);
    public abstract void returnItem(Patron patron);
}

// Book.java
class Book extends Item {
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    @Override
    public void borrowItem(Patron patron) {
        if (!isBorrowed()) {
            borrowItem();
            patron.borrow(this);
        }
    }

    @Override
    public void returnItem(Patron patron) {
        if (isBorrowed()) {
            returnItem();
            patron.returnItem(this);
        }
    }
}

// DVD.java
class DVD extends Item {
    private int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    @Override
    public void borrowItem(Patron patron) {
        if (!isBorrowed()) {
            borrowItem();
            patron.borrow(this);
        }
    }

    @Override
    public void returnItem(Patron patron) {
        if (isBorrowed()) {
            returnItem();
            patron.returnItem(this);
        }
    }
}

// Patron.java
class Patron {
    private String name;
    private String ID;
    private List<Item> borrowedItems;

    public Patron(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrow(Item item) {
        borrowedItems.add(item);
    }

    public void returnItem(Item item) {
        borrowedItems.remove(item);
    }
}

// IManageable.java
interface IManageable {
    void add(Item item);
    void remove(Item item);
    void listAvailable();
    void listBorrowed();
}

// Library.java
class Library implements IManageable {
    private List<Item> items;
    private List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public List<Item> getItems() {
        return items;
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (items.contains(item) && !item.isBorrowed()) {
            item.borrowItem(patron);
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patron.getBorrowedItems().contains(item)) {
            item.returnItem(patron);
        }
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public void listAvailable() {
        for (Item item : items) {
            if (!item.isBorrowed()) {
                System.out.println("Available: " + item.getTitle());
            }
        }
    }

    @Override
    public void listBorrowed() {
        for (Item item : items) {
            if (item.isBorrowed()) {
                System.out.println("Borrowed: " + item.getTitle());
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        Item book1 = new Book("Book 1", "B001", "Author 1");
        Item book2 = new Book("Book 2", "B002", "Author 2");
        Item dvd1 = new DVD("DVD 1", "D001", 120);
        Item dvd2 = new DVD("DVD 2", "D002", 90);

        library.add(book1);
        library.add(book2);
        library.add(dvd1);
        library.add(dvd2);

        Patron patron1 = new Patron("Patron 1", "P001");
        Patron patron2 = new Patron("Patron 2", "P002");

        library.registerPatron(patron1);
        library.registerPatron(patron2);

        library.lendItem(patron1, book1);
        library.lendItem(patron2, dvd1);

        System.out.println("Доступні предмети:");
        library.listAvailable();

        System.out.println("Взяті предмети:");
        library.listBorrowed();

        library.returnItem(patron1, book1);
        library.returnItem(patron2, dvd1);

        System.out.println("Доступні предмети після повернення:");
        library.listAvailable();

        System.out.println("Взяті предмети після повернення:");
        library.listBorrowed();
    }
}
