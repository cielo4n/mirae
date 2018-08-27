package com.nmom.soap.data.impl.order;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.nmom.soap.data.dao.order.IVOrderListDao;
import com.nmom.soap.data.model.order.VOrderListVo;

public class VOrderListDaoOraImpl extends NamedParameterJdbcDaoSupport implements IVOrderListDao {
	
	final String GET_ALL_ORDER = 
			"SELECT order_no, order_date, "
			+ "LISTAGG(represent_img, ',') WITHIN GROUP (ORDER BY represent_img) "
			+ "as represent_img, "
			+ "LISTAGG(product_name, ',')WITHIN GROUP (ORDER BY product_name) "
			+ "as product_name, SUM(buy_num) AS buy_num, charge, process_nm, mem_id "
			+ "FROM v_order_list WHERE mem_id = :mem_id "
			+ "GROUP BY order_no, order_date, charge, process_nm, mem_id";
	
	final String GET_ONE_ORDER = 
			"SELECT order_no, order_date, "
			+ "LISTAGG(represent_img, ',') WITHIN GROUP (ORDER BY represent_img) "
			+ "as represent_img, "
			+ "LISTAGG(product_name, ',')WITHIN GROUP (ORDER BY product_name) "
			+ "as product_name, SUM(buy_num) AS buy_num, charge, process_nm, mem_id "
			+ "FROM v_order_list "
			+ "WHERE order_no = :order_no "
			+ "GROUP BY order_no, order_date, charge, process_nm, mem_id";

	final String GET_ALL_COUNT = "SELECT COUNT(order_no) FROM v_order_list WHERE mem_id = :mem_id";
	
	public List<VOrderListVo> getAllOreder(String mem_id) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		List<VOrderListVo> list = getNamedParameterJdbcTemplate().query(
				GET_ALL_ORDER, 
				ps,
				BeanPropertyRowMapper.newInstance(VOrderListVo.class));
		if (list != null)
			return list;
		return null;
	}
	
	@Override
	public VOrderListVo getOneOrder(int order_no) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("order_no", new Integer(order_no), Types.INTEGER);
		List<VOrderListVo> list = getNamedParameterJdbcTemplate().query(
				GET_ONE_ORDER, 
				ps,
				BeanPropertyRowMapper.newInstance(VOrderListVo.class));
		if (list != null && list.size() == 1)
			return list.get(0);
		return null;
	}

	public int getAllCount(String mem_id) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		return getNamedParameterJdbcTemplate().queryForInt(GET_ALL_COUNT, ps);
	}

	
	

}
