package com.apbok.backend.entity.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserAppsKey implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	Long userId;
	
	@Column(name = "app_id")
	Long appId;

	public UserAppsKey(Long userId, Long appId) {
		this.userId = userId;
		this.appId = appId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAppsKey other = (UserAppsKey) obj;
		return Objects.equals(appId, other.appId) && Objects.equals(userId, other.userId);
	}
	
	public UserAppsKey() {}
}
