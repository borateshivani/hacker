package com.demo.service;

import java.util.List;

import com.demo.bean.Book;

public interface BookService {
	List<Book> getBooks(String b);

	Book getBookById(int bookId);
}
