package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userRoleIs;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	@ManyToOne
	private Role role;
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole( User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}
	public int getUserRoleIs() {
		return userRoleIs;
	}
	public void setUserRoleIs(int userRoleIs) {
		this.userRoleIs = userRoleIs;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
