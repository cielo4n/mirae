package com.nmom.soap.svc.interest;

import com.nmom.soap.data.model.interest.InterestVo;

public interface IInterestSvc {

	//관심상품 상품중복 확인 (true중복 false중복아님)
	boolean duplicationInterestProduct(int product_no, String mem_id);
	
	//관심상품 상품추가
	int addInterestProduct(InterestVo interest);
	int addInterestProduct(int product_no, String mem_id);
	
	//관심상품 상품삭제
	int removeInterestProduct(InterestVo interest);
	int removeInterestProduct(int product_no, String mem_id);
}
