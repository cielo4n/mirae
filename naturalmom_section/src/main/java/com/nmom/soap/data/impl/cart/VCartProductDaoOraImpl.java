package com.nmom.soap.data.impl.cart;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nmom.soap.data.dao.cart.IVCartProductDao;
import com.nmom.soap.data.model.cart.VCartProductVo;

public class VCartProductDaoOraImpl extends NamedParameterJdbcDaoSupport implements IVCartProductDao{

	private final String SELECT_ALL_CART_PRODUCT = "SELECT product_no, product_name, selling_price, sale_state, represent_img, buy_num, stock, mem_id FROM V_CART_PRODUCT";
	private final String SELECT_CART_PRODUCT_BY_MEM_ID = "SELECT product_no, product_name, selling_price, sale_state, represent_img, buy_num, stock, mem_id FROM V_CART_PRODUCT WHERE mem_id=:mem_id";
	private final String SELECT_ONE_CART_PRODUCT = "SELECT product_no, product_name, selling_price, sale_state, represent_img, stock, buy_num, mem_id FROM V_CART_PRODUCT WHERE mem_id=:mem_id AND product_no=:product_no";
	
	public List<VCartProductVo> getAllCart() throws DataAccessException {
		return this.getJdbcTemplate().query(SELECT_ALL_CART_PRODUCT, new BeanPropertyRowMapper<VCartProductVo>(VCartProductVo.class));
	}

	public List<VCartProductVo> getCartByMemId(String mem_id) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		return npjtem.query(SELECT_CART_PRODUCT_BY_MEM_ID, ps, new BeanPropertyRowMapper<VCartProductVo>(VCartProductVo.class));
	}

	@Override
	public VCartProductVo getOneCart(String mem_id, int product_no) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		ps.addValue("product_no", product_no, Types.INTEGER);
		List<VCartProductVo> list = npjtem.query(SELECT_ONE_CART_PRODUCT, ps, new BeanPropertyRowMapper<VCartProductVo>(VCartProductVo.class));
		return (list != null && list.size() == 1) ? list.get(0) : null;
	}
}