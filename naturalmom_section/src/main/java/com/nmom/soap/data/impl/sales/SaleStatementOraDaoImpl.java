package com.nmom.soap.data.impl.sales;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.nmom.soap.data.dao.sales.ISaleStatementDao;
import com.nmom.soap.data.model.sales.SaleStatementVo;

public class SaleStatementOraDaoImpl extends NamedParameterJdbcDaoSupport implements ISaleStatementDao {
	
	final String SELECT_TODAY_SALESTATEMENT = 
			"SELECT NVL((SELECT COUNT(o.order_no) FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0) AS order_no, "
			+ "NVL((SELECT COUNT(DISTINCT po.product_no) FROM tb_product_n_order po, tb_order o "
			+ "WHERE po.order_no = o.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0) "
			+ "AS product_no, (NVL((SELECT SUM(o.charge) FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0) - NVL((SELECT COUNT(o.order_no) "
			+ "FROM tb_order o, tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 21 AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0)*3000 ) "
			+ "AS sale_sum,NVL((SELECT COUNT(o.order_no) FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0)*3000 AS delivery_sum, "
			+ "NVL((SELECT SUM(o.charge) FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0) AS sale_total_sum, "
			+ "NVL((SELECT SUM(o.charge) "
			+ "FROM tb_order o, tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 32 AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0) "
			+ "AS refund_sum, (NVL((SELECT SUM(o.charge) FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 32 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0) - NVL((SELECT COUNT(o.charge) "
			+ "FROM tb_order o, tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 32 AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0)*3000) "
			+ "AS refund_total_sum, (NVL((SELECT SUM(o.charge) FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0) - NVL((SELECT COUNT(o.order_no) "
			+ "FROM tb_order o, tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 21 AND to_char(o.order_date, 'YYYY-MM-DD') = :today),0)*3000) "
			+ "AS net_sale FROM DUAL";
	
	final String SELECT_PERIOD_SALESTATEMENT = 
			"SELECT NVL((SELECT COUNT(o.order_no) FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') >= :start "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') <= :end),0) "
			+ "AS order_no, NVL((SELECT COUNT(DISTINCT po.product_no) "
			+ "FROM tb_product_n_order po, tb_order o "
			+ "WHERE po.order_no = o.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') >= :start "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') <= :end),0) "
			+ "AS product_no, (NVL((SELECT SUM(o.charge) "
			+ "FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') >= :start "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') <= :end),0) "
			+ "- NVL((SELECT COUNT(o.order_no) FROM tb_order o, "
			+ "tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 21 AND to_char(o.order_date, 'YYYY-MM-DD') "
			+ ">= :start AND to_char(o.order_date, 'YYYY-MM-DD') "
			+ "<= :end),0)*3000 ) AS sale_sum, "
			+ "NVL((SELECT COUNT(o.order_no) FROM tb_order o, "
			+ "tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 21 AND to_char(o.order_date, 'YYYY-MM-DD') "
			+ ">= :start AND to_char(o.order_date, 'YYYY-MM-DD') "
			+ "<= :end),0)*3000 AS delivery_sum, "
			+ "NVL((SELECT SUM(o.charge) FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') >= :start "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') <= :end),0) "
			+ "AS sale_total_sum,NVL((SELECT SUM(o.charge) "
			+ "FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 32 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') >= :start "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') <= :end),0) "
			+ "AS refund_sum,(NVL((SELECT SUM(o.charge) "
			+ "FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 32 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') >= :start "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') <= :end),0) "
			+ "- NVL((SELECT COUNT(o.charge) FROM tb_order o, "
			+ "tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 32 AND to_char(o.order_date, 'YYYY-MM-DD') "
			+ ">= :start AND to_char(o.order_date, 'YYYY-MM-DD') "
			+ "<= :end),0)*3000) AS refund_total_sum, "
			+ "(NVL((SELECT SUM(o.charge) FROM tb_order o, "
			+ "tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 21 AND to_char(o.order_date, 'YYYY-MM-DD') "
			+ ">= :start AND to_char(o.order_date, 'YYYY-MM-DD') "
			+ "<= :end),0) - NVL((SELECT COUNT(o.order_no) "
			+ "FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21 "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') >= :start "
			+ "AND to_char(o.order_date, 'YYYY-MM-DD') <= :end),0)*3000) AS net_sale FROM DUAL";
	
	final String SELECT_ALL_SALESTATEMENT = 
			"SELECT NVL((SELECT COUNT(o.order_no) FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21),0) AS order_no, "
			+ "NVL((SELECT COUNT(DISTINCT p.product_no) FROM tb_product p, tb_product_n_order po "
			+ "WHERE p.product_no = po.product_no AND po.process_cd = 21),0) AS product_no, "
			+ "(NVL((SELECT SUM(o.charge) FROM tb_order o, tb_product_n_order po "
			+ "WHERE o.order_no = po.order_no AND po.process_cd = 21 ),0) - NVL((SELECT COUNT(o.order_no) "
			+ "FROM tb_order o, tb_product_n_order po WHERE o.order_no = po.order_no AND "
			+ "po.process_cd = 21),0)*3000) AS sale_sum, NVL((SELECT COUNT(o.order_no) FROM "
			+ "tb_order o, tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 21),0)*3000 AS delivery_sum, NVL((SELECT SUM(o.charge) "
			+ "FROM tb_order o, tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 21),0) AS sale_total_sum, NVL((SELECT SUM(o.charge) "
			+ "FROM tb_order o, tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 32),0) AS refund_sum, (NVL((SELECT SUM(o.charge) "
			+ "FROM tb_order o, tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 32),0) - NVL((SELECT COUNT(o.charge) FROM tb_order o, "
			+ "tb_product_n_order po WHERE o.order_no = po.order_no AND "
			+ "po.process_cd = 32),0)*3000) AS refund_total_sum, (NVL((SELECT SUM(o.charge) "
			+ "FROM tb_order o, tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 21),0) - NVL((SELECT COUNT(o.order_no) FROM tb_order o, "
			+ "tb_product_n_order po WHERE o.order_no = po.order_no "
			+ "AND po.process_cd = 21),0)*3000) AS net_sale FROM DUAL";
			
	public SaleStatementVo getSaleStatement() throws DataAccessException {
		// TODO Auto-generated method stub
		List<SaleStatementVo> list = getJdbcTemplate().query(SELECT_ALL_SALESTATEMENT, 
				BeanPropertyRowMapper.newInstance(SaleStatementVo.class));
		if( list != null && list.get(0) != null ) return list.get(0);
		return null;
	}

	
	public SaleStatementVo getSaleStatement(String today) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("today", today, Types.VARCHAR);
		List<SaleStatementVo> list = getNamedParameterJdbcTemplate().query(SELECT_TODAY_SALESTATEMENT, 
				ps, BeanPropertyRowMapper.newInstance(SaleStatementVo.class));
		if( list != null && list.get(0) != null ) return list.get(0);
		return null;
	}

	
	public SaleStatementVo getSaleStatement(String start, String end) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("start", start);
		ps.addValue("end", end);
		List<SaleStatementVo> list = getNamedParameterJdbcTemplate().query(SELECT_PERIOD_SALESTATEMENT, 
				ps, BeanPropertyRowMapper.newInstance(SaleStatementVo.class));
		if( list != null && list.get(0) != null ) return list.get(0);
		return null;
	}

}
