package com.nmom.soap.svc.board.qna;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.qna.VQnaQnaReVo;

public interface IVQnaQnareSvc {

	//글하나 조회
	VQnaQnaReVo getOneQna(int qna_no);
	
	//모든 글 조회
	List<VQnaQnaReVo> getAllQna(int start, int end);
	
	//검색(제목)
	List<VQnaQnaReVo> searchQnaTitle(String keyword, int start, int end);
	
	//검색(내용)
	List<VQnaQnaReVo> searchQnaContent(String keyword, int start, int end);
	
	//검색(제목+내용)
	List<VQnaQnaReVo> searchQnaTitleNContent(String keyword, int start, int end);
	
	//모든 글개수 조회
	int getQnaCount();
	
	//검색(제목) 글개수 조회
	int getSearchQnaTitleCount(String keyword);
		
	//검색(내용) 글개수 조회
	int getSearchQnaContentCount(String keyword);
	
	//검색(제목+내용) 글개수 조회
	int getSearchQnaTitleNContentCount(String keyword);
	
	
}
