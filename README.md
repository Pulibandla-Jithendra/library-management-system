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

## Author
Jithu