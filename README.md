Library Management System
Description
The Library Management System is a simplified Java-based application that leverages object-oriented programming concepts.

Key Features
1. Book Management
Add new books to the library database with details such as title, author, ISBN, genre, and quantity.
Remove books from the library database when no longer available.
2. Borrower Management
Add new borrowers, including details such as name and contact information. After successful registration, borrowers will receive a membership ID from the library.
Update borrower details as required (e.g., contact information).
Remove borrowers from the system if necessary.
3. Book Borrowing and Returning
Allow borrowers to borrow books by providing their membership ID and book ISBN.
Store the due date for each borrowed book.
Provide mechanisms for borrowers to return books, updating the library records accordingly, and handle late returns by charging a fee.
4. Book Search and Availability
Enable users to search for books by title, author, or genre.
Display the availability status (number of copies available) in the search results.





Innovative Feature: Soft Deletion for Borrower Records

In the Library Management System, instead of permanently deleting (hard deletion) borrower records from the system, a soft deletion approach has been implemented. This means:
Borrower accounts are marked as inactive rather than being erased from the database.
This ensures historical records are preserved for future reference or audits.
The system can later support reactivating borrowers if needed, offering flexibility and data integrity.


technology Stack

Programming Language: Java

Concepts: Object-Oriented Programming (OOP)

Data Storage: Collections  HashMap




Future Enhancements

1)Integration with a database (e.g., MySQL) for permanent data storage to replace in-memory HashMap collections, enabling scalability and persistence.

2)Implementing automated notifications via SMS and email:

3)Sending membership IDs via email after successful borrower registration.

4)Notifying borrowers about due dates and overdue fees through SMS and email.

5)Sending acknowledgment emails and fee receipts after returning books.

6)Converting this standalone Java project into a Spring Boot application to leverage modern Java frameworks for better integration with additional services.

