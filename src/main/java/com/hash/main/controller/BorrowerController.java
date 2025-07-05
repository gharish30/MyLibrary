package com.hash.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hash.main.dto.BorrowerDto;
import com.hash.main.entity.BorrowedBook;
import com.hash.main.entity.Borrower;
import com.hash.main.service.BorrowerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/api/borrower")
@RequiredArgsConstructor
public class BorrowerController {
	
	@Autowired
	private BorrowerService borrowerService;
	
	@PostMapping
	public ResponseEntity<Borrower> registerBorrower(@RequestBody BorrowerDto borrowerDto) {
		return ResponseEntity.ok(borrowerService.createBorrower(borrowerDto));
	}
	
	@PostMapping("/{borrowerId}/borrow/{bookId}")
	public ResponseEntity<BorrowedBook> borrowBook(@PathVariable Long borrowerId, @PathVariable Long bookId) {
		return ResponseEntity.ok(borrowerService.borrowBook(borrowerId, bookId));
	}
	
	@PostMapping("/{borrowerId}/return/{bookId}")
	public ResponseEntity<BorrowedBook> returnBook(@PathVariable Long borrowerId, @PathVariable Long bookId) {
		return ResponseEntity.ok(borrowerService.returnBook(borrowerId, bookId));
	}
	
	
}












