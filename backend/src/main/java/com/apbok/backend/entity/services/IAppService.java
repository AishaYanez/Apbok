package com.apbok.backend.entity.services;

import java.util.List;

import com.apbok.backend.entity.models.App;

public interface IAppService {
	public List<App> getAllApps();
	//public App getAllUserApps(long id);
	public void postApp(App app);
	public void putApp(App app);
	public void deleteApp(long id);
}
