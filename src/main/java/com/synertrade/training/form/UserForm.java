package com.synertrade.training.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UserForm extends ActionForm {

	private static final long serialVersionUID = 5451148253439767511L;
	
	private int id;
	
	private String username;
	
	private String name;
	
	private Date date;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
      this.id = 0;
      this.username = null;
      this.name = null;
      this.date = null;
	}	
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

     	//create a new instance of actionErrors
		ActionErrors actionErrors = new ActionErrors();
		
		if(id == 0) {
			actionErrors.add("IdError", new ActionMessage("Id field should not be empty!"));
		}
     	if(username == null) {
     		actionErrors.add("UsernameError", new ActionMessage("Username field should not be empty!"));
     	}
     	if(name == null) {
     		actionErrors.add("NameError", new ActionMessage("Name field should not be empty!"));
     	}
     	//Return the errors
     	return actionErrors;
     }
}
