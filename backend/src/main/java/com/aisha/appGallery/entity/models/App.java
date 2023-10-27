package com.aisha.appGallery.entity.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "apps")
public class App implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="app_id")
	private long id;
	
	@Column(name="img_app")
	private String imgApp;
	private String name;
	private String description;
	private float price;
	
	public App(String imgApp, String name, String description, float price) {
		super();
		this.imgApp = imgApp;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	@OneToMany(mappedBy = "app")
    Set<AppsGallery> favorite = new HashSet<AppsGallery>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImgApp() {
		return imgApp;
	}
	public void setImgApp(String imgApp) {
		this.imgApp = imgApp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public App(){}
}
