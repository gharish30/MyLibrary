package com.hash.main.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hash.main.dto.BorrowerDto;
import com.hash.main.entity.Book;
import com.hash.main.entity.BorrowedBook;
import com.hash.main.entity.Borrower;
import com.hash.main.exceptions.CustomException;
import com.hash.main.repository.BookRepository;
import com.hash.main.repository.BorrowedBookRepository;
import com.hash.main.repository.BorrowerRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BorrowedBookRepository borrowedBookRepository;

	@Override
	public Borrower createBorrower(BorrowerDto borrowerDto) {
		Borrower borrower = new Borrower();
		borrower.setName(borrowerDto.getName());
		borrower.setEmail(borrowerDto.getEmail());
		
		return borrowerRepository.save(borrower);
	}

	@Override
	public BorrowedBook borrowBook(Long borrowerId, Long bookId) {
		Borrower borrower = borrowerRepository.findById(borrowerId).orElseThrow(() -> new CustomException("Borrower not found"));
				
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new CustomException("Book not found"));
		
		borrowedBookRepository.findByBookAndReturnDateIsNull(book)
        .ifPresent(b -> {
            throw new CustomException("Book is already borrowed");
        });
		
		BorrowedBook borrowedBook = new BorrowedBook();
		borrowedBook.setBorrower(borrower);
		borrowedBook.setBook(book);
		borrowedBook.setBorrowDate(LocalDate.now());
			
		
		return borrowedBookRepository.save(borrowedBook);
	}

	@Override
	public BorrowedBook returnBook(Long borrowerId, Long bookId) {

		Book book = bookRepository.findById(bookId).orElseThrow(() -> new CustomException("Book not found"));

        BorrowedBook borrowed = borrowedBookRepository.findByBookAndReturnDateIsNull(book).orElseThrow(() -> new CustomException("This book is not currently borrowed"));

        if (!borrowed.getBorrower().getId().equals(borrowerId)) {
           throw new CustomException("This book is not borrowed by the specified borrower");
        }

        borrowed.setReturnDate(LocalDate.now());
        return borrowedBookRepository.save(borrowed);
		
		
	}

}
