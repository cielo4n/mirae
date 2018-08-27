package com.nmom.soap.svc.interest;

import java.util.List;

import com.nmom.soap.data.dao.interest.IVInterestProductDao;
import com.nmom.soap.data.model.interest.VInterestProductVo;

public class VInterestProductImpl implements IVInterestProductSvc {

	IVInterestProductDao vInterestProductDao;
	
	public void setVInterestProductDao(IVInterestProductDao vInterestProductDao) {
		this.vInterestProductDao = vInterestProductDao;
	}

	@Override
	public List<VInterestProductVo> getAllInterest() {
		return vInterestProductDao.getAllInterest();
	}

	@Override
	public List<VInterestProductVo> getInterestByMemId(String mem_id) {
		return vInterestProductDao.getInterestByMemId(mem_id);
	}
}