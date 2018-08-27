package com.nmom.soap.data.dao.order;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.order.VOrderManagerVo;


public interface IVOrderManagerDao {

	public List<VOrderManagerVo> getAllOrederByDate(boolean orderBy)  throws DataAccessException;
	
	public List<VOrderManagerVo> getAllOrederByNo(boolean orderBy)  throws DataAccessException;
	
	public List<VOrderManagerVo> getAllOrederByName(boolean orderBy)  throws DataAccessException;
	
	public List<VOrderManagerVo> getAllOrederByProduct(boolean orderBy)  throws DataAccessException;
	
	public List<VOrderManagerVo> getAllOrederByNum(boolean orderBy)  throws DataAccessException;
	
	public List<VOrderManagerVo> getAllOrederByCharge(boolean orderBy)  throws DataAccessException;
	
	public List<VOrderManagerVo> getAllOrederByProcess(boolean orderBy)  throws DataAccessException;
	
	
}
