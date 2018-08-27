package com.nmom.soap.data.impl.board.review;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.nmom.soap.data.dao.board.review.IReviewDao;
import com.nmom.soap.data.model.board.review.ReviewVo;

public class ReviewDaoOraImpl extends NamedParameterJdbcDaoSupport implements IReviewDao
{
	// 상품 후기 등록하기
	private final String ADD_REVIEW = "INSERT INTO tb_review (rvw_title, rvw_write_day, rvw_hits, rvw_content, "
			+ "rvw_del_check, rvw_satisfaction, product_no, board_id, mem_id, review_no) "
			+ "VALUES (:rvw_title,SYSDATE,0,:rvw_content,0,:rvw_satisfaction,:product_no,5,:mem_id, REVIEW_NO_SEQ.NEXTVAL)";
	// 상품 후기 수정하기
	private final String EDIT_REVIEW = "UPDATE tb_review SET rvw_title = :rvw_title, rvw_satisfaction = :rvw_satisfaction, "
			+ " rvw_content = :rvw_content WHERE review_no = :review_no";
	// 상품 후기 삭제하기
	private final String REMOVE_REVIEW = "UPDATE tb_review SET rvw_del_check = 1 WHERE review_no = :review_no";
	// 상품 수정 시 글 내용 가져오기
	private final String GET_ONE_REVIEW = "SELECT * FROM tb_review WHERE review_no = ?";
	// 상품 후기 조회수 올리기
	private final String UPDATE_REVIEW_COUNT = "UPDATE tb_review SET rvw_hits = rvw_hits + 1 WHERE review_no = ?";
	
	public ReviewVo getOneReview(int review_no) throws DataAccessException 
	{
		List<ReviewVo> list = getJdbcTemplate().query(GET_ONE_REVIEW, 
				new BeanPropertyRowMapper<ReviewVo>(ReviewVo.class), new Integer(review_no));
		
		if (list != null && list.size() > 0)
			return list.get(0);
		
		return null;
	}

	public int addReview(ReviewVo review) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("rvw_title", review.getRvw_title(), Types.VARCHAR);
		msps.addValue("rvw_content", review.getRvw_content(), Types.VARCHAR);
		msps.addValue("rvw_satisfaction", review.getRvw_satisfaction(), Types.INTEGER);
		msps.addValue("product_no", review.getProduct_no(), Types.INTEGER);
		msps.addValue("mem_id", review.getMem_id(), Types.VARCHAR);
		
		return getNamedParameterJdbcTemplate().update(ADD_REVIEW, msps);
	}

	public int removeReview(int review_no) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("review_no", review_no, Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(REMOVE_REVIEW, msps);
	}

	public int editReview(ReviewVo review) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("rvw_title", review.getRvw_title(), Types.VARCHAR);
		msps.addValue("rvw_satisfaction", review.getRvw_satisfaction(), Types.INTEGER);
		msps.addValue("rvw_content", review.getRvw_content(), Types.VARCHAR);
		msps.addValue("review_no", review.getReview_no(), Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(EDIT_REVIEW, msps);
	}

	@Override
	public int updateCountReview(ReviewVo review) 
	{
		return getJdbcTemplate().update(UPDATE_REVIEW_COUNT, new Object[]{new Integer(review.getReview_no())}, 
				new int[] {Types.INTEGER});
	}
}
