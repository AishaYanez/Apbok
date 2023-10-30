package com.apbok.backend.entity.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="user_books")
public class UserBooks {

	@EmbeddedId
	UserBooksKey id;
	
	@ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
	User user;
	
	@ManyToOne
    @MapsId("appId")
    @JoinColumn(name = "book_id")
	Book book;
	
	boolean favorite;

	public UserBooks(UserBooksKey id, User user, Book book, boolean favorite) {
		this.id = id;
		this.user = user;
		this.book = book;
		this.favorite = favorite;
	}

	public UserBooksKey getId() {
		return id;
	}

	public void setId(UserBooksKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
}
