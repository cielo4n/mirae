package com.nmom.soap.data.dao.cart;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.cart.VCartProductVo;

public interface IVCartProductDao {
	List<VCartProductVo> getAllCart() throws DataAccessException;
	List<VCartProductVo> getCartByMemId(String mem_id) throws DataAccessException;
	VCartProductVo getOneCart(String mem_id, int product_no) throws DataAccessException;	
}