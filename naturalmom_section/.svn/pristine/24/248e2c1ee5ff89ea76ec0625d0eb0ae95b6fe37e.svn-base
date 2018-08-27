package com.nmom.soap.data.dao.product;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.product.VProduct_ManageVo;

public interface IVProduct_ManageDao 
{
	// order: false = 내림차순, true = 오름차순
	// 상품 번호로 정렬하기
	List<VProduct_ManageVo> getAllProduct_by_product_no(boolean order) throws DataAccessException;
	
	// 카테고리 이름으로 정렬하기
	List<VProduct_ManageVo> getAllProduct_by_category_nm(boolean order) throws DataAccessException;
	
	// 상품명으로 정렬하기
	List<VProduct_ManageVo> getAllProduct_by_product_name(boolean order) throws DataAccessException;
	
	// 판매 가격으로 정렬하기
	List<VProduct_ManageVo> getAllProduct_by_selling_price(boolean order) throws DataAccessException;
	
	// 재고로 정렬하기
	List<VProduct_ManageVo> getAllProduct_by_stock(boolean order) throws DataAccessException;
	
	// 진열 상태로 정렬하기
	List<VProduct_ManageVo> getAllProduct_by_display_state(boolean order) throws DataAccessException;
	
	// 판매 상태로 정렬하기
	List<VProduct_ManageVo> getAllProduct_by_sale_state(boolean order) throws DataAccessException;
	
	// 총 판매량으로 정렬하기
	List<VProduct_ManageVo> getAllProduct_by_all_sells(boolean order) throws DataAccessException;
}
