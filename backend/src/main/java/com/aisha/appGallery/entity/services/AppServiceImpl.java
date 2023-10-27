package com.aisha.appGallery.entity.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.aisha.appGallery.entity.dao.IAppDao;
import com.aisha.appGallery.entity.models.App;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements IAppService{
	
	@Autowired
	private IAppDao appDao;

	@Override
	public List<App> getAllApps() {
		return (List<App>) appDao.findAll();
	}
	
	@Override
	public App getAllUserApps(long id) {
		return (App) appDao.findById(id).get();
	}
}