package com.synertrade.training.vo;

import java.util.HashSet;
import java.util.Set;

public class TrainingApplicationVO {
	
	private int id;
	
	private String name;
	
	private Set<UserVO> users = new HashSet<UserVO>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserVO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserVO> users) {
		this.users = users;
	}
	
	public void addUser(UserVO user) {
		user.setApplication(this);
		users.add(user);
	}
	
}
