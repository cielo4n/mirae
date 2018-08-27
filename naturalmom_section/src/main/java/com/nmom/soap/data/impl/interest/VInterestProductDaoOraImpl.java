package com.nmom.soap.data.impl.interest;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nmom.soap.data.dao.interest.IVInterestProductDao;
import com.nmom.soap.data.model.cart.VCartProductVo;
import com.nmom.soap.data.model.interest.VInterestProductVo;

public class VInterestProductDaoOraImpl extends NamedParameterJdbcDaoSupport implements IVInterestProductDao {

	private final String SELECT_ALL_INTEREST_PRODUCT = "SELECT product_no, product_name, selling_price, sale_state, represent_img, stock, mem_id FROM V_INTEREST_PRODUCT";
	private final String SELECT_INTEREST_PRODUCT_BY_MEM_ID = "SELECT product_no, product_name, selling_price, sale_state, represent_img, stock, mem_id FROM V_INTEREST_PRODUCT WHERE mem_id=:mem_id";
	
	public List<VInterestProductVo> getAllInterest() throws DataAccessException {
		return this.getJdbcTemplate().query(SELECT_ALL_INTEREST_PRODUCT, new BeanPropertyRowMapper<VInterestProductVo>(VInterestProductVo.class));
	}

	public List<VInterestProductVo> getInterestByMemId(String mem_id) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		return npjtem.query(SELECT_INTEREST_PRODUCT_BY_MEM_ID, ps, new BeanPropertyRowMapper<VInterestProductVo>(VInterestProductVo.class));
	}
}