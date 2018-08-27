package com.nmom.soap.data.dao.cart;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.cart.CartVo;

public interface ICartDao {

	//장바구니 상품중복 확인 (false하나 true중복)
	boolean duplicationCartProduct(int product_no, String mem_id) throws DataAccessException;
	
	//장바구니 상품추가
	int addCartProduct(CartVo cart) throws DataAccessException;
	int addCartProduct(int product_no, String mem_id) throws DataAccessException;
	
	//장바구니 상품삭제
	int removeCartProduct(CartVo cart) throws DataAccessException;
	int removeCartProduct(int product_no, String mem_id) throws DataAccessException;
	
	//장바구니 상품(구매개수) 수정
	int editCartProduct(CartVo cart) throws DataAccessException;
	int editCartProduct(int product_no, String mem_id, int buy_num) throws DataAccessException;
	
	//장바구니 상품하나의 개수 확인
	int getBuyNum(int product_no, String mem_id) throws DataAccessException;
	
}