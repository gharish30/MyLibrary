package com.hash.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hash.main.entity.Book;
import com.hash.main.entity.BorrowedBook;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
	Optional<BorrowedBook> findByBookAndReturnDateIsNull(Book book);
}
