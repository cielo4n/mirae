package com.nmom.soap.svc.product;

import java.util.List;

import com.nmom.soap.data.model.product.VProduct_DeletedVo;

public interface IVProduct_DeletedSvc 
{
	// order: false = 내림차순, true = 오름차순
	// 상품 번호로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_product_no(boolean order);
	
	// 상품 이름으로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_product_name(boolean order);
	
	// 상품 가격으로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_selling_price(boolean order);
	
	// 재고로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_stock(boolean order);
	
	// 총 판매량으로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_all_sells(boolean order);

	// 카테고리 이름으로 정렬하기
	List<VProduct_DeletedVo> getAllDeletedProduct_by_category_nm(boolean order);
}