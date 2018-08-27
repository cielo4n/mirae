package com.nmom.soap.data.dao.member;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.member.VOrdererVo;

public interface IVOrdererDao {
	public VOrdererVo getOrderer(String id) throws DataAccessException;
}
