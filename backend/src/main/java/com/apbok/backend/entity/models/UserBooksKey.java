package com.apbok.backend.entity.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserBooksKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	Long userId;
	
	@Column(name = "book_id")
	Long bookId;

	public UserBooksKey(Long userId, Long bookId) {
		this.userId = userId;
		this.bookId = bookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long appId) {
		this.bookId = appId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBooksKey other = (UserBooksKey) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(userId, other.userId);
	}
	
	public UserBooksKey() {}
}
