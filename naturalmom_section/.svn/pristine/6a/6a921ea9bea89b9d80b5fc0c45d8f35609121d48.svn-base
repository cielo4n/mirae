package com.nmom.soap.data.impl.order;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nmom.soap.data.dao.order.IVOrderManagerDao;
import com.nmom.soap.data.model.order.VOrderManagerVo;

public class VOrderManagerDaoOraImpl extends JdbcDaoSupport implements IVOrderManagerDao {

	
	final String GET_ALL_ORDER_MANAGER = 
			"SELECT order_date, order_no, mem_name, "
			+ "LISTAGG(product_name, ',')WITHIN GROUP (ORDER BY product_name)"
			+ " as product_name, SUM(buy_num) as buy_num, charge, delivery_msg,"
			+ " tracking_num, process_nm FROM v_order_manager "
			+ "GROUP BY order_date, order_no, mem_name, charge, delivery_msg, "
			+ "tracking_num, process_nm ";
			
			//"SELECT order_date, order_no, mem_name, product_name, buy_num, charge, "
			//+ "delivery_msg, tracking_num, process_nm FROM v_order_manager ";
	
	final String ORDER_BY_ORDER_DATE = 
			GET_ALL_ORDER_MANAGER+"ORDER BY order_date ";
	
	final String ORDER_BY_ORDER_NO = 
			GET_ALL_ORDER_MANAGER+"ORDER BY order_no ";
	
	final String ORDER_BY_MEM_NAME = 
			GET_ALL_ORDER_MANAGER+"ORDER BY mem_name ";
	
	final String ORDER_BY_PRODUCT_NAME = 
			GET_ALL_ORDER_MANAGER+"ORDER BY product_name ";
	
	final String ORDER_BY_BUY_NUM = 
			GET_ALL_ORDER_MANAGER+"ORDER BY buy_num ";

	
	final String ORDER_BY_CHARGE = 
			GET_ALL_ORDER_MANAGER+"ORDER BY charge ";
	
	final String ORDER_BY_PROCESS_NM = 
			GET_ALL_ORDER_MANAGER+"ORDER BY process_cd ";

	final boolean ASC = true;
	final boolean DESC = false;
	

	public List<VOrderManagerVo> getAllOrederByDate(boolean orderBy) throws DataAccessException {
		if(orderBy == ASC){
			System.out.println("dao 진입");
			return getJdbcTemplate().query(ORDER_BY_ORDER_DATE, 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}else{
			return getJdbcTemplate().query(ORDER_BY_ORDER_DATE+"DESC", 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}
	}

	public List<VOrderManagerVo> getAllOrederByNo(boolean orderBy) throws DataAccessException {
		System.out.println("오더매니저 다오");
		if(orderBy == ASC){
			return getJdbcTemplate().query(ORDER_BY_ORDER_NO, 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}else{
			return getJdbcTemplate().query(ORDER_BY_ORDER_NO+"DESC", 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}
	}

	public List<VOrderManagerVo> getAllOrederByName(boolean orderBy) throws DataAccessException {
		if(orderBy == ASC){
			return getJdbcTemplate().query(ORDER_BY_MEM_NAME, 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}else{
			return getJdbcTemplate().query(ORDER_BY_MEM_NAME+"DESC", 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}
	}

	public List<VOrderManagerVo> getAllOrederByProduct(boolean orderBy) throws DataAccessException {
		if(orderBy == ASC){
			return getJdbcTemplate().query(ORDER_BY_PRODUCT_NAME, 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}else{
			return getJdbcTemplate().query(ORDER_BY_PRODUCT_NAME+"DESC", 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}
	}

	public List<VOrderManagerVo> getAllOrederByNum(boolean orderBy) throws DataAccessException {
		if(orderBy == ASC){
			return getJdbcTemplate().query(ORDER_BY_BUY_NUM, 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}else{
			return getJdbcTemplate().query(ORDER_BY_BUY_NUM+"DESC", 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}
	}

	public List<VOrderManagerVo> getAllOrederByCharge(boolean orderBy) throws DataAccessException {
		if(orderBy == ASC){
			return getJdbcTemplate().query(ORDER_BY_CHARGE, 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}else{
			return getJdbcTemplate().query(ORDER_BY_CHARGE+"DESC", 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}
	}

	public List<VOrderManagerVo> getAllOrederByProcess(boolean orderBy) throws DataAccessException {
		if(orderBy == ASC){
			return getJdbcTemplate().query(ORDER_BY_PROCESS_NM, 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}else{
			return getJdbcTemplate().query(ORDER_BY_PROCESS_NM+"DESC", 
					BeanPropertyRowMapper.newInstance(VOrderManagerVo.class));
		}
	}


}
