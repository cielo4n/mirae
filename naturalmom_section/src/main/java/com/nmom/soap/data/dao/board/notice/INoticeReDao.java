package com.nmom.soap.data.dao.board.notice;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.notice.NoticeReVo;
 

public interface INoticeReDao {

	public List<NoticeReVo> getAllNoticeRe(int notice_no) throws DataAccessException;

	public int addNoticeRe(NoticeReVo notice_re) throws DataAccessException;
	
	public int editNoticeRe(NoticeReVo notice_re) throws DataAccessException;
	
	public int removeNoticeRe(int notice_re_no, String mem_id) throws DataAccessException;

	public NoticeReVo getOneNoticeRe(int notice_re_no);
}
