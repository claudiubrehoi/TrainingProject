package com.synertrade.training.bu;

import java.util.List;

import com.synertrade.training.dao.ApplicationDAO;
import com.synertrade.training.vo.TrainingApplicationVO;

public class ApplicationBU {
	
	public List<TrainingApplicationVO> getApplications() {
		ApplicationDAO appDao = new ApplicationDAO();
		return appDao.getApplications();
	}
}
