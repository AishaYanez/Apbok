package com.aisha.appGallery.entity.services;

import java.util.List;
import com.aisha.appGallery.entity.models.App;

public interface IAppService {
	public List<App> getAllApps();
	public App getAllUserApps(long id);
}
