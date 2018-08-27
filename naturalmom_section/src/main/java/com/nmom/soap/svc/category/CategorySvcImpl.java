package com.nmom.soap.svc.category;

import java.util.List;

import com.nmom.soap.data.dao.category.ICategoryDao;
import com.nmom.soap.data.model.category.CategoryVo;

public class CategorySvcImpl implements ICategorySvc {
	ICategoryDao categoryDao;
	
	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public String getCategoryNameByCd(int category_cd) {
		return categoryDao.getCategoryNameByCd(category_cd);
	}
	
	//********************************************************************************************************************/

	@Override
	public List<CategoryVo> getAllCategory() 
	{
		return categoryDao.getAllCategory();
	}

}
