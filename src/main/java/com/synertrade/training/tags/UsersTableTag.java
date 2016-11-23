package com.synertrade.training.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.synertrade.training.bu.UserBU;
import com.synertrade.training.vo.UserVO;

public class UsersTableTag extends SimpleTagSupport {
	
	UserBU user;
	
	@Override
	public void doTag() throws JspException, IOException{
		
		String response = "";
		
		
		
		response = response.concat("<h3>This is a custom tag for displaying the users</h3><br />\n"
				 + "<table>\n"
					 + "<tr>\n"
						 + "<td>User ID</td>\n"
						 + "<td>Username</td>\n"
						 + "<td>Name</td>\n"
						 + "<td>Birth date</td>\n"
						 + "<td>Street</td>\n"
						 + "<td>Number</td>\n"
						 + "<td>City</td>\n"
						 + "<td>Country</td>\n"
						 + "<td>ZIP Code</td>\n"
						 + "<td>Application</td>\n"
					 + "</tr>\n");
		
		user = new UserBU();
		
		List<UserVO> users = user.getUserList(UserVO.class);
		
		for(UserVO u : (List<UserVO>) users) {
			response = response.concat("<tr>\n"
							+ "<td>" + u.getId() + "</td>"
							+ "<td>" + u.getUsername() + "</td>"
							+ "<td>" + u.getName() + "</td>"
							+ "<td>" + u.getBirth_date().toString() + "</td>"
							+ "<td>" + u.getAddress().getStreet().getName() + "</td>"
							+ "<td>" + u.getAddress().getNumber() + "</td>"
							+ "<td>" + u.getAddress().getStreet().getCity().getName() + "</td>"
							+ "<td>" + u.getAddress().getStreet().getCity().getCountry().getName() + "</td>"
							+ "<td>" + u.getAddress().getZip() + "</td>"
							+ "<td>" + u.getApplication().getName() + "</td>"
						+ "</tr>\n");
		}
		
		response = response.concat("</table>\n");
		
		SelectStreetTag streetTag = new SelectStreetTag();
		
		String tagString = streetTag.getTagHtml(users.get(0).getAddress().getStreet().getId());
		
//		response = "<custom:selectStreet selected='" + users.get(0).getAddress().getStreet().getId() + "' />\n";
		
		JspWriter out = getJspContext().getOut();
		
		out.println(response.concat(tagString));
	}

}
