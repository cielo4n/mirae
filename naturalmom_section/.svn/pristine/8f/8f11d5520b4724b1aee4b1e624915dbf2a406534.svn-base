package com.nmom.soap.svc.cart;

import com.nmom.soap.data.model.cart.CartVo;

public interface ICartSvc {

	//장바구니 상품중복 확인 (false하나 true중복)
	boolean duplicationCartProduct(int product_no, String mem_id);
	
	//장바구니 상품추가
	int addCartProduct(CartVo cart);
	int addCartProduct(int product_no, String mem_id);
	
	//장바구니 상품삭제
	int removeCartProduct(CartVo cart);
	int removeCartProduct(int product_no, String mem_id);
	
	//장바구니 상품(구매개수) 수정
	int editCartProduct(CartVo cart);
	int editCartProduct(int product_no, String mem_id, int buy_num);
	
	//장바구니 상품하나의 개수 확인
	int getBuyNum(int product_no, String mem_id);
}
