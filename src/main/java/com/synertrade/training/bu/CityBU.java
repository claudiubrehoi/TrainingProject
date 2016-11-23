package com.synertrade.training.bu;

import java.util.List;

import com.synertrade.training.dao.CityDAO;
import com.synertrade.training.vo.TrainingCityVO;

public class CityBU {
	
	public List<TrainingCityVO> getCities() {
		return getCities(-1);
	}
	
	public List<TrainingCityVO> getCities(int countryId) {
		CityDAO cityDao = new CityDAO();
		return cityDao.getCities(countryId);
	}
}
