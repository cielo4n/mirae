package com.nmom.soap.data.impl.board.review;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nmom.soap.data.dao.board.review.IVReview_AdminDao;
import com.nmom.soap.data.model.board.review.VReview_AdminVo;

public class VReview_AdminDaoOraImpl extends NamedParameterJdbcDaoSupport implements IVReview_AdminDao 
{
	// 게시판 목록 조회
//	private final String GET_ALL_LIST = "SELECT * FROM v_review_admin";
	// rownum == review_no
//	private final String GET_ALL_LIST = "SELECT A.* FROM (SELECT rownum as re_rnum, X.* FROM"
//			+ " (SELECT * from V_REVIEW_ADMIN ORDER BY review_no ASC) X WHERE rownum <= :end) A WHERE A.re_rnum >= :start"
//			+ " ORDER BY rownum DESC";
	private final String GET_ALL_LIST = "SELECT A.* FROM (SELECT rownum as rvw_rnum, X.* FROM"
	+ " (SELECT * from V_REVIEW_ADMIN ORDER BY review_no DESC) X WHERE rownum <= :end) A WHERE A.rvw_rnum >= :start"
	+ " ORDER BY rownum ASC";
	// 게시판 내용 조회
	private final String GET_ONE_REVIEW = "SELECT A.* FROM (SELECT rownum as rvw_rnum, X.* FROM "
			+ "(SELECT * from V_REVIEW_ADMIN ORDER BY review_no DESC) X ) A WHERE review_no = ?";
	// rownum으로 내용 조회
	private final String GET_ONE_REVIEW_R_NUM = "SELECT A.* FROM "
			+ "(SELECT rownum as rvw_rnum, V.* from V_REVIEW_ADMIN V) A "
			+ "WHERE A.rvw_rnum = ?";
	// 제목으로 검색하기
	private final String GET_SEARCH_BY_TITLE = "SELECT A.* FROM (SELECT rownum as rvw_rnum, X.* FROM"
			+ " (SELECT * from V_REVIEW_ADMIN WHERE rvw_title LIKE :search ORDER BY review_no DESC) X WHERE rownum <= :end) A"
			+ " WHERE A.rvw_rnum >= :start ORDER BY rownum ASC";
	// 내용으로 검색하기
	private final String GET_SEARCH_BY_CONTENT = "SELECT A.* FROM (SELECT rownum as rvw_rnum, X.* FROM"
			+ " (SELECT * from V_REVIEW_ADMIN WHERE rvw_content LIKE :search ORDER BY review_no DESC) X WHERE rownum <= :end) A"
			+ " WHERE A.rvw_rnum >= :start ORDER BY rownum ASC";
	// 글쓴이로 검색하기
	private final String GET_SEARCH_BY_ID = "SELECT A.* FROM (SELECT rownum as rvw_rnum, X.* FROM"
			+ " (SELECT * from V_REVIEW_ADMIN WHERE mem_id LIKE :search ORDER BY review_no DESC) X WHERE rownum <= :end) A"
			+ " WHERE A.rvw_rnum >= :start ORDER BY rownum ASC";
	// 제목+내용으로 검색하기
	private final String GET_SEARCH_BY_TITLE_CONTENT = "SELECT A.* FROM (SELECT rownum as rvw_rnum, X.* FROM"
			+ " (SELECT * from V_REVIEW_ADMIN WHERE rvw_title LIKE :search OR rvw_content LIKE :search ORDER BY review_no DESC) X WHERE rownum <= :end) A"
			+ " WHERE A.rvw_rnum >= :start ORDER BY rownum ASC";
	// 전체 글 수 가져오기
	private final String GET_COUNT_ALL_REVIEWS = "SELECT COUNT(review_no) FROM V_REVIEW_ADMIN";
	// 제목으로 검색한 글 수 가져오기
	private final String GET_COUNT_REVIEWS_BY_TITLE = "SELECT COUNT(review_no) FROM V_REVIEW_ADMIN WHERE rvw_title LIKE ?";
	// 내용으로 검색한 글 수 가져오기
	private final String GET_COUNT_REVIEWS_BY_CONTENT = "SELECT COUNT(review_no) FROM V_REVIEW_ADMIN WHERE rvw_content LIKE ?";
	// 아이디로 검색한 글 수 가져오기
	private final String GET_COUNT_REVIEWS_BY_ID = "SELECT COUNT(review_no) FROM V_REVIEW_ADMIN WHERE mem_id LIKE ?";
	// 제목+내용으로 검색한 글 수 가져오기
	private final String GET_COUNT_REVIEWS_BY_TITLE_CONTENT = "SELECT COUNT(review_no) FROM V_REVIEW_ADMIN "
			+ "WHERE rvw_title LIKE ? OR rvw_content LIKE ?";
	
	public List<VReview_AdminVo> getAllList(int start, int end) throws DataAccessException 
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("start", new Integer(start));
		msps.addValue("end", new Integer(end));
		
		return getNamedParameterJdbcTemplate().query(GET_ALL_LIST, msps, 
				new BeanPropertyRowMapper<VReview_AdminVo>(VReview_AdminVo.class));
	}

	public VReview_AdminVo getOneReview(int review_no) throws DataAccessException
	{
		List<VReview_AdminVo> list = getJdbcTemplate().query(GET_ONE_REVIEW, 
				new BeanPropertyRowMapper<VReview_AdminVo>(VReview_AdminVo.class), new Integer(review_no));
		
		if (list != null && list.size() > 0)
			return list.get(0);
		
		return null;
	}
	
	@Override
	public VReview_AdminVo getOneReviewByR_num(int r_num) throws DataAccessException 
	{
		List<VReview_AdminVo> list = getJdbcTemplate().query(GET_ONE_REVIEW_R_NUM, 
				new BeanPropertyRowMapper<VReview_AdminVo>(VReview_AdminVo.class), new Integer(r_num));
		
		if (list != null && list.size() > 0)
			return list.get(0);
		
		return null;
	}

	public List<VReview_AdminVo> getReviews_by_title(String search, int start, int end) throws DataAccessException 
	{
		search = "%" + search + "%";
		
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("search", search);
		msps.addValue("start", new Integer(start));
		msps.addValue("end", new Integer(end));
		
		return getNamedParameterJdbcTemplate().query(GET_SEARCH_BY_TITLE, msps, 
				new BeanPropertyRowMapper<VReview_AdminVo>(VReview_AdminVo.class));
	}

	public List<VReview_AdminVo> getReviews_by_content(String search, int start, int end) throws DataAccessException 
	{
		search = "%" + search + "%";
		
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("search", search);
		msps.addValue("start", new Integer(start));
		msps.addValue("end", new Integer(end));
		
		return getNamedParameterJdbcTemplate().query(GET_SEARCH_BY_CONTENT, msps, 
				new BeanPropertyRowMapper<VReview_AdminVo>(VReview_AdminVo.class));
	}

	public List<VReview_AdminVo> getReviews_by_id(String search, int start, int end) throws DataAccessException 
	{
		search = "%" + search + "%";
		
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("search", search);
		msps.addValue("start", new Integer(start));
		msps.addValue("end", new Integer(end));
		
		return getNamedParameterJdbcTemplate().query(GET_SEARCH_BY_ID, msps, 
				new BeanPropertyRowMapper<VReview_AdminVo>(VReview_AdminVo.class));
	}

	public List<VReview_AdminVo> getReviews_by_title_n_content(String search, int start, int end) throws DataAccessException 
	{
		search = "%" + search + "%";
		
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("search", search);
		msps.addValue("start", new Integer(start));
		msps.addValue("end", new Integer(end));
		
		return getNamedParameterJdbcTemplate().query(GET_SEARCH_BY_TITLE_CONTENT, msps, 
				new BeanPropertyRowMapper<VReview_AdminVo>(VReview_AdminVo.class));
	}

	@Override
	public int getCountAllReivews() throws DataAccessException
	{
		return getJdbcTemplate().queryForInt(GET_COUNT_ALL_REVIEWS);
	}

	@Override
	public int getCountReviewsByTitle(String search) throws DataAccessException 
	{
		search = "%" + search + "%";
		return getJdbcTemplate().queryForInt(GET_COUNT_REVIEWS_BY_TITLE, new Object[]{search}, new int[]{Types.VARCHAR});
	}

	@Override
	public int getCountReviewsByContent(String search) throws DataAccessException 
	{
		search = "%" + search + "%";
		return getJdbcTemplate().queryForInt(GET_COUNT_REVIEWS_BY_CONTENT, new Object[]{search}, new int[]{Types.VARCHAR});
	}

	@Override
	public int getCountReviewsById(String search) throws DataAccessException 
	{
		search = "%" + search + "%";
		return getJdbcTemplate().queryForInt(GET_COUNT_REVIEWS_BY_ID, new Object[]{search}, new int[]{Types.VARCHAR});
	}

	@Override
	public int getCountReviewsByTitleNContent(String search) throws DataAccessException
	{
		search = "%" + search + "%";
		return getJdbcTemplate().queryForInt(GET_COUNT_REVIEWS_BY_TITLE_CONTENT, 
				new Object[]{search, search}, new int[]{Types.VARCHAR, Types.VARCHAR});
	}
}
