package com.apbok.backend.entity.services;

import java.util.List;

import com.apbok.backend.entity.models.Book;

public interface IBookService {
	public List<Book> getAllBooks();
	//public Book getAllUserBooks(long id);
	public void postBook(Book book);
	public void putBook(Book book);
	public void deleteBook(long id);
}