package com.nmom.soap.data.dao.product;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.product.VProduct_DeletedVo;

public interface IVProduct_DeletedDao 
{
	// order: false = 내림차순, true = 오름차순
	// 상품 번호로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_product_no(boolean order) throws DataAccessException;
	
	// 상품 이름으로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_product_name(boolean order) throws DataAccessException;
	
	// 상품 가격으로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_selling_price(boolean order) throws DataAccessException;
	
	// 재고로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_stock(boolean order) throws DataAccessException;
	
	// 총 판매량으로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_all_sells(boolean order) throws DataAccessException;

	// 카테고리 이름으로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_category_nm(boolean order) throws DataAccessException;
}
