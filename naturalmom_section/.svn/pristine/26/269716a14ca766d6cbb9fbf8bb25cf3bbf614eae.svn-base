package com.nmom.soap.svc.product;

import java.util.List;

import com.nmom.soap.data.dao.product.IVProduct_DeletedDao;
import com.nmom.soap.data.model.product.VProduct_DeletedVo;

public class VProduct_DeletedSvcImpl implements IVProduct_DeletedSvc 
{
	IVProduct_DeletedDao product_deletedDao;
	
	public void setProduct_deletedDao(IVProduct_DeletedDao product_deletedDao) 
	{
		this.product_deletedDao = product_deletedDao;
	}

	@Override
	public List<VProduct_DeletedVo> getAllDeletedProduct_by_product_no(boolean order) 
	{
		return product_deletedDao.getAllDeletedProduct_by_product_no(order);
	}

	@Override
	public List<VProduct_DeletedVo> getAllDeletedProduct_by_product_name(boolean order) 
	{
		return product_deletedDao.getAllDeletedProduct_by_product_name(order);
	}

	@Override
	public List<VProduct_DeletedVo> getAllDeletedProduct_by_selling_price(boolean order) 
	{
		return product_deletedDao.getAllDeletedProduct_by_selling_price(order);
	}

	@Override
	public List<VProduct_DeletedVo> getAllDeletedProduct_by_stock(boolean order) 
	{
		return product_deletedDao.getAllDeletedProduct_by_stock(order);
	}

	@Override
	public List<VProduct_DeletedVo> getAllDeletedProduct_by_all_sells(boolean order) 
	{
		return product_deletedDao.getAllDeletedProduct_by_all_sells(order);
	}

	@Override
	public List<VProduct_DeletedVo> getAllDeletedProduct_by_category_nm(boolean order)
	{
		return product_deletedDao.getAllDeletedProduct_by_category_nm(order);
	}

}
