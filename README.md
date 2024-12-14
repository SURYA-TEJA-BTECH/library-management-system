# **Library Management System**

## **Description**
The Library Management System is a simplified Java-based application that leverages object-oriented programming (OOP) concepts. It provides functionality for managing books, borrowers, and library operations efficiently.

---

## **Key Features**

### 1. **Book Management**
- Add new books to the library database with details such as:
  - Title
  - Author
  - ISBN
  - Genre
  - Quantity
- Remove books from the library database when they are no longer available.

### 2. **Borrower Management**
- Add new borrowers, including:
  - Name
  - Contact information  
  - Upon successful registration, borrowers receive a membership ID.
- Update borrower details (e.g., contact information).
- Remove borrowers from the system when necessary.

### 3. **Book Borrowing and Returning**
- Borrowers can:
  - Borrow books by providing their membership ID and book ISBN.
  - Have a due date stored for each borrowed book.
- Return books, with the system updating records accordingly.
- Handle late returns by charging a late fee.

### 4. **Book Search and Availability**
- Search for books by:
  - Title
  - Author
  - Genre
- Display the availability status (number of copies available) in search results.

---

## **Innovative Feature: Soft Deletion for Borrower Records**

Instead of permanently deleting borrower records (hard deletion), the system implements **soft deletion**:  
- Borrower accounts are marked as inactive rather than being erased from the database.
- Preserves historical records for audits and future reference.
- Provides flexibility to reactivate borrowers if needed.

---

## **Technology Stack**

- **Programming Language:** Java  
- **Concepts:** Object-Oriented Programming (OOP)  
- **Data Storage:** Collections (`HashMap`)

---

## **Future Enhancements**

1. **Integration with a Database:**  
   - Replace in-memory `HashMap` collections with a relational database (e.g., MySQL) for permanent data storage, enabling scalability and persistence.  

2. **Automated Notifications via SMS and Email:**  
   - Send membership IDs via email after successful borrower registration.  
   - Notify borrowers about due dates and overdue fees.  
   - Send acknowledgment emails and fee receipts after returning books.  

3. **Framework Upgrade:**  
   - Convert this standalone Java project into a Spring Boot application to leverage modern Java frameworks for better integration with additional services.
