package model;

import java.util.ArrayList;

public class Library {

    private final ArrayList<Book> books = new ArrayList<>();

    public boolean addBook(Book b) {
        if (b == null || findById(b.getId()) != null) {
            return false;
        }
        books.add(b);
        return true;
    }

    public boolean removeBook(int id) {
        Book b = findById(id);
        if (b == null) {
            return false;
        }
        books.remove(b);
        return true;
    }

    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void searchByTitle(String keyword) {
        boolean found = false;
        for (Book book : books) {
            if (book.getBookName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found.");
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public boolean borrowBook(int id) {
        Book b = findById(id);
        return b != null && b.borrowBook();
    }

    public boolean returnBook(int id) {
        Book b = findById(id);
        if (b == null) {
            return false;
        }
        b.returnBook();
        return true;
    }
}
