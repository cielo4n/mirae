package com.nmom.soap.data.dao.interest;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.interest.VInterestProductVo;

public interface IVInterestProductDao {
	List<VInterestProductVo> getAllInterest() throws DataAccessException;
	List<VInterestProductVo> getInterestByMemId(String mem_id) throws DataAccessException;
}