package service;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Library;
import model.Member;

public class LibraryService {

    private final Library catalog = new Library();
    private final List<Member> members = new ArrayList<>();

    public boolean addBook(Book book) {
        return catalog.addBook(book);
    }

    public Book findBook(int id) {
        return catalog.findById(id);
    }

    public void listBooks() {
        catalog.displayAllBooks();
    }

    public boolean addMember(int id, String name) {
        if (findMember(id) != null) {
            return false;
        }
        return members.add(new Member(id, name));
    }

    public Member findMember(int id) {
        for (Member member : members) {
            if (member.getMemberId() == id) {
                return member;
            }
        }
        return null;
    }

    public void listMembers() {
        if (members.isEmpty()) {
            System.out.println("No members yet.");
            return;
        }
        members.forEach(System.out::println);
    }

    public String borrowBook(int memberId, int bookId) {
        Member member = findMember(memberId);
        if (member == null) {
            return "Member not found.";
        }

        Book book = findBook(bookId);
        if (book == null) {
            return "Book not found.";
        }
        if (!book.isAvailable()) {
            return "Book is already borrowed.";
        }

        if (!member.borrowBook(book)) {
            return "Borrow limit reached (max 3 books).";
        }
        if (!catalog.borrowBook(bookId)) {
            member.returnBook(book);
            return "Book is already borrowed.";
        }

        return member.getName() + " borrowed \"" + book.getTitle() + "\".";
    }

    public String returnBook(int memberId, int bookId) {
        Member member = findMember(memberId);
        if (member == null) {
            return "Member not found.";
        }

        Book book = findBook(bookId);
        if (book == null) {
            return "Book not found.";
        }

        if (!member.returnBook(book)) {
            return "This member has not borrowed that book.";
        }

        catalog.returnBook(bookId);
        return member.getName() + " returned \"" + book.getTitle() + "\".";
    }
}
