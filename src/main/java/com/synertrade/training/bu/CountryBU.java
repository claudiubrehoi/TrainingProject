package com.synertrade.training.bu;

import java.util.List;

import com.synertrade.training.dao.CountryDAO;
import com.synertrade.training.vo.TrainingCountryVO;

public class CountryBU {
	
	public List<TrainingCountryVO> getCountries() {
		CountryDAO countryDao = new CountryDAO();
		return countryDao.getCountries();
	}
}	
