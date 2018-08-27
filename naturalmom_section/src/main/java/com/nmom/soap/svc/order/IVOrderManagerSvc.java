package com.nmom.soap.svc.order;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.order.VOrderManagerVo;


public interface IVOrderManagerSvc {

	// 관리자용 주문조회(내림/오름차순)
	public List<VOrderManagerVo> getAllOrederByDate(boolean orderBy);
	
	public List<VOrderManagerVo> getAllOrederByNo(boolean orderBy);
	
	public List<VOrderManagerVo> getAllOrederByName(boolean orderBy);
	
	public List<VOrderManagerVo> getAllOrederByProduct(boolean orderBy);
	
	public List<VOrderManagerVo> getAllOrederByNum(boolean orderBy);
	
	public List<VOrderManagerVo> getAllOrederByCharge(boolean orderBy);
	
	public List<VOrderManagerVo> getAllOrederByProcess(boolean orderBy);
	
	
}
