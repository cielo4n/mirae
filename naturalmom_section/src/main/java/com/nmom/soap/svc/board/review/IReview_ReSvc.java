package com.nmom.soap.svc.board.review;

import java.util.List;

import com.nmom.soap.data.model.board.review.ReviewVo;
import com.nmom.soap.data.model.board.review.Review_ReVo;

public interface IReview_ReSvc
{
	// 해당 리뷰글의 모든 리플 가져오기
	List<Review_ReVo> getAllRe(int review_no);
	
	// 리플 등록
	int addRe(Review_ReVo re);
	
	// 리플 수정
	int editRe(Review_ReVo re);
	
	// 리플 삭제
	int removeRe(int review_re_no);
	
	// 댓글 번호로 글 번호 알아오기
	int getRvwNoOfRe(int review_re_no);

	// 리플 하나 가져오기
	Review_ReVo getOneReply(int review_re_no);
}
