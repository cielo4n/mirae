package com.nmom.soap.svc.board.notice;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.notice.VNoticeVo;

public interface IVNoticeSvc {
	
	public List<VNoticeVo> getAllNotice(int block, int allPages);
	
	public List<VNoticeVo> getSearchByTitleNotice(String search, int block, int allPages);
	
	public List<VNoticeVo> getSearchByContentNotice(String search, int block, int allPages);
	
	public List<VNoticeVo> getSearchByIdNotice(String search, int block, int allPages);
	
	public List<VNoticeVo> getSearchByTitleNContentNotice(String search, int block, int allPages);

	public int getAllCount();
	
	public int getAllCountByTitle(String search);
	
	public int getAllCountByContent(String search);
	
//	public int getAllCountById(String search);
	
	public int getAllCountByTitleNContent(String search);
}
