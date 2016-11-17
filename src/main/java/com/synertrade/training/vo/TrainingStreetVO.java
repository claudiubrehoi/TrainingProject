package com.synertrade.training.vo;

import java.util.HashSet;
import java.util.Set;

public class TrainingStreetVO {
	
	private int id;
	
	private String name;
	
	private TrainingCityVO city;
	
	private Set<TrainingAddressVO> addresses = new HashSet<TrainingAddressVO>();

	public Set<TrainingAddressVO> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<TrainingAddressVO> addresses) {
		this.addresses = addresses;
	}
	
	public void addAddress(TrainingAddressVO address) {
		address.setStreet(this);
		addresses.add(address);
	}

	public TrainingCityVO getCity() {
		return city;
	}

	public void setCity(TrainingCityVO city) {
		this.city = city;
	}

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
	
	
}
