# LibraryProject 📚

Library is a small Java console application for managing a simple book collection.

The user can view all books currently stored in the library, search for a book by title, and add new books during the program session. Each book is represented by a `Book` object containing information such as title, author, ISBN, publication year, series, series number, and page count.

The project uses an `ArrayList` to store the books, which means the collection can grow while the program is running. The program is also divided into several methods for different tasks, such as printing the book list, searching for books, adding new books, and closing the program.

I created this project while learning more about object-oriented programming in Java. It gave me practice working with classes and objects, methods, `ArrayList`, loops, user input, and `try/catch` for handling invalid input.

I also added colour-coded console output to make the program easier to read and to make error messages stand out more clearly.

## Current limitations

The program still has some limitations that I would like to improve in the future.

* The search currently stops after the first matching book is found.
* Empty titles or author names can still be added.
* The book list is not saved permanently, so newly added books are lost when the program closes.

## Possible future improvements

Some ideas for continuing the project are:

* show all books that match a search
* add validation for empty fields
* allow books to be removed
* save and load the book collection from a file
