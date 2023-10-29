package com.apbok.backend.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apbok.backend.entity.dao.IBookDao;
import com.apbok.backend.entity.models.Book;

@Service
public class BookServiceImpl implements IBookService{
	
	@Autowired
	private IBookDao bookDao;

	@Override
	public List<Book> getAllBooks() {
		return (List<Book>) bookDao.findAll();
	}
	/*
	@Override
	public Book getAllUserBooks(long id) {
		return (Book) bookDao.findById(id).get();
	}
	*/
	@Override
	public void postBook(Book book) {
		bookDao.save(book);
	}

	@Override
	public void putBook(Book book) {
		bookDao.save(book);
	}

	@Override
	public void deleteBook(long id) {
		bookDao.deleteById(id);
	}
}
