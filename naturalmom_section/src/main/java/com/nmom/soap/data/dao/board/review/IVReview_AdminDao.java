package com.nmom.soap.data.dao.board.review;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.review.VReview_AdminVo;

public interface IVReview_AdminDao 
{
	// 게시판 목록 뽑기
	List<VReview_AdminVo> getAllList(int start, int end) throws DataAccessException;
	
	// 게시판 내용 뽑기
	VReview_AdminVo getOneReview(int review_no) throws DataAccessException;
	
	// r_num으로 게시판 내용 뽑기
	VReview_AdminVo getOneReviewByR_num(int r_num) throws DataAccessException;
	
	// 제목으로 검색하기
	List<VReview_AdminVo> getReviews_by_title(String search, int start, int end) throws DataAccessException;
	
	// 내용으로 검색하기
	List<VReview_AdminVo> getReviews_by_content(String search, int start, int end) throws DataAccessException;
	
	// 글쓴이로 검색하기
	List<VReview_AdminVo> getReviews_by_id(String search, int start, int end) throws DataAccessException;
	
	// 제목 및 내용으로 검색하기
	List<VReview_AdminVo> getReviews_by_title_n_content(String search, int start, int end) throws DataAccessException;
	
	//전체 글 수 가져오기
	int getCountAllReivews() throws DataAccessException;

	// 제목으로 검색한 글 수 가져오기
	int getCountReviewsByTitle(String search) throws DataAccessException;

	// 내용으로 검색한 글 수 가져오기
	int getCountReviewsByContent(String search) throws DataAccessException;

	// 아이디로 검색한 글 수 가져오기
	int getCountReviewsById(String search) throws DataAccessException;

	// 제목+내용으로 검색한 글 수 가져오기
	int getCountReviewsByTitleNContent(String search) throws DataAccessException;
}
