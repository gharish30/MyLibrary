package com.hash.main.service;

import java.util.List;

import com.hash.main.dto.BookDto;
import com.hash.main.entity.Book;

public interface BookService {
	Book createBook(BookDto bookDto);
	List<Book> getAllBooks();
}
