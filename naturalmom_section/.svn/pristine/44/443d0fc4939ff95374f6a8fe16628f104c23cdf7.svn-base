package com.nmom.soap.data.impl.cart;

import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nmom.soap.data.dao.cart.ICartDao;
import com.nmom.soap.data.model.cart.CartVo;

public class CartDaoOraImpl extends NamedParameterJdbcDaoSupport implements ICartDao{
	
	private final String SQL_DUPLICATION_CART = "SELECT COUNT(product_no) FROM tb_cart WHERE product_no=:product_no and mem_id=:mem_id";
	private final String SQL_INSERT_CART = "INSERT INTO tb_cart (product_no, mem_id, buy_num) values (:product_no, :mem_id, :buy_num)"; 
	private final String SQL_DELETE_CART = "DELETE FROM tb_cart WHERE product_no=:product_no AND mem_id=:mem_id";
	private final String SQL_UPDATE_CART = "UPDATE tb_cart SET buy_num=:buy_num WHERE product_no=:product_no AND mem_id=:mem_id";
	private final String SQL_SELECT_BUY_NUM = "SELECT buy_num FROM tb_cart WHERE product_no=:product_no and mem_id=:mem_id";

	public boolean duplicationCartProduct(int product_no, String mem_id) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("product_no", product_no, Types.INTEGER);
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		
		int r = npjtem.queryForInt(SQL_DUPLICATION_CART, ps);
		
		if(r == 0) return false;
		else return true;
	}

	public int addCartProduct(CartVo cart) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("product_no", cart.getProduct_no(), Types.INTEGER);
		ps.addValue("mem_id", cart.getMem_id(), Types.VARCHAR);
		ps.addValue("buy_num", cart.getBuy_num(), Types.INTEGER);
		
		return npjtem.update(SQL_INSERT_CART, ps);
	}

	public int addCartProduct(int product_no, String mem_id) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("product_no", product_no, Types.INTEGER);
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		ps.addValue("buy_num", 1, Types.INTEGER);
		
		return npjtem.update(SQL_INSERT_CART, ps);
	}

	public int removeCartProduct(CartVo cart) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();

		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("product_no", cart.getProduct_no(), Types.INTEGER);
		ps.addValue("mem_id", cart.getMem_id(), Types.VARCHAR);
		
		return npjtem.update(SQL_DELETE_CART, ps);
	}

	public int removeCartProduct(int product_no, String mem_id) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();

		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("product_no", product_no, Types.INTEGER);
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		
		return npjtem.update(SQL_DELETE_CART, ps);
	}

	public int editCartProduct(CartVo cart) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("product_no", cart.getProduct_no(), Types.INTEGER);
		ps.addValue("mem_id", cart.getMem_id(), Types.VARCHAR);
		ps.addValue("buy_num", cart.getBuy_num(), Types.INTEGER);
		
		return npjtem.update(SQL_UPDATE_CART, ps);
	}

	public int editCartProduct(int product_no, String mem_id, int buy_num) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("product_no", product_no, Types.INTEGER);
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		ps.addValue("buy_num", buy_num, Types.INTEGER);
		
		return npjtem.update(SQL_UPDATE_CART, ps);
	}

	@Override
	public int getBuyNum(int product_no, String mem_id) {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("product_no", product_no, Types.INTEGER);
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		
		return npjtem.queryForInt(SQL_SELECT_BUY_NUM, ps);
	}

}