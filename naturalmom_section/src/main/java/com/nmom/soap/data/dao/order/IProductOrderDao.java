package com.nmom.soap.data.dao.order;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.order.ProductOrderVo;




public interface IProductOrderDao {
	
	//	1. 삽입
	public int addOrder(ProductOrderVo po) throws DataAccessException;
	
	//	2. 처리상태 변경(하나)
	public int editOrder(int order_no, int process_cd) throws DataAccessException;	
	
	//	2. 처리상태 변경(다수)
	public int editOrder(int[] order_no, int process_cd) throws DataAccessException;	
	
	// 3. 처리상태 변경(일부)
	public int editPartOrder(int order_no, String product_name, int process_cd) throws DataAccessException;
	
	// 4. 주문 번호에 따라 목록 가져오기
	public List<ProductOrderVo> getOneOrder(int order_no) throws DataAccessException;
	
}
