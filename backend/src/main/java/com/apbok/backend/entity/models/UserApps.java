package com.apbok.backend.entity.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="user_apps")
public class UserApps {

	@EmbeddedId
	UserAppsKey id;
	
	@ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
	User user;
	
	@ManyToOne
    @MapsId("appId")
    @JoinColumn(name = "app_id")
	App app;
	
	boolean favorite;

	public UserApps(UserAppsKey id, User user, App app, boolean favorite) {
		this.id = id;
		this.user = user;
		this.app = app;
		this.favorite = favorite;
	}

	public UserAppsKey getId() {
		return id;
	}

	public void setId(UserAppsKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
	
	public UserApps() {}
}
