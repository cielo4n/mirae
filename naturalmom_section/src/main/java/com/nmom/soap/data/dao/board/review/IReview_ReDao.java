package com.nmom.soap.data.dao.board.review;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.review.ReviewVo;
import com.nmom.soap.data.model.board.review.Review_ReVo;


public interface IReview_ReDao 
{
	// 해당 리뷰글의 모든 리플 가져오기
	List<Review_ReVo> getAllRe(int review_no) throws DataAccessException;
	
	// 리플 등록
	int addRe(Review_ReVo re) throws DataAccessException;
	
	// 리플 수정
	int editRe(Review_ReVo re) throws DataAccessException;
	
	// 리플 삭제
	int removeRe(int review_re_no) throws DataAccessException;
	
	// 댓글 번호로 글 번호 알아내기
	int getRvwNoOfRe(int review_re_no) throws DataAccessException;

	// 댓글 하나 가져오기
	Review_ReVo getOneReply(int review_re_no) throws DataAccessException;
}
