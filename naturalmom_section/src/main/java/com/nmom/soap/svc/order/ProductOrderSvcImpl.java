package com.nmom.soap.svc.order;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.dao.order.IProductOrderDao;
import com.nmom.soap.data.dao.product.IProductDao;
import com.nmom.soap.data.model.order.ProductOrderVo;

public class ProductOrderSvcImpl implements IProductOrderSvc {

	private IProductOrderDao productOrderDao;
	
	@Override
	public int addOrder(ProductOrderVo po) {
		return this.productOrderDao.addOrder(po);
	}

	@Override
	public int editOrder(int order_no, int process_cd) {
		return this.productOrderDao.editOrder(order_no, process_cd);
	}

	@Override
	public int editOrder(int[] order_no, int process_cd) {
		return this.productOrderDao.editOrder(order_no, process_cd);
	}

	@Override
	public int editPartOrder(int order_no, String product_name, int process_cd) {
		return this.productOrderDao.editPartOrder(order_no, product_name, process_cd);
	}


	@Override
	public List<ProductOrderVo> getOrder(int order_no) {
		return this.productOrderDao.getOneOrder(order_no);
	}
	
	public void setProductOrderDao(IProductOrderDao productOrderDao) {
		this.productOrderDao = productOrderDao;
	}


}
