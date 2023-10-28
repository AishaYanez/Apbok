package com.apbok.backend.entity.models;

import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	long id;
	
	@Column(name = "user_code")
	String userCode;
	@Column(name = "nick_name")
	String nickName;
	String email;
	String password;
	String img = "img_logOut.png";
	boolean rol;
	
	public User(String userCode, String nickName, String email, String password) {
		this.userCode = userCode;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
	}
	
	//@OneToMany(mappedBy = "user")
    //Set<UserApps> favorite = new HashSet<UserApps>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	/*Esta parte esta en prueba*/

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public boolean isRol() {
		return rol;
	}

	public void setRol(boolean rol) {
		this.rol = rol;
	}
	
	//---------------------------

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(){}
}