package com.nmom.soap.svc.board.notice;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.dao.board.notice.INoticeDao;
import com.nmom.soap.data.model.board.notice.NoticeVo;

public class NoticeSvcImpl implements INoticeSvc {

	private INoticeDao noticeDao;
	

	public void setNoticeDao(INoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@Override
	public NoticeVo getNotice(int notice_no) {
		System.out.println("노티스 서비스 notice_no"+notice_no);
		NoticeVo no = this.noticeDao.getNotice(notice_no);
		return (no != null) ? no : null;
	}

	@Override
	public int addNotice(NoticeVo notice) {
		int r = this.noticeDao.addNotice(notice);
		return (r == 1)? r : -1;
	}

	@Override
	public int editNotice(NoticeVo notice) {
		int r = this.noticeDao.editNotice(notice);
		return (r == 1)? r : -1;
	}

	@Override
	public int removeNotice(int notice_no) {
		int r = this.noticeDao.removeNotice(notice_no);
		return (r == 1)? r : -1;
	}

	@Override
	public int incrementHit(int notice_no) {
		return this.noticeDao.incrementHit(notice_no);
	}

	@Override
	public int getPrevNoticeNo(int notice_no) {
		return this.noticeDao.getPrevNoticeNo(notice_no);
	}

	@Override
	public int getNextNoticeNo(int notice_no) {
		// TODO Auto-generated method stub
		return this.noticeDao.getNextNoticeNo(notice_no);
	}



}
