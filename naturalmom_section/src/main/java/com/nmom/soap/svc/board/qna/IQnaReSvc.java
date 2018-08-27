package com.nmom.soap.svc.board.qna;

import java.util.List;

import com.nmom.soap.data.model.board.qna.QnaReVo;

public interface IQnaReSvc {
	
	//댓글 조회
	List<QnaReVo> getQnaReByQnaNo(int qna_no);
	
	//댓글 작성
	int addQnaRe(QnaReVo qnare);
	int addQnaRe(String qna_re_content, int qna_no, String mem_id);
	
	//댓글 수정
	int editQnaRe(QnaReVo qnare);
	int editQnaRe(int qna_re_no, String qna_re_content);
	
	//댓글 삭제
	int removeQnaRe(QnaReVo qnare);
	int removeQnaRe(int qna_re_no);
	
}
