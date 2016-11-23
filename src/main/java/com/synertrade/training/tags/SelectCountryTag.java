package com.synertrade.training.tags;

import java.util.List;

import com.synertrade.training.bu.CountryBU;
import com.synertrade.training.vo.TrainingCountryVO;

public class SelectCountryTag extends SelectTag{
	
	private int selectedId = -1;
	
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
		
		CountryBU countryBu = new CountryBU();
		
		List<TrainingCountryVO> countries = countryBu.getCountries();
		
		return drawHtml(countries, "country", selId, 0);
	}
	
	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}
	
}
