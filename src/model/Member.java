
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private static final int MAX_BOOKS = 3;

    private int memberId;
    private String name;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public Member() {
    }

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    public boolean borrowBook(Book book) {
        if (book == null || borrowedBooks.contains(book)
                || borrowedBooks.size() >= MAX_BOOKS) {
            return false;
        }
        borrowedBooks.add(book);
        return true;
    }

    public boolean returnBook(Book book) {
        return book != null && borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member{id=" + memberId + ", name=" + name
                + ", books=" + borrowedBooks.size() + "}";
    }
}
