package com.nmom.soap.svc.board.notice;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.notice.NoticeVo;


public interface INoticeSvc {

	// 1. 공지사항 상세보기
	public NoticeVo getNotice(int notice_no);
	
	// 2. 공지사항 쓰기
	public int addNotice(NoticeVo notice);
	
	// 3. 공지사항 수정
	public int editNotice(NoticeVo notice);
	
	// 4. 공지사항 삭제
	public int removeNotice(int notice_no);

	public int incrementHit(int notice_no);

	public int getPrevNoticeNo(int notice_no);

	public int getNextNoticeNo(int notice_no);
}
