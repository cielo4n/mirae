package com.nmom.soap.data.impl.member;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.nmom.soap.data.dao.member.IVOrdererDao;
import com.nmom.soap.data.model.member.VOrdererVo;

public class VOrdererDaoOraImpl extends NamedParameterJdbcDaoSupport implements IVOrdererDao {

	final private String GET_ORDERER = 
			"SELECT * FROM v_orderer "
			+ "WHERE id = ?";
	
	public VOrdererVo getOrderer(String id) throws DataAccessException {
		System.out.println("오더러 다오");
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("id", id, Types.VARCHAR);
		
		List<VOrdererVo> list = getJdbcTemplate().query(GET_ORDERER, 
				BeanPropertyRowMapper.newInstance(VOrdererVo.class), id);
		System.out.println(list.get(0) == null ? "null" : list.get(0));
		if(list.size() == 1){
			return list.get(0);
		}
		
		return null;
	}

}
