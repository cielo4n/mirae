package com.nmom.soap.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nmom.soap.S;
import com.nmom.soap.data.model.board.event.EventVo;
import com.nmom.soap.data.model.board.event.Event_reVo;
import com.nmom.soap.svc.board.event.IEventSvc;
import com.nmom.soap.svc.board.event.IEvent_reSvc;
import com.nmom.soap.svc.member.IBoardAccessSvc;

@Controller
public class EventController {
	
	IEventSvc eventSvc;
	IEvent_reSvc eventReSvc;
	IBoardAccessSvc boardAccessSvc;
	
	public void setEventSvc(IEventSvc eventSvc) {
		this.eventSvc = eventSvc;
	}
	public void setEventReSvc(IEvent_reSvc eventReSvc) {
		this.eventReSvc = eventReSvc;
	}
	public void setBoardAccessSvc(IBoardAccessSvc boardAccessSvc) {
		this.boardAccessSvc = boardAccessSvc;
	}
	
	
	
	/////////////////////////////// 사용자 페이지////////////////////////////////////////////////////////////////
	// 이벤트 리스트 with 검색기능
	@RequestMapping(value ="/board/event.nm", method=RequestMethod.GET)
	public ModelAndView board_event(HttpServletRequest req,
									@RequestParam(value="page", defaultValue="1") int page){
		Map<String, Object> map = new HashMap<>();
		List<EventVo> e_list =null;
		String search = req.getParameter("search");
		String type = req.getParameter("by");
		
		
		if(search!=null){
			switch (type) {
			case "제목":
				e_list = eventSvc.getEvents_by_title(search);
				map.put("e_list", e_list);
				return new ModelAndView("board/event/b_event", map);
				
			case "내용":
				e_list = eventSvc.getEvents_by_content(search);
				map.put("e_list", e_list);
				return new ModelAndView("board/event/b_event", map);
				
			case "제목+내용":
				e_list = eventSvc.getEvents_by_title_n_content(search);
				map.put("e_list", e_list);
				return new ModelAndView("board/event/b_event", map);
			}
		}
		int size = eventSvc.getEventList().size();
		int total = (int)Math.ceil(((double)size/S.PAGE_LIMIT));
		e_list = eventSvc.getEventList(page, size);
		map.put("e_list", e_list);
		map.put("total_page", total);
		map.put("page", page);
		
		return new ModelAndView("board/event/b_event", map);
	}
	
	
	// 읽기 페이지
	@RequestMapping(value ="/board/event_read.nm", method=RequestMethod.GET)
	public ModelAndView board_event_r(HttpServletRequest req, 
									HttpSession se,
									@RequestParam(value="r") int r,	// 이벤트no
									@RequestParam(value="rn") int rn,	// 이벤트 RowNom
									@RequestParam(value="d") int d){	// 이벤트 리플 넘버 (삭제시 이용)
		Map<String, Object> map = new HashMap<>();
		
		// 삭제값에 리플 번호 && 작성자 일치시 삭제

		if(d != 0 ){
			String re_writer = eventReSvc.getOneRe(d).getMem_id();
			String login = (String)se.getAttribute(S.SESSION_LOGIN);
			
			if(re_writer.equals(login)){  eventReSvc.removeRe(d);  }
		}
		
		// 조회수 증가
		eventSvc.addReadCount(r);
		// 이벤트 내용 불러오기
		EventVo event = eventSvc.getOneEvent(r);
		event.setEvt_rnum(rn);	// RowNum
		map.put("con", event);
		// 댓글 내용 불러오기
		List<Event_reVo> event_re = eventReSvc.getEventRe(r);
		map.put("re", event_re);
		// 총 페이지수 확인
		int total = eventSvc.getEventList().size();
		map.put("total_page", total);
		
		return new ModelAndView("board/event/b_event", map);
	}
	
	// 이전글/다음글
	@RequestMapping(value ="/board/event_read.nm", method=RequestMethod.GET, params="next=y")
	public ModelAndView board_event_r_prev(HttpServletRequest req,
										@RequestParam(value="r") int r){
		Map<String, Object> map = new HashMap<>();
		
		EventVo event = eventSvc.getOneEventByRn(r);
		int e_no = event.getEvent_no();
		
		// 조회수 증가
		eventSvc.addReadCount(e_no);
		map.put("con", event);
		// 댓글 내용 불러오기
		List<Event_reVo> event_re = eventReSvc.getEventRe(e_no);
		map.put("re", event_re);
		// 총 페이지수 확인
		int total = eventSvc.getEventList().size();
		map.put("total_page", total);
		
		return new ModelAndView("board/event/b_event", map);
	}
	
	// 게시글 쓰기 -> 리스트
	@RequestMapping(value ="/board/event_write.nm", method=RequestMethod.POST)
	public ModelAndView board_event_w(HttpServletRequest req,
									HttpSession se,
									@RequestParam(value="title")String title,
									@RequestParam(value="event_content") String event_content,
									@RequestParam(value="no") int no,
									@RequestParam(value="page", defaultValue="1") int page){
		// event_no가 0이 아니면 수정
		if(no !=0 ){
			System.out.println(eventSvc.editEvent(new EventVo().editform(no, title, event_content)));
		}else{
		// event_no가 0이면 새 글쓰기
		String id = (String)se.getAttribute(S.SESSION_LOGIN);
		System.out.println(eventSvc.addEvent(new EventVo().writeform(title, event_content, id)));
		}
		// 이벤트 리스트 불러오기
		Map<String, Object> map = new HashMap<>();
		int size = eventSvc.getEventList().size();
		int total = (int)Math.ceil(((double)size/S.PAGE_LIMIT));
		List<EventVo> e_list = eventSvc.getEventList(page, total);
		map.put("e_list", e_list);
		map.put("total_page", total);
		map.put("page", page);
		
		return new ModelAndView("board/event/b_event", map);
	}
	
	// 리플 쓰기 -> 읽기페이지
	@RequestMapping(value="/board/event_reply.nm", method=RequestMethod.POST)
	public ModelAndView board_event_w_re(HttpServletRequest req,
										HttpSession se,
										@RequestParam(value="r") int r,
										@RequestParam(value="re_content") String re_content){
		//세션에 아이디 값 불러오기
		String id = (String)se.getAttribute(S.SESSION_LOGIN);
		// 글쓰기
		System.out.println(eventReSvc.addRe(new Event_reVo().writeform(r, re_content, id)));
		
		// 이벤트 내용 불러오기
		Map<String, Object> map = new HashMap<>();
		EventVo event = eventSvc.getOneEvent(r);
		event.setEvt_rnum(r);	// RowNum
		map.put("con", event);
		// 댓글 내용 불러오기
		List<Event_reVo> event_re = eventReSvc.getEventRe(r);
		map.put("re", event_re);
				
		return new ModelAndView("board/event/b_event", map);
	}
	
	// 수정페이지 불러오기 ->글쓰기 페이지
	@RequestMapping(value="/board/event_edit.nm", method=RequestMethod.POST)
	public ModelAndView board_event_edit_form(HttpServletRequest req,
											@RequestParam(value="title") String title,
											@RequestParam(value="content") String content,
											@RequestParam(value="no") int no ){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("e", new EventVo().editform(no, title, content));
		
		return new ModelAndView("board/event/b_event", map);
	}
	
	// 게시글 삭제
	@RequestMapping(value="/board/event_del.nm", method=RequestMethod.GET)
	public String board_event_delete(HttpServletRequest req,
									@RequestParam(value="d") int d){
		System.out.println(d);
		eventSvc.removeEvent(d);
		return "redirect:/board/event.nm";
	}
	
	
	
	
	
	
	
	/////////////////////////////// 관리자페이지////////////////////////////////////////////////////////////////
	// 이벤트 리스트 with 검색기능
	@RequestMapping(value ="/admin/board/event.nm", method=RequestMethod.GET)
	public ModelAndView a_board_event(HttpServletRequest req,
									HttpSession se,
									@RequestParam(value="page", defaultValue="1")int page ){
		Map<String, Object> map = new HashMap<>();
		List<EventVo> e_list =null;
		String search = req.getParameter("search");
		String type = req.getParameter("by");
		
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		if(search!=null){
			switch (type) {
			case "제목":
				e_list = eventSvc.getEvents_by_title(search);
				map.put("e_list", e_list);
				return new ModelAndView("admin/board/event/a_event", map);
				
			case "내용":
				e_list = eventSvc.getEvents_by_content(search);
				map.put("e_list", e_list);
				return new ModelAndView("admin/board/event/a_event", map);
				
			case "제목+내용":
				e_list = eventSvc.getEvents_by_title_n_content(search);
				map.put("e_list", e_list);
				return new ModelAndView("admin/board/event/a_event", map);
			}
		}
		
		int size = eventSvc.getEventList().size();
		int total = (int)Math.ceil(((double)size/S.PAGE_LIMIT));
		e_list = eventSvc.getEventList(page, size);
		map.put("e_list", e_list);
		map.put("total_page", total);
		map.put("page", page);
		
		return new ModelAndView("admin/board/event/a_event", map);
	}
	
	// 읽기 페이지
	@RequestMapping(value ="/admin/board/event_read.nm", method=RequestMethod.GET)
	public ModelAndView a_board_event_r(HttpServletRequest req, 
									HttpSession se,
									@RequestParam(value="r") int r,	// 이벤트no
									@RequestParam(value="rn") int rn,	// 이벤트 RowNom
									@RequestParam(value="d") int d){	// 이벤트 리플 넘버 (삭제시 이용)
		Map<String, Object> map = new HashMap<>();
		
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}

		if(d != 0){
			eventReSvc.removeRe(d);
		}

		// 조회수 증가
		eventSvc.addReadCount(r);
		// 이벤트 내용 불러오기
		EventVo event = eventSvc.getOneEvent(r);
		event.setEvt_rnum(rn);	// RowNum
		map.put("con", event);
		// 댓글 내용 불러오기
		List<Event_reVo> event_re = eventReSvc.getEventRe(r);
		map.put("re", event_re);
		// 총 페이지수 확인
		int total = eventSvc.getEventList().size();
		map.put("total_page", total);
		
		return new ModelAndView("admin/board/event/a_event", map);
	}
	
	
	// 이전글/다음글
	@RequestMapping(value ="/admin/board/event_read.nm", method=RequestMethod.GET, params="next=y")
	public ModelAndView a_board_event_r_prev(HttpServletRequest req,
										@RequestParam(value="r") int r){
		Map<String, Object> map = new HashMap<>();
		
		EventVo event = eventSvc.getOneEventByRn(r);
		int e_no = event.getEvent_no();
		
		// 조회수 증가
		eventSvc.addReadCount(e_no);
		map.put("con", event);
		// 댓글 내용 불러오기
		List<Event_reVo> event_re = eventReSvc.getEventRe(e_no);
		map.put("re", event_re);
		// 총 페이지수 확인
		int total = eventSvc.getEventList().size();
		map.put("total_page", total);
		
		return new ModelAndView("admin/board/event/a_event", map);
	}
	
	// 게시글 쓰기 -> 리스트
		@RequestMapping(value ="admin/board/event_write.nm", method=RequestMethod.POST)
		public ModelAndView a_board_event_w(HttpServletRequest req,
										HttpSession se,
										@RequestParam(value="title")String title,
										@RequestParam(value="event_content") String event_content,
										@RequestParam(value="no") int no,
										@RequestParam(value="page", defaultValue="1") int page){
			Map<String, Object> map = new HashMap<>();
			Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
			if(isAdmin==null || !isAdmin.booleanValue()){
				map.put("err_msg", "관리자로 로그인 바랍니다.");
				return new ModelAndView("login/login", map);
			}
			
			// event_no가 0이 아니면 수정
			if(no !=0 ){
				System.out.println(eventSvc.editEvent(new EventVo().editform(no, title, event_content)));
			}else{
			// event_no가 0이면 새 글쓰기
			String id = (String)se.getAttribute(S.SESSION_LOGIN);
			System.out.println(eventSvc.addEvent(new EventVo().writeform(title, event_content, id)));
			}
			// 이벤트 리스트 불러오기
			int size = eventSvc.getEventList().size();
			int total = (int)Math.ceil(((double)size/S.PAGE_LIMIT));
			List<EventVo> e_list = eventSvc.getEventList(page, size);
			map.put("e_list", e_list);
			map.put("total_page", total);
			map.put("page", page);
			
			return new ModelAndView("admin/board/event/a_event", map);
		}
		
		// 리플 쓰기 -> 읽기페이지
		@RequestMapping(value="admin/board/event_reply.nm", method=RequestMethod.POST)
		public ModelAndView a_board_event_w_re(HttpServletRequest req,
											HttpSession se,
											@RequestParam(value="r") int r,
											@RequestParam(value="re_content") String re_content){
			//세션에 아이디 값 불러오기
			String id = (String)se.getAttribute(S.SESSION_LOGIN);
			// 글쓰기
			System.out.println(eventReSvc.addRe(new Event_reVo().writeform(r, re_content, id)));
			
			// 이벤트 내용 불러오기
			Map<String, Object> map = new HashMap<>();
			EventVo event = eventSvc.getOneEvent(r);
			event.setEvt_rnum(r);	// RowNum
			map.put("con", event);
			// 댓글 내용 불러오기
			List<Event_reVo> event_re = eventReSvc.getEventRe(r);
			map.put("re", event_re);
					
			return new ModelAndView("admin/board/event/a_event", map);
		}
		
		// 수정페이지 불러오기 ->글쓰기 페이지
		@RequestMapping(value="admin/board/event_edit.nm", method=RequestMethod.POST)
		public ModelAndView a_board_event_edit_form(HttpServletRequest req,
												HttpSession se,
												@RequestParam(value="title") String title,
												@RequestParam(value="content") String content,
												@RequestParam(value="no") int no ){
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
			if(isAdmin==null || !isAdmin.booleanValue()){
				map.put("err_msg", "관리자로 로그인 바랍니다.");
				return new ModelAndView("login/login", map);
			}
			
			map.put("e", new EventVo().editform(no, title, content));
			
			return new ModelAndView("admin/board/event/a_event", map);
		}
		
		// 게시글 삭제
		@RequestMapping(value="admin/board/event_del.nm", method=RequestMethod.GET)
		public String a_board_event_delete(HttpServletRequest req,
										@RequestParam(value="d") int d){
			System.out.println(d);
			eventSvc.removeEvent(d);
			return "redirect:/admin/board/event.nm";
		}

}
