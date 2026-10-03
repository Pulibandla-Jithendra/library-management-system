# Library Management System

A command-line library manager built in Java.

## Features
- Add, remove and view books
- Search books by title (case-insensitive, partial match)
- Borrow and return books
- Input validation for menu and ids

## Concepts used
OOP, encapsulation, packages, ArrayList, exception handling

## How to run

Requires JDK 17 or later.

```
javac -d out src/Main.java src/model/Book.java src/model/Library.java src/model/Member.java src/service/LibraryService.java
java -cp out Main
```

## Sample run

```
===== Library Menu =====
1. Add book
2. View all books
3. Search by title
4. Borrow book
5. Return book
6. Remove book
0. Exit
Enter choice: 4
Enter book id to borrow: 1
Book borrowed.

Enter choice: 4
Enter book id to borrow: 1
Book is already borrowed.

Enter choice: 0
Goodbye!
```

## Author
Pulibandla Jithendra Venkata Siva Sai
