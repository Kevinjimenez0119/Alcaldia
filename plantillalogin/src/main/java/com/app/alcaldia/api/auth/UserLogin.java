package com.app.alcaldia.api.auth;

import java.io.Serializable;

public class UserLogin implements Serializable {

	private String username;

	private String password;

	public UserLogin() {

	}

	public UserLogin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private static final long serialVersionUID = 1L;

}
