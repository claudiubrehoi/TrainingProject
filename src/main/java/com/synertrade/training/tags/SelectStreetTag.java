package com.synertrade.training.tags;

import java.util.List;

import com.synertrade.training.bu.StreetBU;
import com.synertrade.training.vo.TrainingStreetVO;

public class SelectStreetTag extends SelectTag {
	
	StreetBU streetBu;
	
	private int selectedId = -1;
	
	private int selectedCityId;
	
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
		
		streetBu = new StreetBU();
		
		List<TrainingStreetVO> streets = streetBu.getStreets(selectedCityId);
		
		return drawHtml(streets, "street", selId, selectedCityId);
	}
	
	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}
	
	public void setSelectedCityId(int selectedCityId) {
		this.selectedCityId = selectedCityId;
	}
}
