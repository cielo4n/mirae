
package com.nmom.soap.svc.board.notice;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.S;
import com.nmom.soap.data.dao.board.notice.IVNoticeDao;
import com.nmom.soap.data.model.board.notice.VNoticeVo;

public class VNoticeSvcImpl implements IVNoticeSvc {

	private IVNoticeDao vNoticeDao;
	
	public void setVNoticeDao(IVNoticeDao vNoticeDao) {
		this.vNoticeDao = vNoticeDao;
	}

	
	@Override                         // 블록은 페이지 모음
	public List<VNoticeVo> getAllNotice(int block, int allPages) {
		int start = S.PAGE_LIMIT * (block-1) +1 ;
		int end = S.PAGE_LIMIT * block > allPages? allPages : S.PAGE_LIMIT * block;
		
		List<VNoticeVo> list = this.vNoticeDao.getAllNotice(start, end);
		return (list != null && list.size() > 0) ? list : null;
	}

	@Override
	public List<VNoticeVo> getSearchByTitleNotice(String search, int block, int allPages) {
		int start = 1; // 
		//모든 페이지는 1부터 시작
		for(int i = 1; i > block; i++){
			start+=S.PAGE_LIMIT;
		}
						//스타트에서 1 더했으므로 여기서 뺌
		int end = start + (S.PAGE_LIMIT-1);
		List<VNoticeVo> list = this.vNoticeDao.getSearchByTitleNotice(search, start, end);
		return (list != null && list.size() > 0) ? list : null;
	}

	@Override
	public List<VNoticeVo> getSearchByContentNotice(String search, int block, int allPages) {
		int start = 1; // 
		//모든 페이지는 1부터 시작
		for(int i = 1; i > block; i++){
			start+=S.PAGE_LIMIT;
		}
						//스타트에서 1 더했으므로 여기서 뺌
		int end = start + (S.PAGE_LIMIT-1);
		List<VNoticeVo> list = this.vNoticeDao.getSearchByContentNotice(search, start, end);
		return (list != null && list.size() > 0) ? list : null;
	}

	@Override
	public List<VNoticeVo> getSearchByIdNotice(String search, int block, int allPages) {

		return null;
	}

	@Override
	public List<VNoticeVo> getSearchByTitleNContentNotice(String search, int block, int allPages) {
		int start = 1; // 
		//모든 페이지는 1부터 시작
		for(int i = 1; i > block; i++){
			start+=S.PAGE_LIMIT;
		}
						//스타트에서 1 더했으므로 여기서 뺌
		int end = start + (S.PAGE_LIMIT-1);
		List<VNoticeVo> list = this.vNoticeDao.getSearchByTitleNContentNotice(search, start, end);
		return (list != null && list.size() > 0) ? list : null;
	}


	@Override
	public int getAllCount() {
		return this.vNoticeDao.getAllCount();
	}

	@Override
	public int getAllCountByTitle(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllCountByContent(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

/*	@Override
	public int getAllCountById(String search) {
		// TODO Auto-generated method stub
		return 0;
	}*/

	@Override
	public int getAllCountByTitleNContent(String search) {
		// TODO Auto-generated method stub
		return 0;
	}
}
