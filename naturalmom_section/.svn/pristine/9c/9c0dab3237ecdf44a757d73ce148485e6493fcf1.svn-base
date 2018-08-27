package com.nmom.soap.svc.cart;

import java.util.List;

import com.nmom.soap.data.dao.cart.IVCartProductDao;
import com.nmom.soap.data.model.cart.VCartProductVo;

public class VCartProductSvcImpl implements IVCartProductSvc {
	
	IVCartProductDao vCartProductDao;
	
	public void setVCartProductDao(IVCartProductDao vCartProductDao) {
		this.vCartProductDao = vCartProductDao;
	}

	@Override
	public List<VCartProductVo> getAllCart() {
		return vCartProductDao.getAllCart();
	}

	@Override
	public List<VCartProductVo> getCartByMemId(String mem_id) {
		return vCartProductDao.getCartByMemId(mem_id);
	}

	@Override
	public VCartProductVo getOneCart(String mem_id, int product_no) {
		return vCartProductDao.getOneCart(mem_id, product_no);
	}

}
