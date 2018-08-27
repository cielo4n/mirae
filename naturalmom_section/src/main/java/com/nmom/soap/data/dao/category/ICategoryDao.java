package com.nmom.soap.data.dao.category;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.category.CategoryVo;

public interface ICategoryDao {
	
	//카테고리코드로 카테고리이름가져옴
	String getCategoryNameByCd(int category_cd) throws DataAccessException;

	// 모든 카테고리 정보 가져오기
	List<CategoryVo> getAllCategory();
}