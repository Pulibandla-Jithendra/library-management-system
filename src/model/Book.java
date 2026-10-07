package model;

public class Book {

    private final int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this(id, title, author, true);
    }

    public Book(int id, String title, String author, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookName() {
        return this.title;
    }

    public void setBookName(String name) {
        this.title = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorName() {
        return this.author;
    }

    public void setAuthorName(String name) {
        this.author = name;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public boolean borrowBook() {
        if (!isAvailable) {
            return false;
        }
        isAvailable = false;
        return true;
    }

    public void returnBook() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return id + " | " + title + " by " + author + " | " + (isAvailable ? "Available" : "Borrowed");
    }
}
