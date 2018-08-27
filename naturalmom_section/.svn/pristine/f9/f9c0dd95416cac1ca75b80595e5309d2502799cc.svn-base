package com.nmom.soap.data.dao.board.qna;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.qna.VQnaQnaReVo;

public interface IVQnaQnareDao {

	//글하나 조회
	VQnaQnaReVo getOneQna(int qna_no) throws DataAccessException;
	
	//모든 글 조회
	List<VQnaQnaReVo> getAllQna(int start, int end) throws DataAccessException;
	
	//검색(제목)
	List<VQnaQnaReVo> searchQnaTitle(String keyword, int start, int end) throws DataAccessException;
	
	//검색(내용)
	List<VQnaQnaReVo> searchQnaContent(String keyword, int start, int end) throws DataAccessException;
	
	//검색(제목+내용)
	List<VQnaQnaReVo> searchQnaTitleNContent(String keyword, int start, int end) throws DataAccessException;

	//모든 글개수 조회
	int getQnaCount() throws DataAccessException;

	//검색(제목) 글개수 조회
	int getQnaSearchTitleCount(String keyword) throws DataAccessException;
	
	//검색(내용) 글개수 조회
	int getQnaSearchContentCount(String keyword) throws DataAccessException;
	
	//검색(제목+내용) 글개수 조회
	int getQnaSearchTitleNContentCount(String keyword) throws DataAccessException;
	
}