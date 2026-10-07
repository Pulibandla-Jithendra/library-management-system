import java.util.Scanner;

import model.Book;
import service.LibraryService;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final LibraryService library = new LibraryService();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = readInt("Choose an option: ");
            handle(choice);
        } while (choice != 0);
        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println("""

                ===== Library Management System =====
                1. Add book
                2. View books
                3. Add member
                4. View members
                5. Borrow book
                6. Return book
                0. Exit
                """);
    }

    private static void handle(int choice) {
        switch (choice) {
            case 1 -> {
                int id = readInt("Book id: ");
                String title = readText("Title: ");
                String author = readText("Author: ");
                System.out.println(library.addBook(new Book(id, title, author))
                        ? "Book added." : "Book id already exists.");
            }
            case 2 -> library.listBooks();
            case 3 -> {
                int id = readInt("Member id: ");
                String name = readText("Name: ");
                System.out.println(library.addMember(id, name)
                        ? "Member added." : "Member id already exists.");
            }
            case 4 -> library.listMembers();
            case 5 -> {
                int memberId = readInt("Member id: ");
                int bookId = readInt("Book id: ");
                System.out.println(library.borrowBook(memberId, bookId));
            }
            case 6 -> {
                int memberId = readInt("Member id: ");
                int bookId = readInt("Book id: ");
                System.out.println(library.returnBook(memberId, bookId));
            }
            case 0 -> { }
            default -> System.out.println("Invalid option. Try again.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}