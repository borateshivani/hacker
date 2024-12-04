package com.demo.service;

import java.util.List;

import com.demo.bean.Book;
import com.demo.dao.DaoOperations;
import com.demo.dao.DaoOperationsImpl;

public class BookServicesImpl implements BookService{
	DaoOperations dao = new DaoOperationsImpl();
	public List<Book> getBooks(String b) {
		
		return dao.getBooks(b);
	}

	public Book getBookById(int bookId) {
		return dao.getBookById(bookId);
	}

}
