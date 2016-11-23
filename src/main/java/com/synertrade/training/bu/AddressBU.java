package com.synertrade.training.bu;

import java.util.List;

import com.synertrade.training.dao.AddressDAO;
import com.synertrade.training.vo.TrainingAddressVO;

public class AddressBU {
	
	public List<TrainingAddressVO> getAddresses() {
		return getAddresses(-1);
	}
	
	public List<TrainingAddressVO> getAddresses(int streetId) {
		AddressDAO addrDao = new AddressDAO();
		return addrDao.getAddresses(streetId);
	}
}
