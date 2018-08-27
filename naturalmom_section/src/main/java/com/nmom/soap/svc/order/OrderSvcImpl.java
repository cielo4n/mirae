package com.nmom.soap.svc.order;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.dao.order.IOrderDao;
import com.nmom.soap.data.model.order.OrderVo;

public class OrderSvcImpl implements IOrderSvc {

	private IOrderDao orderDao;
	
	@Override	
	public int addOrder(OrderVo order, String credit_nm) {
		
		return this.orderDao.addOrder(order, credit_nm);
	}

	@Override
	public int editTrackingNumOrder(int order_no, int tracking_num, String delivery_com_nm) {

		return this.orderDao.editTrackingNumOrder(order_no, tracking_num, delivery_com_nm);
	}
	
	

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
}
