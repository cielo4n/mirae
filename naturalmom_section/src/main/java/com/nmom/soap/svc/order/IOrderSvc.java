package com.nmom.soap.svc.order;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.order.OrderVo;

public interface IOrderSvc {

	//	1. 삽입, 삽입과 동시에 pk가져 와야 됨.
	public int addOrder(OrderVo order, String credit_nm);
	
	//	2. 운송장 번호 입력
	public int editTrackingNumOrder(int order_no, int tracking_num, String delivery_com_nm);
}
