package com.nmom.soap.data.impl.product;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nmom.soap.data.dao.product.IVProduct_DeletedDao;
import com.nmom.soap.data.model.product.VProduct_DeletedVo;

public class VProduct_DeletedDaoOraImpl extends JdbcDaoSupport implements IVProduct_DeletedDao 
{
	// 상품 번호 오름차순 정렬
	private final String GET_ALL_BY_PRODUCT_NO_ASC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY product_no";
	// 상품 번호 내림차순 정렬
	private final String GET_ALL_BY_PRODUCT_NO_DESC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY product_no desc";
	// 카테고리 이름 오름차순 정렬
	private final String GET_ALL_BY_CATEGORY_NM_ASC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY category_nm";
	// 카테고리 이름 오름차순 정렬
	private final String GET_ALL_BY_CATEGORY_NM_DESC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY category_nm desc";
	// 상품 이름 오름차순 정렬
	private final String GET_ALL_BY_PRODUCT_NAME_ASC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY product_name, product_no";
	// 상품 이름 내림차순 정렬
	private final String GET_ALL_BY_PRODUCT_NAME_DESC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY product_name desc, product_no";
	// 판매 가격 오름차순 정렬
	private final String GET_ALL_BY_SELLING_PRICE_ASC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY selling_price, product_no";
	// 판매 가격 내림차순 정렬
	private final String GET_ALL_BY_SELLING_PRICE_DESC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY selling_price desc, product_no";
	// 재고 오름차순 정렬
	private final String GET_ALL_BY_STOCK_ASC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY stock, product_no";
	// 재고 내림차순 정렬
	private final String GET_ALL_BY_STOCK_DESC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY stock desc, product_no";
	// 총 판매량 오름차순 정렬
	private final String GET_ALL_BY_ALL_SELLS_ASC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY all_sells, product_no";
	// 총 판매량 내림차순 정렬
	private final String GET_ALL_BY_ALL_SELLS_DESC = "SELECT * FROM V_PRODUCT_DELETED ORDER BY all_sells desc, product_no";
	
	public List<VProduct_DeletedVo> getAllDeletedProduct_by_product_no(boolean order) throws DataAccessException 
	{
		if(order)
			return getJdbcTemplate().query(GET_ALL_BY_PRODUCT_NO_ASC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
		else
			return getJdbcTemplate().query(GET_ALL_BY_PRODUCT_NO_DESC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
	}

	public List<VProduct_DeletedVo> getAllDeletedProduct_by_product_name(boolean order) throws DataAccessException 
	{
		if(order)
			return getJdbcTemplate().query(GET_ALL_BY_PRODUCT_NAME_ASC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
		else
			return getJdbcTemplate().query(GET_ALL_BY_PRODUCT_NAME_DESC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
	}

	public List<VProduct_DeletedVo> getAllDeletedProduct_by_selling_price(boolean order) throws DataAccessException 
	{
		if(order)
			return getJdbcTemplate().query(GET_ALL_BY_SELLING_PRICE_ASC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
		else
			return getJdbcTemplate().query(GET_ALL_BY_SELLING_PRICE_DESC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
	}

	public List<VProduct_DeletedVo> getAllDeletedProduct_by_stock(boolean order) throws DataAccessException 
	{
		if(order)
			return getJdbcTemplate().query(GET_ALL_BY_STOCK_ASC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
		else
			return getJdbcTemplate().query(GET_ALL_BY_STOCK_DESC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
	}

	public List<VProduct_DeletedVo> getAllDeletedProduct_by_all_sells(boolean order) throws DataAccessException 
	{
		if(order)
			return getJdbcTemplate().query(GET_ALL_BY_ALL_SELLS_ASC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
		else
			return getJdbcTemplate().query(GET_ALL_BY_ALL_SELLS_DESC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
	}

	@Override
	public List<VProduct_DeletedVo> getAllDeletedProduct_by_category_nm(boolean order) throws DataAccessException 
	{
		if(order)
			return getJdbcTemplate().query(GET_ALL_BY_CATEGORY_NM_ASC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
		else
			return getJdbcTemplate().query(GET_ALL_BY_CATEGORY_NM_DESC, 
					new BeanPropertyRowMapper<VProduct_DeletedVo>(VProduct_DeletedVo.class));
	}
}
