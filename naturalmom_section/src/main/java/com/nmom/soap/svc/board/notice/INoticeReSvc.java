package com.nmom.soap.svc.board.notice;

import java.util.List;

import com.nmom.soap.data.model.board.notice.NoticeReVo;
 

public interface INoticeReSvc {
	
	// 1. 리플 가져오기
	public List<NoticeReVo> getAllNoticeRe(int notice_no);
	// 2. 리플 쓰기
	public int addNoticeRe(NoticeReVo notice_re);
	
	// 3. 리플 수정
	public int editNoticeRe(NoticeReVo notice_re);
	
	// 4. 리플 삭제
	public int removeNoticeRe(int notice_re_no, String mem_id);
	
	public NoticeReVo getOneNoticeRe(int notice_re_no);
}
