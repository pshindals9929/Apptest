package com.Ccorner.securityapp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customers {
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	private String userName;
	private String password;
	private String email;
	public Customers() {};
	
	public Customers(int iD, String username, String password, String email) {
		super();
		ID = iD;
		this.userName = username;
		this.password = password;
		this.email = email;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
	
	
}
