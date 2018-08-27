package com.nmom.soap.svc.cart;

import com.nmom.soap.data.dao.cart.ICartDao;
import com.nmom.soap.data.model.cart.CartVo;

public class CartSvcImpl implements ICartSvc {

	ICartDao cartDao;
	
	public void setCartDao(ICartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public boolean duplicationCartProduct(int product_no, String mem_id) {
		return cartDao.duplicationCartProduct(product_no, mem_id);
	}

	@Override
	public int addCartProduct(CartVo cart) {
		return cartDao.addCartProduct(cart);
	}

	@Override
	public int addCartProduct(int product_no, String mem_id) {
		return cartDao.addCartProduct(product_no, mem_id);
	}

	@Override
	public int removeCartProduct(CartVo cart) {
		return cartDao.removeCartProduct(cart);
	}

	@Override
	public int removeCartProduct(int product_no, String mem_id) {
		return cartDao.removeCartProduct(product_no, mem_id);
	}

	@Override
	public int editCartProduct(CartVo cart) {
		return cartDao.editCartProduct(cart);
	}

	@Override
	public int editCartProduct(int product_no, String mem_id, int buy_num) {
		return cartDao.editCartProduct(product_no, mem_id, buy_num);
	}

	@Override
	public int getBuyNum(int product_no, String mem_id) {
		return cartDao.getBuyNum(product_no, mem_id);
	}

}
