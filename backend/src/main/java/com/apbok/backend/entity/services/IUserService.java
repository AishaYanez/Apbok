package com.apbok.backend.entity.services;

import java.util.List;

import com.apbok.backend.entity.models.User;

public interface IUserService {
	public User getUser(String email);
	public List<User> getAllUsers();
	public void postUser(User user);
	public void putPassword(String email, String password);
	public void deleteUser(String email);
}
