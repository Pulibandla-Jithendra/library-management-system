
import java.util.ArrayList;

public class Library {

    private final ArrayList<Book> books = new ArrayList<>();

    // public void addBook(Book b){
    //     if(!books.contains(b))books.add(b);
    //     else{
    //         System.out.println("Already present");
    //     }
    public boolean addBook(Book b) {
        if (findById(b.getId()) != null) {
            return false;  // duplicate id

        }
        books.add(b);
        return true;
    }

    // public void removeBook(int id){
    //     for(Book book: books){
    //         if(book.getId()==id){
    //             books.remove(book);
    //             System.out.println(book+"is removed");
    //         }
    //     }
    // }
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

    // public void searchByTitle(String keyword){
    //     for(Book book: books){
    //         if(book.getBookName().equals(keyword)){
    //             System.out.println(book);
    //         }
    //     }
    // }
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
        }
        for (Book book : books) {

            System.out.println(book);// toString

        }
    }

    // public boolean borrowBook(int id) {
    //     Book b = findById(id);
    //     if (b == null) {
    //         return false;
    //     }
    //     b.borrowBook();
    //     return true;
    // }
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
