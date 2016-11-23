package com.synertrade.training.vo;

import java.sql.Date;

public class UserVO extends BaseVO {
	
	private int id;

	private String username;
	
	private String name;
	
	private Date birth_date;
	
	private TrainingAddressVO address;
	
	private TrainingApplicationVO application;
	
	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getBirth_date() {	
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
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



}
