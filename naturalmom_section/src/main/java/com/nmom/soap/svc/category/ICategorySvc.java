package com.nmom.soap.svc.category;

import java.util.List;

import com.nmom.soap.data.model.category.CategoryVo;

public interface ICategorySvc {

	String getCategoryNameByCd(int category_cd);

	//********************************************************************************************************************/
	
	// 모든 카테고리 가져오기
	List<CategoryVo> getAllCategory();
}
