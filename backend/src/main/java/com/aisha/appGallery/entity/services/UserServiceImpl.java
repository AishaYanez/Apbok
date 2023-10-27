package com.aisha.appGallery.entity.services;

import com.aisha.appGallery.entity.dao.IUserDao;
import com.aisha.appGallery.entity.models.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUser(String email) {
		return (User) userDao.findUserByEmail(email);
	}

	@Override
	public void postUser(User user) {
		userDao.save(user);
	}

	@Override
	public void putPassword(long id, User user) {
		Optional<User> u = userDao.findById(id);
		if(u.isPresent()) {
			user.setId(id);
			userDao.save(user);
		}
	}

	@Override
	public void deleteUser(long id) {
		userDao.deleteById(id);
	}
}
