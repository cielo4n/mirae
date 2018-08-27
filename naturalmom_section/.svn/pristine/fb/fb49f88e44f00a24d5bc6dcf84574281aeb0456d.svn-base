package com.nmom.soap.svc.board.qna;

import java.util.List;

import com.nmom.soap.data.dao.board.qna.IVQnaQnareDao;
import com.nmom.soap.data.model.board.qna.VQnaQnaReVo;

public class VQnaQnareSvcImpl implements IVQnaQnareSvc {
	
	IVQnaQnareDao vQnaQnareDao;
	
	public void setVQnaQnareDao(IVQnaQnareDao vQnaQnareDao) {
		this.vQnaQnareDao = vQnaQnareDao;
	}

	@Override
	public VQnaQnaReVo getOneQna(int qna_no) {
		return vQnaQnareDao.getOneQna(qna_no);
	}

	@Override
	public List<VQnaQnaReVo> getAllQna(int start, int end) {
		return vQnaQnareDao.getAllQna(start, end);
	}

	@Override
	public List<VQnaQnaReVo> searchQnaTitle(String keyword, int start, int end) {
		return vQnaQnareDao.searchQnaTitle(keyword, start, end);
	}

	@Override
	public List<VQnaQnaReVo> searchQnaContent(String keyword, int start, int end) {
		return vQnaQnareDao.searchQnaContent(keyword, start, end);
	}

	@Override
	public List<VQnaQnaReVo> searchQnaTitleNContent(String keyword, int start, int end) {
		return vQnaQnareDao.searchQnaTitleNContent(keyword, start, end);
	}

	@Override
	public int getQnaCount() {
		return vQnaQnareDao.getQnaCount();
	}

	@Override
	public int getSearchQnaTitleCount(String keyword) {
		return vQnaQnareDao.getQnaSearchTitleCount(keyword);
	}

	@Override
	public int getSearchQnaContentCount(String keyword) {
		return vQnaQnareDao.getQnaSearchContentCount(keyword);
	}

	@Override
	public int getSearchQnaTitleNContentCount(String keyword) {
		return vQnaQnareDao.getQnaSearchTitleNContentCount(keyword);
	}
	
}
