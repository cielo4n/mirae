package com.nmom.soap.data.dao.interest;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.interest.InterestVo;

public interface IInterestDao {

	//관심상품 상품중복 확인 (true중복 false중복아님)
	boolean duplicationInterestProduct(int product_no, String mem_id) throws DataAccessException;
	
	//관심상품 상품추가
	int addInterestProduct(InterestVo interest) throws DataAccessException;
	int addInterestProduct(int product_no, String mem_id) throws DataAccessException;
	
	//관심상품 상품삭제
	int removeInterestProduct(InterestVo interest) throws DataAccessException;
	int removeInterestProduct(int product_no, String mem_id) throws DataAccessException;
}