package com.nmom.soap.svc.product;

import java.util.List;

import com.nmom.soap.data.model.product.ProductVo;

public interface IProductSvc 
{
	// 상품 하나 가져오기
	ProductVo getOneProduct(int product_no);
	
	// 상품 추가
	int addProduct(ProductVo product);
	
	// 진열 상태 변경
	int editDisplayState(int product_no, int state);
	
	// 판매 상태 변경
	int editSaleState(int product_no, int state);
	
	// 삭제, 복원
	int editDeletedState(int product_no, int state);
	
	// 상품 수정
	int editOneProduct(ProductVo product);
	
	// 상품 목록 페이지
	List<ProductVo> getAllProduct();
	
	// 카테고리에 따라 상품목록 가져옴
	List<ProductVo> getProductByCategoryCd(int category_cd);
	
	// 해당 상품의 재고 가져오기
	int getStockOfProduct(int product_no);
	
	// 해당 상품의 재고 빼기
	int subStockOfProduct(int amount, int product_no);

	// 해당 상품의 재고 더학
	int addStockOfProduct(int amount, int product_no);

	//검색상품 찾기
	List<ProductVo> searchProduct(String kw);

}
