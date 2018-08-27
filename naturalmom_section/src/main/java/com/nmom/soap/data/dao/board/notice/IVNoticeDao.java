package com.nmom.soap.data.dao.board.notice;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.notice.VNoticeVo;

public interface IVNoticeDao {
	
	public List<VNoticeVo> getAllNotice(int start, int end) throws DataAccessException;
	
	public List<VNoticeVo> getSearchByTitleNotice(String search, int start, int end) throws DataAccessException;
	
	public List<VNoticeVo> getSearchByContentNotice(String search, int start, int end) throws DataAccessException;
	
	public List<VNoticeVo> getSearchByTitleNContentNotice(String search, int start, int end) throws DataAccessException;
	
	public int getAllCount() throws DataAccessException;
	
	public int getAllCountByTitle(String search) throws DataAccessException;
	
	public int getAllCountByContent(String search) throws DataAccessException;
	
	public int getAllCountById(String search) throws DataAccessException;
	
	public int getAllCountByTitleNContent(String search) throws DataAccessException;
}
