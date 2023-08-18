package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String userName;

	private String Passward;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassward() {
		return Passward;
	}

	public void setPassward(String passward) {
		Passward = passward;
	}

	@Override
	public String toString() {
		return "LoginData [id=" + id + ", userName=" + userName + ", Passward=" + Passward + "]";
	}

}
