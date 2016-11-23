package com.synertrade.training.vo;

import java.util.HashSet;
import java.util.Set;

//import org.hibernate.mapping.Set;

public class TrainingCountryVO extends BaseVO {
	
	private int id;
	
	private String name;
	
	private Set<TrainingCityVO> cities = new HashSet<TrainingCityVO>();
	
	@Override
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

	public Set<TrainingCityVO> getCities() {
		return cities;
	}

	public void setCities(Set<TrainingCityVO> cityies) {
		this.cities = cityies;
	}
	
	public void addCity(TrainingCityVO city) {
		city.setCountry(this);
		cities.add(city);
	}
}