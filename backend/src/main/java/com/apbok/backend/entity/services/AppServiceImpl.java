package com.apbok.backend.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apbok.backend.entity.dao.IAppDao;
import com.apbok.backend.entity.models.App;

@Service
public class AppServiceImpl implements IAppService{

	@Autowired
	private IAppDao appDao;

	@Override
	public List<App> getAllApps() {
		return (List<App>) appDao.findAll();
	}
	/*
	@Override
	public App getAllUserApps(long id) {
		return (App) appDao.findById(id).get();
	}
	*/
	@Override
	public void postApp(App app) {
		appDao.save(app);
	}

	@Override
	public void putApp(App app) {
		appDao.save(app);
	}

	@Override
	public void deleteApp(long id) {
		appDao.deleteById(id);
	}

}
