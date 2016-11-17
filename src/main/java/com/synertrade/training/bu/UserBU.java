package com.synertrade.training.bu;

import java.util.Date;
import java.util.List;

import com.synertrade.training.dao.UserDAO;
import com.synertrade.training.dto.UserDTO;
import com.synertrade.training.dto.UserTestDTO;
import com.synertrade.training.vo.UserVO;

public class UserBU {

	public List<UserDTO> getUserList() {
		UserDAO userDAO = new UserDAO();
		return userDAO.getUserList();
	}
	
	public boolean saveUser(int id, String username, String name) {
		
		UserDAO userDAO = new UserDAO();
		
		UserVO newUser = new UserVO();
		
		newUser.setId(id);
		newUser.setUsername(username);
		newUser.setName(name);
		
		return userDAO.saveUser(newUser);
		
	}
	
	public boolean saveUser(int id, String username, String name, Date birth_date) {
		
		UserDAO userDAO = new UserDAO();
		
		UserVO newUser = new UserVO();
		
		newUser.setId(id);
		newUser.setUsername(username);
		newUser.setName(name);
		newUser.setBirth_date(new java.sql.Date(birth_date.getTime()));
		
		return userDAO.saveUser(newUser);
		
	}

	public boolean updateUser(int userId, String username, String name, Date birth_date) {
		
		UserDAO userDAO = new UserDAO();
		
		UserVO user = userDAO.getUser(userId);
		
		user.setUsername(username);
		
		user.setName(name);
		
		user.setBirth_date(new java.sql.Date(birth_date.getTime()));
		
		if(userDAO.updateUser(user)) {
			return true;
		} else {
			return false;
		}
		
	}

}
