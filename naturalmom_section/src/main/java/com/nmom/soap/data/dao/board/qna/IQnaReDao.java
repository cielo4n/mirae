package com.nmom.soap.data.dao.board.qna;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.qna.QnaReVo;

public interface IQnaReDao {
	
	//댓글 조회
	List<QnaReVo> getQnaReByQnaNo(int qna_no) throws DataAccessException;
	
	//댓글 작성
	int addQnaRe(QnaReVo qnare) throws DataAccessException;
	int addQnaRe(String qna_re_content, int qna_no, String mem_id) throws DataAccessException;
	
	//댓글 수정
	int editQnaRe(QnaReVo qnare) throws DataAccessException;
	int editQnaRe(int qna_re_no, String qna_re_content) throws DataAccessException;
	
	//댓글 삭제
	int removeQnaRe(QnaReVo qnare) throws DataAccessException;
	int removeQnaRe(int qna_re_no) throws DataAccessException;
	
}