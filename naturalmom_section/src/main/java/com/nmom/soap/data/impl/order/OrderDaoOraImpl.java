package com.nmom.soap.data.impl.order;

import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.nmom.soap.data.dao.order.IOrderDao;
import com.nmom.soap.data.model.order.OrderVo;

public class OrderDaoOraImpl extends NamedParameterJdbcDaoSupport implements IOrderDao {

	
	private SimpleJdbcInsert sji = null;
	
	final String ADD_ORDER = 
			"INSERT INTO tb_order (charge, credit_num, credit_exp, rcv_name, rcv_phone, "
			+ "rcv_addr_post, rcv_addr_detail, delivery_msg, credit_cd, mem_id, tracking_num, order_no) "
			+ "VALUES (:charge, :credit_num, :credit_exp, :rcv_name, :rcv_phone, :rcv_addr_post, :rcv_addr_detail,"
			+ " :delivery_msg, (SELECT credit_cd FROM tb_credit WHERE credit_nm = :credit_nm),"
			+ " :mem_id, 0, ORDER_NO_SEQ.NEXTVAL)";
	
	final String EDIT_TRACKING_NUM_ORDER = 
			"UPDATE NMDB.tb_order "
			+ "SET tracking_num = :tracking_num, "
			+ "delivery_com_cd = "
			+ "(SELECT delivery_com_cd FROM tb_delivery_com  WHERE delivery_com_nm = :delivery_com_nm) "
			+ "WHERE order_no = :order_no";
	
	
/*	protected void initDao() throws Exception {
		this.sji = new SimpleJdbcInsert(this.getDataSource());
		this.sji.withTableName("tb_order");
		this.sji.usingGeneratedKeyColumns("order_no"); //id <<PK, AI>> 
		//스트링 배열로 여러개 받아오기 가능.. 정수 외에 문자도 유니크하면 받아오기 가능
	}*/
	
	
	public int addOrder(OrderVo order, String credit_nm) throws DataAccessException {
		// TODO Auto-generated method stub
		KeyHolder gkh = new GeneratedKeyHolder();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("charge", new Integer(order.getCharge()), Types.INTEGER);
		ps.addValue("credit_num", order.getCredit_num(), Types.VARCHAR);
		ps.addValue("credit_exp", order.getCredit_exp(), Types.VARCHAR);
		ps.addValue("rcv_name", order.getRcv_name(), Types.VARCHAR);
		ps.addValue("rcv_phone", order.getRcv_phone(), Types.VARCHAR);
		ps.addValue("rcv_addr_post", order.getRcv_addr_post(), Types.VARCHAR);
		ps.addValue("rcv_addr_detail", order.getRcv_addr_detail(), Types.VARCHAR);
		ps.addValue("delivery_msg", order.getDelivery_msg(), Types.VARCHAR);
		ps.addValue("credit_nm", credit_nm, Types.VARCHAR);
		ps.addValue("mem_id", order.getMem_id(), Types.VARCHAR);
		this.getNamedParameterJdbcTemplate().update(ADD_ORDER, ps, gkh, new String[]{"order_no"});
		
		return gkh != null ? gkh.getKey().intValue() : 0;
		
				//( r > 0 && gkh != null) ? gkh.getKey().intValue() : -1;
	}

	
	/*public int addOrder(OrderVo order, String credit_nm, String delivery_com_nm) throws DataAccessException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("charge", new Integer(order.getCharge()));
		map.put("credit_num", order.getCredit_num());
		map.put("credit_exp", order.getCredit_exp());
		map.put("rcv_name", order.getRcv_name());
		map.put("rcv_phone", order.getRcv_phone());
		map.put("rcv_addr_post", order.getRcv_addr_post());
		map.put("rcv_addr_detail", order.getRcv_addr_detail());
		map.put("delivery_msg", order.getDelivery_msg());
		map.put("tracking_num", new Integer(0));
		map.put("credit_cd", 11);
		map.put("delivery_com_cd", 11);
		map.put("mem_id", order.getMem_id());
		KeyHolder gkh = this.sji.executeAndReturnKeyHolder(map);
//		Number num_key = this.sji.executeAndReturnKey(map);
		System.out.println("SJI 방식으로 입력됨");
//		return num_key != null ? num_key.intValue() : 0;
		return gkh.getKey().intValue();
				//( r > 0 && gkh != null) ? gkh.getKey().intValue() : -1;
	}*/
	
	public int editTrackingNumOrder(int order_no, int tracking_num, String delivery_com_nm) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("order_no", new Integer(order_no), Types.INTEGER);
		ps.addValue("tracking_num", new Integer(tracking_num), Types.INTEGER);
		ps.addValue("delivery_com_nm", delivery_com_nm, Types.VARCHAR);
		int r = this.getNamedParameterJdbcTemplate().update(EDIT_TRACKING_NUM_ORDER, ps);
		return r;
	}

}
