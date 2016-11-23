package com.synertrade.training.tags;

import java.util.List;

import com.synertrade.training.bu.AddressBU;
import com.synertrade.training.vo.TrainingAddressVO;

public class SelectAddressTag extends SelectTag{
	
	private int selectedId = -1;
	
	private int selectedStreetId;
	
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
		
		AddressBU addrBu = new AddressBU();
		
		List<TrainingAddressVO> addresses = addrBu.getAddresses(selectedStreetId);
		
		return drawHtml(addresses, "address", selId, selectedStreetId);
	}
	
	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}
	
	public void setSelectedStreetId(int selectedStreetId) {
		this.selectedStreetId = selectedStreetId;
	}
}
