package com.hash.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hash.main.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	boolean existsByIsbnAndTitleAndAuthor(String isbn, String title, String author);
}
