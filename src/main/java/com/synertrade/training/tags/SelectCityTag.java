package com.synertrade.training.tags;

import java.util.List;

import com.synertrade.training.bu.CityBU;
import com.synertrade.training.vo.TrainingCityVO;

public class SelectCityTag extends SelectTag {
	
	private int selectedId = -1;
	
	private int selectedCountryId;
	
	@Override
	public String getTagHtml() {
		return getTagHtml(-1);
	}
	
	public String getTagHtml(int id) {
		
		int selId;
		
		if(selectedId == -1) {
			selId = id;
		} else {
			selId = selectedId;
		}
		
		CityBU cityBu = new CityBU();
		
		List<TrainingCityVO> cities = cityBu.getCities(selectedCountryId);
		
		return drawHtml(cities, "city", selId, selectedCountryId);
	}
	
	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}
	
	public void setSelectedCountryId(int selectedCountryId) {
		this.selectedCountryId = selectedCountryId;
	}
}
