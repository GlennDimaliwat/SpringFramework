package com.glenndimaliwat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsers;
	@Column
	private String username;
	@Column
	private String password;
	
	public Users() {}
	public Users(int idUsers, String username, String password) {
		super();
		this.idUsers = idUsers;
		this.username = username;
		this.password = password;
	}
	
	public int getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
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
	
}
