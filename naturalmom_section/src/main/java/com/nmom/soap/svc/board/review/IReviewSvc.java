package com.nmom.soap.svc.board.review;

import com.nmom.soap.data.model.board.review.ReviewVo;

public interface IReviewSvc 
{
	// 리뷰 하나 가져오기
	ReviewVo getOneReview(int review_no);
	
	// 리뷰 등록하기
	int addReview(ReviewVo review);
	
	// 리뷰 수정하기
	int editReview(ReviewVo review);
	
	// 리뷰 삭제하기
	int removeReview(int review_no);
	
	// 조회수 올리기
	int updateReviewCount(ReviewVo review);
}
