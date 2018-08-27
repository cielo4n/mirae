package com.nmom.soap.data.dao.board.review;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.review.VReview_FrontVo;

public interface IVReview_FrontDao 
{
	// 게시판 목록 조회하기
	List<VReview_FrontVo> getAllList(int product_no, int start, int end) throws DataAccessException;
	
	// 해당 상품의 리뷰 개수 가져오기
	int getCountReviews(int product_no) throws DataAccessException;
}
