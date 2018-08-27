package com.nmom.soap.svc.interest;

import com.nmom.soap.data.dao.interest.IInterestDao;
import com.nmom.soap.data.model.interest.InterestVo;

public class InterestSvcImpl implements IInterestSvc {
	
	IInterestDao interestDao;
	
	public void setInterestDao(IInterestDao interestDao) {
		this.interestDao = interestDao;
	}

	@Override
	public boolean duplicationInterestProduct(int product_no, String mem_id) {
		return interestDao.duplicationInterestProduct(product_no, mem_id);
	}

	@Override
	public int addInterestProduct(InterestVo interest) {
		return interestDao.addInterestProduct(interest);
	}

	@Override
	public int addInterestProduct(int product_no, String mem_id) {
		return interestDao.addInterestProduct(product_no, mem_id);
	}

	@Override
	public int removeInterestProduct(InterestVo interest) {
		return interestDao.removeInterestProduct(interest);
	}

	@Override
	public int removeInterestProduct(int product_no, String mem_id) {
		return interestDao.removeInterestProduct(product_no, mem_id);
	}

}
