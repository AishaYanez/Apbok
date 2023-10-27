package com.aisha.appGallery.entity.services;

import com.aisha.appGallery.entity.models.User;

public interface IUserService {
	public User getUser(String email);
	public void postUser(User user);
	public void putPassword(long id, User user);
	public void deleteUser(long id);
}
