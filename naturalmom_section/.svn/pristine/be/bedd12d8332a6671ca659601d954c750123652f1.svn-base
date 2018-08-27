package com.nmom.soap.data.dao.board.review;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.review.ReviewVo;

public interface IReviewDao 
{
	// 상품 후기 수정 시 내용 가져오기
	ReviewVo getOneReview(int review_no) throws DataAccessException;
	
	// 상품 후기 등록하기
	int addReview(ReviewVo review) throws DataAccessException;

	// 상품 후기 삭제하기
	int removeReview(int review_no) throws DataAccessException;
	
	// 상품 후기 수정하기
	int editReview(ReviewVo review) throws DataAccessException;

	int updateCountReview(ReviewVo review);
}
