package com.synertrade.training.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateUserForm extends ActionForm {

	private static final long serialVersionUID = 2570416608057347530L;
	
	private String id;
	
	private String username;
	
	private String name;
	
	private String date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(Integer.parseInt(id) > 0) {
			this.id = id;
		}
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = null;
			d = sdf.parse(date);
			if(d != null) {
				this.date = date;
			}
		}
		catch(ParseException e) {
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add("ParseDateError", new ActionMessage("Could not parse date from string"));
		}
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
