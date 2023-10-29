package com.apbok.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apbok.backend.entity.models.Book;
import com.apbok.backend.entity.services.BookServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	@GetMapping("/books")
	private List<Book> getAllBooks(){
		return (List<Book>)bookService.getAllBooks();
	}
	
	@PostMapping("/books")
	public ResponseEntity<String> postBook(Book book) {
	    try {
	        bookService.postBook(book);
	        return ResponseEntity.ok("Libro creado con éxito");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
	
	@DeleteMapping("/books/{id}")
	private ResponseEntity<String> deleteBook(@PathVariable(name="id") long id){
		try {
			bookService.deleteBook(id);
	        return ResponseEntity.ok("Libro borrado con éxito");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
	
	@PutMapping("/books/{id}")
	private ResponseEntity<String> putBook(@PathVariable(name="id") long id, Book book) {
		try {
			bookService.putBook(book);
	        return ResponseEntity.ok("Libro actualizado con éxito");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
}
