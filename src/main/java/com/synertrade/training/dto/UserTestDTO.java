package com.synertrade.training.dto;

import java.util.Date;

import com.synertrade.training.vo.TrainingAddressVO;
import com.synertrade.training.vo.TrainingApplicationVO;

public class UserTestDTO {
	
	private int id;
	
	private String username;
	
	private String name;
	
	private String date;
	
	private TrainingApplicationVO application = null;
	
	private TrainingAddressVO address = null;
	
	public UserTestDTO () {	}

	public int getId() {
		return id;
	}

	public TrainingApplicationVO getApplication() {
		return application;
	}

	public void setApplication(TrainingApplicationVO application) {
		this.application = application;
	}

	public TrainingAddressVO getAddress() {
		return address;
	}

	public void setAddress(TrainingAddressVO address) {
		this.address = address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
