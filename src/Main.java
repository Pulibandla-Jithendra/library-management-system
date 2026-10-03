
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add book");
            System.out.println("2. View all books");
            System.out.println("3. Search by title");
            System.out.println("4. Borrow book");
            System.out.println("5. Return book");
            System.out.println("6. Remove book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = readInt(sc);
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter book id");
                    int id = readInt(sc);
                    System.out.println("Enter book name");
                    String bookname = sc.nextLine();
                    System.out.println("Enter book author name");
                    String authorname = sc.nextLine();
                    if (library.addBook(new Book(id, bookname, authorname, true))) {
                        System.out.println("Book added");
                    } else {
                        System.out.println("A book with this id already exists.");
                    }
                }
                case 2 -> library.displayAllBooks();
                case 3 -> {
                    System.out.println("Enter book title");
                    library.searchByTitle(sc.nextLine());
                }
                case 4 -> {
                    System.out.print("Enter book id to borrow: ");
                    int borrowId = readInt(sc);
                    if (library.findById(borrowId) == null) {
                        System.out.println("Book not found.");
                    } else if (library.borrowBook(borrowId)) {
                        System.out.println("Book borrowed.");
                    } else {
                        System.out.println("Book is already borrowed.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter book id to return: ");
                    if (library.returnBook(readInt(sc))) {
                        System.out.println("Book returned.");
                    } else {
                        System.out.println("Book not found.");
                    }
                }
                case 6 -> {
                    System.out.println("Enter book id to remove");
                    int removeid = readInt(sc);
                    if (library.removeBook(removeid)) {
                        System.out.println("The book removed");
                    } else {
                        System.out.println("The book not found");
                    }
                }
                case 0 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
