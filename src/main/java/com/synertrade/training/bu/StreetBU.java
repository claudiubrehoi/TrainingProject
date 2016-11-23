package com.synertrade.training.bu;

import java.util.List;

import com.synertrade.training.dao.StreetDAO;
import com.synertrade.training.vo.TrainingStreetVO;

public class StreetBU {
	
	public List<TrainingStreetVO> getStreets() {
		return getStreets(-1);
	}
	
	public List<TrainingStreetVO> getStreets(int cityId) {
		StreetDAO streetDao = new StreetDAO();
		return streetDao.getStreets(cityId);
	}
}
