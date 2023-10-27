package com.aisha.appGallery.entity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aisha.appGallery.entity.models.App;
import com.aisha.appGallery.entity.models.AppsGallery;
import com.aisha.appGallery.entity.models.AppsGalleryKey;

public interface IAppsGalleryDao extends CrudRepository <AppsGallery, AppsGalleryKey>{
	@Query("SELECT a FROM App a JOIN AppsGallery ag ON a.id = ag.app.id WHERE ag.user.id = :id")
	public List<App> findAppsByUserId(@Param("id") long id);

}
