package com.nmom.soap.svc.member;

import com.nmom.soap.data.dao.member.IVOrdererDao;
import com.nmom.soap.data.impl.member.VOrdererDaoOraImpl;
import com.nmom.soap.data.model.member.VOrdererVo;

public class VOrdererSvcImpl implements IVOrdererSvc {

	private IVOrdererDao ordererDao;

	public void setOrdererDao(IVOrdererDao ordererDao) {
		this.ordererDao = ordererDao;
	}

	@Override
	public VOrdererVo getOrderer(String id) {
		System.out.println("오더러 서비스");
		System.out.println(ordererDao == null ? null : ordererDao);
		return this.ordererDao.getOrderer(id);
	}

}
