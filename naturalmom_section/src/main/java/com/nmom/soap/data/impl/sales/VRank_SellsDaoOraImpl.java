package com.nmom.soap.data.impl.sales;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nmom.soap.data.dao.sales.IVRank_SellsDao;
import com.nmom.soap.data.model.sales.VRank_SellsVo;
import com.nmom.soap.data.model.sales.stat.AgeGroupVo;
import com.nmom.soap.data.model.sales.stat.GenderGroupVo;

public class VRank_SellsDaoOraImpl extends JdbcDaoSupport implements IVRank_SellsDao 
{
	// 판매 순위 오름차순 정렬
	private final String GET_ALL_ASC = "SELECT ROWNUM, all_sells, product_name FROM V_RANK_SELLS "
			+ "ORDER BY ROWNUM ASC";
	// 판매 순위 내림차순 정렬
	private final String GET_ALL_DESC = "SELECT ROWNUM, all_sells, product_name FROM V_RANK_SELLS "
			+ "ORDER BY ROWNUM DESC";
	
	// 나이대별 회원 수
	private final String GET_AGE_GROUP_COUNT = "SELECT m.mem_age * 10 AS age_group, "
			+ "ROUND(COUNT(*) / (SELECT COUNT(mem_id) FROM tb_member), 2) AS ratio, COUNT(*) AS amount FROM "
			+ "(SELECT FLOOR((117 - TO_NUMBER(SUBSTR(mem_birth, 1, 2)))/10) AS mem_age FROM "
			+ "tb_member t WHERE t.mem_id NOT LIKE 'admin%' AND drop_out = 0) m GROUP BY m.mem_age ORDER BY age_group DESC";
	
	// 성별별 회원 수
	private final String GET_GENDER_GROUP_COUNT = 
			"SELECT mem_gender,  ROUND(COUNT(mem_id) / (SELECT COUNT(mem_id) FROM tb_member), 2) "
			+ "AS ratio, COUNT(*) AS amount FROM tb_member WHERE tb_member.MEM_ID NOT LIKE 'admin%' AND drop_out = 0 GROUP BY mem_gender";
	
	public List<VRank_SellsVo> getAllRank(boolean order) throws DataAccessException 
	{
		if(order)
			return getJdbcTemplate().query(GET_ALL_ASC, 
					new BeanPropertyRowMapper<VRank_SellsVo>(VRank_SellsVo.class));
		else
			return getJdbcTemplate().query(GET_ALL_DESC, 
					new BeanPropertyRowMapper<VRank_SellsVo>(VRank_SellsVo.class));
	}
	
	public List<AgeGroupVo> getStatAgeGroup() throws DataAccessException
	{
		return getJdbcTemplate().query(GET_AGE_GROUP_COUNT,
				new BeanPropertyRowMapper<AgeGroupVo>(AgeGroupVo.class));
	}
	
	public List<GenderGroupVo> getStatGenderGroup() throws DataAccessException
	{
		return getJdbcTemplate().query(GET_GENDER_GROUP_COUNT,
				new BeanPropertyRowMapper<GenderGroupVo>(GenderGroupVo.class));
	}
}
