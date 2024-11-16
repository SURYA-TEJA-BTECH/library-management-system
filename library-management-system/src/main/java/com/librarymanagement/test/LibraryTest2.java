package com.librarymanagement.test;

import com.model.Book;
import com.service.Library;
import com.model.Borrower;

public class LibraryTest2 {

	public static void main(String[] args) {
		Library library = new Library();

		// Display welcome message
		System.out.println("Welcome to the Library Management System!");

		// Add sample books
		Book book1 = new Book("12345", "Rich Dad Poor Dad", "Robert", "non-fiction", 5);
		Book book2 = new Book("67890", "The Secret", "byrne", "self-help", 3);
		library.addBook(book1);
		library.addBook(book2);

		// Add sample borrowers
		Borrower borrower1 = new Borrower("surya ", "123-456-7890");
		Borrower borrower2 = new Borrower("yogindhra", "987-654-3210");

		String membershipId1 = library.addNewBorrower(borrower1);
		String membershipId2 = library.addNewBorrower(borrower2);

		System.out.println("New borrower added with Membership ID: " + membershipId1);
		System.out.println("New borrower added with Membership ID: " + membershipId2);

		// Borrow books
		library.borrowBook(membershipId1, "12345");
		library.borrowBook(membershipId2, "67890");

		// Check availability after borrowing
		int availableCopies1 = library.checkAvailability("Rich Dad Poor Dad", 1);
		int availableCopies2 = library.checkAvailability("The Secret", 1);
		System.out.println("Available copies of 'Rich Dad Poor Dad': " + availableCopies1);
		System.out.println("Available copies of 'The Secret': " + availableCopies2);

		// Return books
		library.returnBook(membershipId1, "12345");
		library.returnBook(membershipId2, "67890");

		// Check availability after returning
		availableCopies1 = library.checkAvailability("Rich Dad Poor Dad", 1);
		availableCopies2 = library.checkAvailability("The Secret", 1);
		System.out.println("Available copies of 'Rich Dad Poor Dad': " + availableCopies1);
		System.out.println("Available copies of 'The Secret': " + availableCopies2);

		// Exit message
		System.out.println("Thank you for using the Library Management System!");
	}
}
