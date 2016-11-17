package com.synertrade.training.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.synertrade.training.bu.UserBU;
import com.synertrade.training.form.UpdateUserForm;

public class UpdateUser extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
		UpdateUserForm newUser = (UpdateUserForm) form;
		
		String id = newUser.getId();
		
		String username = newUser.getUsername();
		
		String name = newUser.getName();
		
		String date = newUser.getDate();
		
		UserBU usrBu = new UserBU();
		
		String target = "failure";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d = null;
		try {
			d = sdf.parse(date);
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(usrBu.updateUser(Integer.parseInt(id), username, name, d)) {
			target = "success";
			
			request.setAttribute("users", usrBu.getUserList());
		}
		
		return (mapping.findForward(target));
	}
}
