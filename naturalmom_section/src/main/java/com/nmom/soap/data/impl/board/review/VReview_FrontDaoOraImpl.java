package com.nmom.soap.data.impl.board.review;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nmom.soap.data.dao.board.review.IVReview_FrontDao;
import com.nmom.soap.data.model.board.review.VReview_FrontVo;

public class VReview_FrontDaoOraImpl extends NamedParameterJdbcDaoSupport implements IVReview_FrontDao 
{
	// 게시판 목록 뽑기
	private final String GET_ALL_LIST = "SELECT A.* FROM (SELECT rownum as rvw_rnum, X.* FROM "
			+ "(SELECT * from V_REVIEW_FRONT V WHERE V.product_no = :product_no ORDER BY review_no DESC) X) A "
			+ "WHERE A.rvw_rnum >= :start AND A.rvw_rnum <= :end ORDER BY rownum ASC";
	// 해당 상품의 리뷰 수 뽑기
	private final String GET_COUNT_REVIEWS = "SELECT COUNT(review_no) FROM V_REVIEW_FRONT WHERE product_no = ?";
	
	public List<VReview_FrontVo> getAllList(int product_no, int start, int end) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("product_no", new Integer(product_no));
		msps.addValue("start", new Integer(start));
		msps.addValue("end", new Integer(end));
		
		return getNamedParameterJdbcTemplate().query(GET_ALL_LIST, msps,
				new BeanPropertyRowMapper<VReview_FrontVo>(VReview_FrontVo.class));
	}

	@Override
	public int getCountReviews(int product_no) throws DataAccessException 
	{
		return getJdbcTemplate().queryForInt(GET_COUNT_REVIEWS, 
				new Object[]{new Integer(product_no)}, new int[] {Types.INTEGER});
	}
}
