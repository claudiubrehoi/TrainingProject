package com.synertrade.training.vo;

import java.util.HashSet;
import java.util.Set;

public class TrainingAddressVO extends BaseVO {
	
	private int id;
	
	private int number;
	
	private String zip;
	
	private TrainingStreetVO street;
	
	private Set<UserVO> users = new HashSet<UserVO>();
	
	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getName() {
		return "nr. " + number + " ZIP: " + zip;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public TrainingStreetVO getStreet() {
		return street;
	}

	public void setStreet(TrainingStreetVO street) {
		this.street = street;
	}

	public Set<UserVO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserVO> users) {
		this.users = users;
	}
	
	public void addUser(UserVO user) {
		user.setAddress(this);
		users.add(user);
	}
	
	@Override
	public String toString() {
		return this.number + " " + street.getName() + " street " + street.getCity().getName() + " " + street.getCity().getCountry().getName();
	}
	
	
}
