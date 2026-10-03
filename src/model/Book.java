
public class Book {

    private final int id;
    private String bookname;
    private String authorname;
    private boolean isAvailable;

    public Book(int id, String bookname, String authorname, boolean isAvailable) {
        this.id = id;
        this.bookname = bookname;
        this.authorname = authorname;
        this.isAvailable = isAvailable;
    }

    //Getters
    public int getId() {
        return this.id;
    }

    public String getBookName() {
        return this.bookname;
    }

    public String getAuthorName() {
        return this.authorname;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    //Setter
    public void setBookName(String name) {
        this.bookname = name;
    }

    public void setAuthorName(String name) {
        this.authorname = name;
    }

    // public void borrowBook() {
    //     if (isAvailable) {
    //         this.isAvailable = false; 
    //     }else {
    //         System.out.println("Book is already borrowed");
    //     }
    //}
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
        return id + " | " + bookname + " by " + authorname + " | " + (isAvailable ? "Available" : "Borrowed");
    }

}
