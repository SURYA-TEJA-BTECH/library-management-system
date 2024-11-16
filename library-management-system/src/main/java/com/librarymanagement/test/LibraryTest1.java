package com.librarymanagement.test;

import com.model.Book;
import com.service.Library;
import com.model.Borrower;

import java.util.Scanner;

public class LibraryTest1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();

		System.out.println("Welcome to the Library Management System!");

		try {
			while (true) {
				// Display menu options
				System.out.println("\nPlease select an option:");
				System.out.println("1. Add a new book");
				System.out.println("2. Borrow a book");
				System.out.println("3. Return a book");
				System.out.println("4. Check book availability");
				System.out.println("5. Add a new borrower");
				System.out.println("6. Remove a book");
				System.out.println("7. Remove a borrower");
				System.out.println("8. Exit");
				System.out.print("Enter your choice: ");

				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume the newline left by nextInt()

				switch (choice) {
				case 1:
					// Add a new book
					System.out.print("Enter ISBN: ");
					String isbn = scanner.nextLine();
					System.out.print("Enter title: ");
					String title = scanner.nextLine();
					System.out.print("Enter author: ");
					String author = scanner.nextLine();
					System.out.print("Enter genre: ");
					String genre = scanner.nextLine();
					System.out.print("Enter quantity: ");
					int quantity = scanner.nextInt();
					scanner.nextLine(); // Consume the newline

					Book book = new Book(isbn, title, author, genre, quantity);
					library.addBook(book);

					try {
						Thread.sleep(5000); // Pauses for 2 seconds
					} catch (InterruptedException e) {
						System.out.println("Sleep interrupted: " + e.getMessage());
					}

					break;

				case 2:
					// Borrow a book
					System.out.print("Enter borrower membership ID: ");
					String membershipIdBorrower = scanner.nextLine();
					System.out.print("Enter ISBN of the book to borrow: ");
					String isbnToBorrow = scanner.nextLine();
					library.borrowBook(membershipIdBorrower, isbnToBorrow);

					try {
						Thread.sleep(5000); // Pauses for 2 seconds
					} catch (InterruptedException e) {
						System.out.println("Sleep interrupted: " + e.getMessage());
					}

					break;

				case 3:
					// Return a book
					System.out.print("Enter borrower membership ID: ");
					String membershipIdReturn = scanner.nextLine();
					System.out.print("Enter ISBN of the book to return: ");
					String isbnToReturn = scanner.nextLine();
					library.returnBook(membershipIdReturn, isbnToReturn);

					try {
						Thread.sleep(5000); // Pauses for 2 seconds
					} catch (InterruptedException e) {
						System.out.println("Sleep interrupted: " + e.getMessage());
					}

					break;

				case 4:
					// Ask for the search option
					System.out.print("Enter option for search (1 for title, 2 for author, 3 for genre): ");
					int option = scanner.nextInt();
					scanner.nextLine(); // Consume the newline left by nextInt()

					// Ask for the input data to check availability
					System.out.print("Enter the data to check availability: ");
					String input = scanner.nextLine();

					// Check availability based on the input
					int availableCopies = library.checkAvailability(input, option);
					System.out.println("Available copies of '" + input + "': " + availableCopies);

					try {
						Thread.sleep(5000); // Pauses for 2 seconds
					} catch (InterruptedException e) {
						System.out.println("Sleep interrupted: " + e.getMessage());
					}

					break;

				case 5:
					// Add a new borrower
					System.out.print("Enter borrower's name: ");
					String borrowerName = scanner.nextLine();
					System.out.print("Enter borrower's phone number: ");
					String phoneNumber = scanner.nextLine();
					Borrower borrower = new Borrower(borrowerName, phoneNumber);
					String membershipId = library.addNewBorrower(borrower);
					System.out.println("New borrower added with Membership ID: " + membershipId);

					try {
						Thread.sleep(5000); // Pauses for 2 seconds
					} catch (InterruptedException e) {
						System.out.println("Sleep interrupted: " + e.getMessage());
					}

					break;

				case 6:
					// Remove a book
					System.out.print("Enter ISBN of the book to remove: ");
					String isbnToRemove = scanner.nextLine();
					library.removeBook(isbnToRemove);

					try {
						Thread.sleep(5000); // Pauses for 2 seconds
					} catch (InterruptedException e) {
						System.out.println("Sleep interrupted: " + e.getMessage());
					}

					break;

				case 7:
					// Remove a borrower
					System.out.print("Enter borrower membership ID to remove: ");
					String membershipIdToRemove = scanner.nextLine();
					library.removeBorrower(membershipIdToRemove);

					try {
						Thread.sleep(5000); // Pauses for 2 seconds
					} catch (InterruptedException e) {
						System.out.println("Sleep interrupted: " + e.getMessage());
					}

					break;

				case 8:
					// Exit the program
					System.out.println("Thank you for using the Library Management System!");
					scanner.close();

					System.exit(0);

				default:
					System.out.println("Invalid choice! Please select a valid option.");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
