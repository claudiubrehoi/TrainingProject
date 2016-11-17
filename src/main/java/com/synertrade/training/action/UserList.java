package com.synertrade.training.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.synertrade.training.bu.UserBU;
import com.synertrade.training.form.UserForm;

public class UserList extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
		UserForm newUser = (UserForm) form;
		
		int id = newUser.getId();
		
		String username = newUser.getUsername();
		
		String name = newUser.getName();
		
		UserBU usrBu = new UserBU();
		
		String target = "failure";
		
		if(usrBu.saveUser(id, username, name)) {
			target = "success";
			
			request.setAttribute("users", usrBu.getUserList());
		}
		
		return (mapping.findForward(target));
	}
}
