package com.nmom.soap.svc.order;

import java.util.List;

import com.nmom.soap.data.model.order.ProductOrderVo;


public interface IProductOrderSvc {
	
	//	1. 삽입
	public int addOrder(ProductOrderVo po);
	
	//	2. 처리상태 변경(하나)
	public int editOrder(int order_no, int process_cd);	
	
	//	2. 처리상태 변경(다수)
	public int editOrder(int[] order_no, int process_cd);	
	
	// 3. 처리상태 변경(일부)
	public int editPartOrder(int order_no, String product_name, int process_cd);
	
	// 4. 주문에 따른 상품및 갯수 가져오기
	public List<ProductOrderVo> getOrder(int order_no);
	
}
