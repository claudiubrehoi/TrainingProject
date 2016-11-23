package com.synertrade.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.synertrade.training.bu.UserBU;
import com.synertrade.training.dao.UserDAO;
import com.synertrade.training.dto.UserDTO;
import com.synertrade.training.dto.UserTestDTO;

@WebServlet("/hibernate")
public class HibernateController extends HttpServlet {

	private static final String LIST_ACTION = "list";
	private static final String INSERT_ACTION = "insert";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		UserBU userBU = new UserBU();
		
		List<UserDTO> users = userBU.getUserList(UserDTO.class);
		
		request.setAttribute("users", users);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		
		dispatcher.forward(request, response);
		
//		String action = request.getParameter("action");
//		if(action == null) {
//			action = LIST_ACTION;
//		}
//		PrintWriter out = response.getWriter();
//
//		switch (action) {
//		case INSERT_ACTION:
//			insert(out);
//			break;
//
//		default:
//			list(out);
//			break;
//		}
//
//
//	    out.flush();
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		Integer id = null;
		if(request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		String username = request.getParameter("username");
		String name = request.getParameter("name");
				
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		
		try {
			Date birth_date = sdf.parse(request.getParameter("birth_date"));
			
			if(request.getParameter("update") == null) {
				UserBU userBU = new UserBU();
				
				if(userBU.saveUser(id, username, name, birth_date)) {
					response.getWriter().println("User saved");
				} else {
					response.getWriter().println("User not saved");
				}
			} else {
				
				int userId = Integer.parseInt(request.getParameter("update"));
				
				UserBU userBU = new UserBU();
				
				if(userBU.updateUser(userId, username, name, birth_date)) {
					response.getWriter().println("User updated");
				} else {
					response.getWriter().println("User not updated");
				}
			}
			
			
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void list(PrintWriter out){
		UserBU userBU = new UserBU();
		List<UserDTO> userList = userBU.getUserList(UserDTO.class);
		out.println("Empty list");
	}

	private void insert(PrintWriter out){
		UserBU userBU = new UserBU();
		out.println("Empty list");
	}

}
