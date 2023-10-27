package com.aisha.appGallery.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.aisha.appGallery.entity.models.App;

public interface IAppDao extends CrudRepository<App, Long> {
	
}
