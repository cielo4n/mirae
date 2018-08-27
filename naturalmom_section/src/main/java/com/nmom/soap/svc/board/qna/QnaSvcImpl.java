package com.nmom.soap.svc.board.qna;

import com.nmom.soap.data.dao.board.qna.IQnaDao;
import com.nmom.soap.data.model.board.qna.QnaVo;

public class QnaSvcImpl implements IQnaSvc {

	IQnaDao qnaDao;
	
	public void setQnaDao(IQnaDao qnaDao) {
		this.qnaDao = qnaDao;
	}

	@Override
	public boolean secretQnaPwCheck(int qna_no, String qna_pw) {
		return qnaDao.secretQnaPwCheck(qna_no, qna_pw); 
	}

	@Override
	public int addQna(String qna_title, String qna_content, String qna_pw, String mem_id) {
		return qnaDao.addQna(qna_title, qna_content, qna_pw, mem_id);
	}

	@Override
	public int addQnaAnswer(String qna_title, String qna_content, String qna_pw, String mem_id, int qna_pos,
			int qna_ref) {
		return qnaDao.addQnaAnswer(qna_title, qna_content, qna_pw, mem_id, qna_pos, qna_ref);
	}

	@Override
	public int editQna(QnaVo qna) {
		return qnaDao.editQna(qna);
	}

	@Override
	public int editQna(int qna_no, String qna_title, String qna_content, String qna_pw) {
		return qnaDao.editQna(qna_no, qna_title, qna_content, qna_pw);
	}

	@Override
	public int removeQna(int qna_no) {
		return qnaDao.removeQna(qna_no);
	}

	@Override
	public int removeQnaByRef(int qna_ref) {
		return qnaDao.removeQnaByRef(qna_ref);
	}

	@Override
	public QnaVo getOneSimpleQna(int qna_no) {
		return qnaDao.getOneSimpleQna(qna_no);
	}

	@Override
	public int increaseQnaHits(int qna_no) {
		return qnaDao.increaseQnaHits(qna_no);
	}

	@Override
	public int pushRearPos(int qna_parent_ref, int qna_parent_pos) {
		return qnaDao.pushRearPos(qna_parent_ref, qna_parent_pos);
	}

	@Override
	public int pushFrontPos(int qna_parent_ref, int qna_parent_pos) {
		return qnaDao.pushFrontPos(qna_parent_ref, qna_parent_pos);
	}

	@Override
	public QnaVo getSimpleQnaByRefNPos(int qna_ref, int qna_pos) {
		return qnaDao.getSimpleQnaByRefNPos(qna_ref, qna_pos);
	}

}
