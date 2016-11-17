package com.synertrade.training.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.synertrade.training.bu.UserBU;

public class ShowUserList extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
		UserBU usrBu = new UserBU();
		
		request.setAttribute("users", usrBu.getUserList());
		
		return (mapping.findForward("success"));
	}
}
