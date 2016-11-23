package com.synertrade.training.tags;

import java.util.List;

import com.synertrade.training.bu.ApplicationBU;
import com.synertrade.training.vo.TrainingApplicationVO;

public class SelectApplicationTag extends SelectTag{
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
		
		ApplicationBU appBu = new ApplicationBU();
		
		List<TrainingApplicationVO> apps = appBu.getApplications();
		
		return drawHtml(apps, "application", selId, 0);
	}
	
	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}
}
