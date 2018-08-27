package com.nmom.soap.svc.board.notice;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.dao.board.notice.INoticeReDao;
import com.nmom.soap.data.model.board.notice.NoticeReVo;

public class NoticeReSvcImpl implements INoticeReSvc {

	private INoticeReDao noticeReDao;
	
	@Override
	public List<NoticeReVo> getAllNoticeRe(int notice_no) {
		List<NoticeReVo> list = this.noticeReDao.getAllNoticeRe(notice_no);
		return (list != null || list.size() > 0) ? list : null;
	}

	@Override
	public int addNoticeRe(NoticeReVo notice_re) {
		int r = this.noticeReDao.addNoticeRe(notice_re);
		return (r == 1)? r : -1;
	}

	@Override
	public int editNoticeRe(NoticeReVo notice_re) {
		int r = this.noticeReDao.editNoticeRe(notice_re);
		return (r == 1)? r : -1;
	}

	@Override
	public int removeNoticeRe(int notice_re_no, String mem_id) {
		int r = this.noticeReDao.removeNoticeRe(notice_re_no, mem_id);
		return (r == 1)? r : -1;
	}

	
	public void setNoticeReDao(INoticeReDao noticeReDao) {
		this.noticeReDao = noticeReDao;
	}

	@Override
	public NoticeReVo getOneNoticeRe(int notice_re_no) {
		return this.noticeReDao.getOneNoticeRe(notice_re_no);
	}

}
