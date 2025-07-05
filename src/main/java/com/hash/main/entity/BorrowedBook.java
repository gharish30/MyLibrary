package com.hash.main.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class BorrowedBook {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Borrower borrower;

    @OneToOne(optional = false)
    private Book book;

    private LocalDate borrowDate;

    private LocalDate returnDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public BorrowedBook(Long id, Borrower borrower, Book book, LocalDate borrowDate, LocalDate returnDate) {
		super();
		this.id = id;
		this.borrower = borrower;
		this.book = book;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public BorrowedBook() {
		super();
	}
    
    

}
