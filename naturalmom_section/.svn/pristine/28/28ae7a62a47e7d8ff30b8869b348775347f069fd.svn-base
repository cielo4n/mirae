package com.nmom.soap.svc.order;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.dao.order.IVOrderManagerDao;
import com.nmom.soap.data.model.order.VOrderManagerVo;

public class VOrderManagerSvcImpl implements IVOrderManagerSvc {

	private IVOrderManagerDao vOrderManagerDao;
	
	@Override
	public List<VOrderManagerVo> getAllOrederByDate(boolean orderBy) {
		System.out.println("서비스 메소드 진입");
		List<VOrderManagerVo> list = 
				this.vOrderManagerDao.getAllOrederByDate(orderBy); 
		System.out.println("getAllOrederByDate");
		return (list != null && list.size() > 0 )? list : null;
	}

	@Override
	public List<VOrderManagerVo> getAllOrederByNo(boolean orderBy) {
		System.out.println("오더매니저 서비스");
		List<VOrderManagerVo> list = 
				this.vOrderManagerDao.getAllOrederByNo(orderBy); 
		System.out.println("getAllOrederByNo");
		return (list != null && list.size() > 0 )? list : null;
	}

	@Override
	public List<VOrderManagerVo> getAllOrederByName(boolean orderBy) {
		List<VOrderManagerVo> list = 
				this.vOrderManagerDao.getAllOrederByName(orderBy); 
		System.out.println("getAllOrederByName");
		return (list != null && list.size() > 0 )? list : null;
	}

	@Override
	public List<VOrderManagerVo> getAllOrederByProduct(boolean orderBy) {
		List<VOrderManagerVo> list = 
				this.vOrderManagerDao.getAllOrederByProduct(orderBy); 
		System.out.println("getAllOrederByProduct");
		return (list != null && list.size() > 0 )? list : null;
	}

	@Override
	public List<VOrderManagerVo> getAllOrederByNum(boolean orderBy) {
		List<VOrderManagerVo> list = 
				this.vOrderManagerDao.getAllOrederByNum(orderBy); 
		System.out.println("getAllOrederByNum");
		return (list != null && list.size() > 0 )? list : null;
	}

	@Override
	public List<VOrderManagerVo> getAllOrederByCharge(boolean orderBy) {
		List<VOrderManagerVo> list = 
				this.vOrderManagerDao.getAllOrederByCharge(orderBy);
		System.out.println("getAllOrederByCharge");
		return (list != null && list.size() > 0 )? list : null;
	}

	@Override
	public List<VOrderManagerVo> getAllOrederByProcess(boolean orderBy) {
		List<VOrderManagerVo> list = 
				this.vOrderManagerDao.getAllOrederByProcess(orderBy); 
		System.out.println("getAllOrederByProcess");
		return (list != null && list.size() > 0 )? list : null;
	}

	public void setVOrderManagerDao(IVOrderManagerDao vOrderManagerDao) {
		this.vOrderManagerDao = vOrderManagerDao;
	}

}
