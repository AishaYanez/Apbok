package com.apbok.backend.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apbok.backend.entity.dao.IUserDao;
import com.apbok.backend.entity.models.User;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	public User getUser(String email) {
		return (User) userDao.findUserByEmail(email);
	}
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userDao.findAll();
	}
	
	@Override
	public void postUser(User user) {
		userDao.save(user);
	}

	@Override
	public void putPassword(String email, String password) {
		User u = userDao.findUserByEmail(email);
			u.setPassword(password);
			userDao.save(u);
	}

	@Override
	public void deleteUser(String email) {
		User u = userDao.findUserByEmail(email);
		userDao.deleteById(u.getId());
	}
}