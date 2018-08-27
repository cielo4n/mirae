package com.nmom.soap.svc.board.qna;

import java.util.List;

import com.nmom.soap.data.dao.board.qna.IQnaReDao;
import com.nmom.soap.data.model.board.qna.QnaReVo;

public class QnaReSvcImpl implements IQnaReSvc {

	IQnaReDao qnaReDao;
	
	public void setQnaReDao(IQnaReDao qnaReDao) {
		this.qnaReDao = qnaReDao;
	}

	@Override
	public List<QnaReVo> getQnaReByQnaNo(int qna_no) {
		return qnaReDao.getQnaReByQnaNo(qna_no);
	}

	@Override
	public int addQnaRe(QnaReVo qnare) {
		return qnaReDao.addQnaRe(qnare);
	}

	@Override
	public int addQnaRe(String qna_re_content, int qna_no, String mem_id) {
		return qnaReDao.addQnaRe(qna_re_content, qna_no, mem_id);
	}

	@Override
	public int editQnaRe(QnaReVo qnare) {
		return qnaReDao.editQnaRe(qnare);
	}

	@Override
	public int editQnaRe(int qna_re_no, String qna_re_content) {
		return qnaReDao.editQnaRe(qna_re_no, qna_re_content);
	}

	@Override
	public int removeQnaRe(QnaReVo qnare) {
		return qnaReDao.removeQnaRe(qnare);
	}

	@Override
	public int removeQnaRe(int qna_re_no) {
		return qnaReDao.removeQnaRe(qna_re_no);
	}


}
