package com.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.model.Book;
import com.model.Borrower;

public class Library {

	private Map<String, Book> books = new HashMap<>();

	private Map<String, Borrower> borrowers = new HashMap<>();

	private static final double LATE_FEE_PER_DAY = 1.00;

	public void addBook(Book book) {

		// Check if the ISBN already exists in the library catalog
		if (books.containsKey(book.getIsbn())) {
			System.out.println("Book with ISBN " + book.getIsbn() + " already exists in the library.");
			// Book already exists, do not add it
		}

		// Add book to the library
		books.put(book.getIsbn(), book);
		System.out.println("Book added: " + book.getTitle() + " with ISBN: " + book.getIsbn());
	}

	// Method to remove a book
	public void removeBook(String isbn) {
		for (Book book : books.values()) {
			if (book.getIsbn().equals(isbn)) {
				books.remove(book.getIsbn());
				System.out.println("Book with ISBN " + isbn + " has been removed.");
				return;
			}
		}
		System.out.println("Book with ISBN " + isbn + " not found.");
	}

	public String addNewBorrower(Borrower borrower) {

		String membershipId = UUID.randomUUID().toString(); // Generate a unique ID
		borrower.setMembershipId(membershipId);
		borrower.setIsActive(true);
		borrowers.put(membershipId, borrower);

		return membershipId;
	}

	public String updateBorrowerPhoneNumber(String membershipId, String phoneNumber) {

		Borrower borrower = borrowers.get(membershipId);
		borrower.setPhoneNumber(phoneNumber);
		borrowers.put(membershipId, borrower);

		return membershipId;
	}

	public void borrowBook(String membershipId, String isbn) {
		Borrower borrower = borrowers.get(membershipId);
		Book book = books.get(isbn);

		if (borrower != null && book != null && book.getQuantity() > 0) {
			book.setQuantity(book.getQuantity() - 1);

			// Get today's date and add 7 days to it to calculate the due date using
			// LocalDate
			LocalDate dueDate = LocalDate.now().plusDays(7);
			borrower.getBorrowedBooks().put(isbn, dueDate);

			System.out.println(borrower.getName() + " borrowed " + book.getTitle());

		} else {
			System.out.println("Unable to borrow book.");
		}
	}

	public void returnBook(String membershipId, String isbn) {
		Borrower borrower = borrowers.get(membershipId);
		Book book = books.get(isbn);

		if (borrower != null && book != null && borrower.getBorrowedBooks().containsKey(isbn)) {

			// Get the due date for the borrowed book
			LocalDate dueDate = borrower.getBorrowedBooks().get(isbn);

			// Calculate the number of overdue days
			long overdueDays = java.time.temporal.ChronoUnit.DAYS.between(dueDate, LocalDate.now());

			// If the book is overdue, calculate the late fee
			double lateFee = 0;
			if (overdueDays > 0) {
				lateFee = overdueDays * LATE_FEE_PER_DAY;
				System.out.println("The book is overdue by " + overdueDays + " days. Late fee: $" + lateFee);
			}

			book.setQuantity(book.getQuantity() + 1);
			borrower.getBorrowedBooks().remove(isbn);
			System.out.println(borrower.getName() + " returned " + book.getTitle());
		} else {
			System.out.println("Unable to return book.");
		}
	}

	// Method to remove a borrower by setting their status to inactive
	public void removeBorrower(String membershipId) {
		Borrower borrower = borrowers.get(membershipId);

		if (borrower != null) {
			borrower.setIsActive(false);
			System.out.println("Borrower with Membership ID " + membershipId + " has been deactivated.");
		} else {
			System.out.println("Borrower with Membership ID " + membershipId + " not found.");
		}
	}

	public int checkAvailability(String userInput, Integer option) {

		switch (option) {
		case 1: {

			return searchByTitle(userInput);
		}
		case 2: {

			return searchByAuthor(userInput);
		}
		case 3: {

			return searchByGenre(userInput);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}

	}

	private int searchByGenre(String genre) {

		for (Book book : books.values()) {

			if (book.getGenre().equals(genre)) {
				return book.getQuantity();
			}
		}

		return 0;
	}

	private int searchByAuthor(String author) {

		for (Book book : books.values()) {

			if (book.getAuthor().equals(author)) {
				return book.getQuantity();
			}
		}

		return 0;
	}

	private int searchByTitle(String title) {

		for (Book book : books.values()) {

			if (book.getTitle().equals(title)) {
				return book.getQuantity();
			}
		}

		return 0;
	}

}
