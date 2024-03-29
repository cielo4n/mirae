package com.nmom.soap.svc.board.qna;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.qna.QnaVo;

public interface IQnaSvc {

	//비밀글에 비밀번호 맞나 확인
	boolean secretQnaPwCheck(int qna_no, String qna_pw);
	
	//일반글작성
	int addQna(String qna_title, String qna_content, String qna_pw, String mem_id);
	
	//답변글작성
	int addQnaAnswer(String qna_title, String qna_content, String qna_pw, String mem_id, int qna_pos, int qna_ref);
	
	//글 수정
	int editQna(QnaVo qna);
	int editQna(int qna_no, String qna_title, String qna_content, String qna_pw);
	
	//글번호로 삭제
	int removeQna(int qna_no);

	//참조글번호로 삭제
	int removeQnaByRef(int qna_ref);
	
	//댓글 제외한 하나의 글 가져오기
	QnaVo getOneSimpleQna(int qna_no);
	
	//조회수 증가
	int increaseQnaHits(int qna_no);
	
	//ref에 해당하는 pos 하나씩 뒤로 넘김 (이후에 pos의 자리에 데이터 추가)
	int pushRearPos(int qna_parent_ref, int qna_parent_pos);
	
	//ref에 해당하는 pos 하나씩 앞으로 넘김 (이전에 pos의 자리에 데이터 삭제)
	int pushFrontPos(int qna_parent_ref, int qna_parent_pos);
	
	//ref와 pos로 qna_no 뽑음
	QnaVo getSimpleQnaByRefNPos(int qna_ref, int qna_pos);
}
