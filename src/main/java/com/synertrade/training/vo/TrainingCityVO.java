package com.synertrade.training.vo;

import java.util.HashSet;
import java.util.Set;

public class TrainingCityVO {
	private int id;
	
	private String name;
	
	private TrainingCountryVO country;
	
	private Set<TrainingStreetVO> streets = new HashSet<TrainingStreetVO>();

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

	public TrainingCountryVO getCountry() {
		return country;
	}

	public void setCountry(TrainingCountryVO country) {
		this.country = country;
	}

	public Set<TrainingStreetVO> getStreets() {
		return streets;
	}

	public void setStreets(Set<TrainingStreetVO> streets) {
		this.streets = streets;
	}
	
	public void addStreet(TrainingStreetVO street) {
		street.setCity(this);
		streets.add(street);
	}
}
