package com.synertrade.training.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SaveUserForm extends ActionForm {

	private static final long serialVersionUID = 8821825877682870647L;

	private String id;
	
	private String username;
	
	private String name;
	
	private String date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
      this.id = null;
      this.username = null;
      this.name = null;
      this.date = null;
	}	
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

     	//create a new instance of actionErrors
		ActionErrors actionErrors = new ActionErrors();
		
		if(id == null) {
			actionErrors.add("IdError", new ActionMessage("Id field should not be empty!"));
		}
     	if(username == null) {
     		actionErrors.add("UsernameError", new ActionMessage("Username field should not be empty!"));
     	}
     	if(name == null) {
     		actionErrors.add("NameError", new ActionMessage("Name field should not be empty!"));
     	}
     	if(date == null) {
     		actionErrors.add("DateError", new ActionMessage("Date field should not be empty"));
     	}
     	request.setAttribute("errors", actionErrors);
     	
     	//Return the errors
     	return actionErrors;
     }
}
