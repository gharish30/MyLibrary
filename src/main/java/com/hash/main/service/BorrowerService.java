package com.hash.main.service;

import com.hash.main.dto.BorrowerDto;
import com.hash.main.entity.BorrowedBook;
import com.hash.main.entity.Borrower;

public interface BorrowerService {
	
	Borrower createBorrower(BorrowerDto borrowerDto);
	BorrowedBook borrowBook(Long borrowerId, Long bookId);
	BorrowedBook returnBook(Long borrowerId, Long bookId);
	

}
