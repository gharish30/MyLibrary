package com.hash.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hash.main.dto.BookDto;
import com.hash.main.entity.Book;
import com.hash.main.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book createBook(BookDto bookDto) {
		Book book = new Book();
		book.setIsbn(bookDto.getIsbn());
		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}
