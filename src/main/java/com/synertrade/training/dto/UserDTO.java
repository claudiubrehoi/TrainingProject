package com.synertrade.training.dto;

import java.util.Date;

import com.synertrade.training.vo.TrainingAddressVO;
import com.synertrade.training.vo.TrainingApplicationVO;

public class UserDTO {
	
	private int id;
	private String username;
	private String name;
	
	private Date date;
	
	private TrainingAddressVO address;
	
	private TrainingApplicationVO application;
	
	public TrainingAddressVO getAddress() {
		return address;
	}

	public void setAddress(TrainingAddressVO address) {
		this.address = address;
	}

	public TrainingApplicationVO getApplication() {
		return application;
	}

	public void setApplication(TrainingApplicationVO application) {
		this.application = application;
	}
	
	public UserDTO (int id, String username, String name) {
		this.id = id;
		this.name = name;
		this.username = username;
	}
	
	public UserDTO (int id, String username, String name, Date date) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.date = date;
	}
	
	public UserDTO (int id, String username, String name, Date date, TrainingAddressVO address, TrainingApplicationVO application) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.date = date;
		this.address = address;
		this.application = application;
	}

	public int getId() {
		return id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
