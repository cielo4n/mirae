package com.nmom.soap.data.dao.board.notice;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.notice.NoticeVo;


public interface INoticeDao {

	public NoticeVo getNotice(int notice_no) throws DataAccessException;
	
	public int addNotice(NoticeVo notice) throws DataAccessException;
	
	public int editNotice(NoticeVo notice) throws DataAccessException;
	
	public int removeNotice(int notice_no) throws DataAccessException;

	public int incrementHit(int notice_no);

	public int getPrevNoticeNo(int notice_no);

	public int getNextNoticeNo(int notice_no);
}
