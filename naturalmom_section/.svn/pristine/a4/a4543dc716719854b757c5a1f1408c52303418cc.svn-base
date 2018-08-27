package com.nmom.soap.data.impl.board.review;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.nmom.soap.data.dao.board.review.IReview_ReDao;
import com.nmom.soap.data.model.board.review.ReviewVo;
import com.nmom.soap.data.model.board.review.Review_ReVo;

public class Review_ReDaoOraImpl extends NamedParameterJdbcDaoSupport implements IReview_ReDao
{
	// 모든 리플 가져오기
	private final String GET_ALL_REPLY = "SELECT * FROM tb_review_re WHERE rvw_re_del_check = 0 AND rvw_no = ?";
	// 댓글 등록하기
	private final String ADD_REPLY = "INSERT INTO tb_review_re (rvw_re_content, rvw_re_write_day, rvw_re_del_check, "
			+ "rvw_no, mem_id, review_re_no) "
			+ "VALUES (:rvw_re_content,SYSDATE,0,:rvw_no,:mem_id, REVIEW_RE_NO_SEQ.NEXTVAL)";
	// 댓글 수정하기
	private final String EDIT_REPLY = "UPDATE tb_review_re SET rvw_re_content = :rvw_re_content"
			+ " WHERE review_re_no = :review_re_no";
	// 댓글 삭제하기
	private final String REMOVE_REPLY = "UPDATE tb_review_re SET rvw_re_del_check = 1"
			+ "WHERE review_re_no = :review_re_no";
	// 댓글 번호로 글 번호 알아내기
	private final String GET_RVW_NO_OF_REPLY = "SELECT rvw_no FROM tb_review_re WHERE review_re_no = :review_re_no";
	// 댓글 하나 가져오기
	private final String GET_ONE_REPLY = "SELECT * FROM tb_review_re WHERE review_re_no = ?";
	
	public List<Review_ReVo> getAllRe(int review_no) throws DataAccessException
	{
		return getJdbcTemplate().query(GET_ALL_REPLY, 
				new BeanPropertyRowMapper<Review_ReVo>(Review_ReVo.class), new Integer(review_no));
	}
	
	public int addRe(Review_ReVo re) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("rvw_re_content", re.getRvw_re_content(), Types.VARCHAR);
		msps.addValue("rvw_no", re.getRvw_no(), Types.INTEGER);
		msps.addValue("mem_id", re.getMem_id(), Types.VARCHAR);
		
		return getNamedParameterJdbcTemplate().update(ADD_REPLY, msps);
	}

	public int editRe(Review_ReVo re) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("rvw_re_content", re.getRvw_re_content(), Types.VARCHAR);
		msps.addValue("review_re_no", re.getReview_re_no(), Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(EDIT_REPLY, msps);
	}

	public int removeRe(int review_re_no) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("review_re_no", review_re_no, Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(REMOVE_REPLY, msps);
	}

	@Override
	public int getRvwNoOfRe(int review_re_no) throws DataAccessException 
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("review_re_no", new Integer(review_re_no));
		return getNamedParameterJdbcTemplate().queryForInt(GET_RVW_NO_OF_REPLY, msps);
	}

	@Override
	public Review_ReVo getOneReply(int review_re_no) throws DataAccessException 
	{
		List<Review_ReVo> result_list = getJdbcTemplate().query(GET_ONE_REPLY, 
				new BeanPropertyRowMapper<Review_ReVo>(Review_ReVo.class), new Integer(review_re_no));
		
		if (result_list != null && result_list.size() > 0)
			return result_list.get(0);
		else
			return null; 
	}
}
