package com.nmom.soap.data.dao.board.event;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nmom.soap.data.model.board.event.EventVo;


public interface IEventDao {


	// 리스트
	List<EventVo> getAllEvents() throws DataAccessException;
	
	List<EventVo> getEventList() throws DataAccessException;
	List<EventVo> getEventList(int start, int end) throws DataAccessException;
	
	// 글읽기, 수정할 글 불러오기
	EventVo getOneEvent(int event_no) throws DataAccessException;
	EventVo getOneEventByRn(int evt_rnum) throws DataAccessException;
	
	// 검색
	List<EventVo> getEvents_by_title(String search) throws DataAccessException;
	List<EventVo> getEvents_by_content(String search) throws DataAccessException;
	List<EventVo> getEvents_by_title_n_content(String search) throws DataAccessException;
	
	// 글쓰기
	int addEvent(EventVo event) throws DataAccessException;

	// 글삭제
	int removeEvent(int event_no) throws DataAccessException;
	
	// 글수정
	int editEvent(EventVo event) throws DataAccessException;
	
	// 조회수 증가
	int addReadCount(int event_no) throws DataAccessException;
}
