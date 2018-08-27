package com.nmom.soap.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
import com.nmom.soap.data.model.board.notice.NoticeReVo;
import com.nmom.soap.data.model.board.notice.NoticeVo;
import com.nmom.soap.data.model.board.notice.VNoticeVo;
import com.nmom.soap.svc.board.notice.INoticeReSvc;
import com.nmom.soap.svc.board.notice.INoticeSvc;
import com.nmom.soap.svc.board.notice.IVNoticeSvc;

@Controller
public class NoticeController {

	private INoticeSvc noticeSvc;
	private INoticeReSvc noticeReSvc;
	private IVNoticeSvc vNoticeSvc;
	
	public void setNoticeSvc(INoticeSvc noticeSvc) {
		this.noticeSvc = noticeSvc;
	}
	public void setNoticeReSvc(INoticeReSvc noticeReSvc) {
		this.noticeReSvc = noticeReSvc;
	}
	public void setVNoticeSvc(IVNoticeSvc vNoticeSvc) {
		this.vNoticeSvc = vNoticeSvc;
	}
	
	//공지사항 리스트(회원)
	@RequestMapping (value="/board/notice.nm", method=RequestMethod.GET)
	public ModelAndView getAllNoticeM(HttpServletRequest req,
			@RequestParam(value="ab", required=false) String allBlock,
			@RequestParam(value="nb", required=false) String nowBlock,
			@RequestParam(value="k", required=false) String k,
			@RequestParam(value="s", required=false) String s){
		
		
		String search = null;
		String kind = null;
		if(s != null && !s.isEmpty() && !s.equals(""))
		try {
			
			kind = URLDecoder.decode(k, "UTF-8");
			search = URLDecoder.decode(s, "UTF-8");
			System.out.println(kind+search);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//블럭은 페이지 10개씩의 단위 첫페이지는 무조건 1
		int block = 1;
		
		//블럭 갯수
		int blockNums = 1;
		
		//전체 페이지 수
		int allPages = 0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if( nowBlock != null && !nowBlock.isEmpty() && !nowBlock.equals("")){
			try{
				block = Integer.parseInt(nowBlock);
			}catch(NumberFormatException ne){
				ne.printStackTrace();
			}	
		}
		
		if( search != null){
			switch(kind){
			case "제목":
				allPages = vNoticeSvc.getAllCountByTitle(search);
				List<VNoticeVo> tList = this.vNoticeSvc.getSearchByTitleNotice(search, block, allPages);
				
				if(allPages > 0)
				blockNums = (int)Math.ceil((double)allPages/S.PAGE_LIMIT);
			
				map.put("ab", blockNums);
				map.put("nb", block);
				map.put("no_list", tList);
				return new ModelAndView("/board/notice/b_notice", map);
				
			case "내용" :
				allPages = vNoticeSvc.getAllCountByContent(search);
				List<VNoticeVo> cList = this.vNoticeSvc.getSearchByContentNotice(search, block, allPages);
				
				if(allPages > 0)
				blockNums = (int)Math.ceil((double)allPages/S.PAGE_LIMIT);
			
				map.put("ab", blockNums);
				map.put("nb", block);
				map.put("no_list", cList);
				return new ModelAndView("/board/notice/b_notice", map);
				
			case "제목+내용" :
				allPages = vNoticeSvc.getAllCountByTitleNContent(search);
				List<VNoticeVo> tcList = this.vNoticeSvc.getSearchByTitleNContentNotice(search, block, allPages);
				
				if(allPages > 0)
				blockNums = (int)Math.ceil((double)allPages/S.PAGE_LIMIT);
			
				map.put("ab", blockNums);
				map.put("nb", block);
				map.put("no_list", tcList);
				return new ModelAndView("/board/notice/b_notice", map);
			}
		}
		else{
			allPages = vNoticeSvc.getAllCount();
			List<VNoticeVo> list = this.vNoticeSvc.getAllNotice(block, allPages);
			
			if(allPages > 0)
			blockNums = (int)Math.ceil((double)allPages/S.PAGE_LIMIT);
			map.put("ab", blockNums);
			map.put("nb", block);
			map.put("no_list", list);
			return new ModelAndView("/board/notice/b_notice", map);
		}
		return new ModelAndView("/board/notice/b_notice");
	}
	
	//공지사항 글 상세보기/댓글 삭제(회원)
	@RequestMapping (value="/board/notice_read.nm", method=RequestMethod.GET)
	public ModelAndView getNoticeM(
			HttpServletRequest req,
			HttpSession ses,
			@RequestParam(value="r", required=false) int notice_no,
			@RequestParam(value="d", required=false) int notice_re_no){
		
		int n = 0;
		if(notice_re_no != 0 && 
				ses.getAttribute(S.SESSION_LOGIN).equals(noticeReSvc.getOneNoticeRe(notice_re_no).getMem_id())){
			n = this.noticeReSvc.removeNoticeRe(notice_re_no, (String)ses.getAttribute(S.SESSION_LOGIN));
			if(n > 0) System.out.println("댓글 삭제 성공!"); 
		}
		
		int r = this.noticeSvc.incrementHit(notice_no);
		NoticeVo notice = this.noticeSvc.getNotice(notice_no);
		
		if(notice != null){
			Map<String, Object> map = new HashMap<>();
			List<NoticeReVo> reply = this.noticeReSvc.getAllNoticeRe(notice_no);
			int prev_notice = this.noticeSvc.getPrevNoticeNo(notice_no);
			if( prev_notice > 0 ) map.put("prev", prev_notice);
			
			int next_notice = this.noticeSvc.getNextNoticeNo(notice_no);
			if( next_notice > 0 ) map.put("next", next_notice);
			
			if(reply.size() > 0){
				map.put("re_list", reply);
			}
			map.put("r", notice_no);
			map.put("d", notice_re_no);
			map.put("no", notice);
			return new ModelAndView("/board/notice/b_notice", map);
		}
		
		else{	
			return new ModelAndView("/board/notice/b_notice");
		}
	}
	
	//공지사항 댓글 달기(회원)
	@RequestMapping (value="/board/add_notice_reply_proc.nm", method=RequestMethod.POST)
	public ModelAndView addNoticeReplyM(HttpServletRequest req,
			HttpSession ses,
			@RequestParam(value="r", required=false) int notice_no,
			@RequestParam(value="re_content", required=false) String re_content){
		
		String content = null;
		if(re_content != null && !re_content.isEmpty() && !re_content.equals(""))
			try {
				content = URLDecoder.decode(re_content, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int r = 0;
			
			if( ses.getAttribute(S.SESSION_LOGIN) != null && content != null)
		{
			r = this.noticeReSvc.addNoticeRe(
				new NoticeReVo(content, 
						notice_no, 
						(String)ses.getAttribute(S.SESSION_LOGIN)));
		
		}
		//게시글 다시 가져오는 부분
		NoticeVo notice = this.noticeSvc.getNotice(notice_no);
		if(notice != null){
			Map<String, Object> map = new HashMap<>();
			List<NoticeReVo> reply = this.noticeReSvc.getAllNoticeRe(notice_no);
			int prev_notice = this.noticeSvc.getPrevNoticeNo(notice_no);
			if( prev_notice > 0 ) map.put("prev", prev_notice);
			
			int next_notice = this.noticeSvc.getNextNoticeNo(notice_no);
			if( next_notice > 0 ) map.put("next", next_notice);
			
			if(reply.size() > 0){
				map.put("re_list", reply);
			}
			map.put("r", notice_no);
			map.put("no", notice);
			return new ModelAndView("/board/notice/b_notice", map);
		}
		
		else{	
			return new ModelAndView("/board/notice/b_notice");
		}
	}
	
	
	

	
	
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------	
//--------------------------------ADMIN--------------------------------------
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------	

	//공지사항 리스트(어드민)
	@RequestMapping (value="admin/board/notice.nm", method=RequestMethod.GET)
	public ModelAndView getAllNoticeA(HttpServletRequest req,
			HttpSession ses,
			@RequestParam(value="ab", required=false) String allBlock,
			@RequestParam(value="nb", required=false) String nowBlock,
			@RequestParam(value="k", required=false) String k,
			@RequestParam(value="s", required=false) String s){
		
		//블럭은 페이지 10개씩의 단위 첫페이지는 무조건 1
		
		//어드민이 투루가 아닐경우 프론트 페이지로 ㄱㄱ
//		if(ses.getAttribute("admin") == null || !ses.getAttribute("admin").equals("true")){
//			return new ModelAndView("index");
//		}
		
		String search = null;
		String kind = null;
		if(s != null && !s.isEmpty() && !s.equals(""))
		try {
			
			kind = URLDecoder.decode(k, "UTF-8");
			search = URLDecoder.decode(s, "UTF-8");
			System.out.println(kind+search);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int block = 1;
		
		//블럭 갯수
		int blockNums = 1;
		
		//전체 페이지 수
		int allPages = 0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 관리자여부 확인
		Boolean isAdmin = ((Boolean)ses.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		if( nowBlock != null && !nowBlock.isEmpty() && !nowBlock.equals("")){
			try{
				block = Integer.parseInt(nowBlock);
			}catch(NumberFormatException ne){
				ne.printStackTrace();
			}
			
		}
		if( search != null){
			switch(kind){
			case "제목":
				allPages = vNoticeSvc.getAllCountByTitle(search);
				List<VNoticeVo> tList = this.vNoticeSvc.getSearchByTitleNotice(search, block, allPages);
				
				if(allPages > 0)
				blockNums = (int)Math.ceil((double)allPages/S.PAGE_LIMIT);
			
				map.put("ab", blockNums);
				map.put("nb", block);
				map.put("no_list", tList);
				return new ModelAndView("admin/board/notice/a_notice", map);
				
			case "내용" :
				allPages = vNoticeSvc.getAllCountByContent(search);
				List<VNoticeVo> cList = this.vNoticeSvc.getSearchByContentNotice(search, block, allPages);
				
				if(allPages > 0)
				blockNums = (int)Math.ceil((double)allPages/S.PAGE_LIMIT);
			
				map.put("ab", blockNums);
				map.put("nb", block);
				map.put("no_list", cList);
				return new ModelAndView("admin/board/notice/a_notice", map);
				
			case "제목+내용" :
				allPages = vNoticeSvc.getAllCountByTitleNContent(search);
				List<VNoticeVo> tcList = this.vNoticeSvc.getSearchByTitleNContentNotice(search, block, allPages);
				
				if(allPages > 0)
				blockNums = (int)Math.ceil((double)allPages/S.PAGE_LIMIT);
			
				map.put("ab", blockNums);
				map.put("nb", block);
				map.put("no_list", tcList);
				return new ModelAndView("admin/board/notice/a_notice", map);
			}
		}
		else{
			allPages = vNoticeSvc.getAllCount();
			List<VNoticeVo> list = this.vNoticeSvc.getAllNotice(block, allPages);
			
			if(allPages > 0)
			blockNums = (int)Math.ceil((double)allPages/S.PAGE_LIMIT);
		
			map.put("ab", blockNums);
			map.put("nb", block);
			map.put("no_list", list);
			return new ModelAndView("admin/board/notice/a_notice", map);
		}
		return new ModelAndView("admin/board/notice/a_notice");
	}
	
	//공지사항 글 상세보기/댓글 삭제(어드민)
		@RequestMapping (value="/admin/board/notice_read.nm", method={RequestMethod.GET,RequestMethod.POST})
		public ModelAndView getNoticeA(
				HttpServletRequest req,
				HttpSession ses,
				@RequestParam(value="r", required=false) int notice_no,	
				@RequestParam(value="d", required=false) int notice_re_no){
			Map<String, Object> map = new HashMap<>();
			
			// 관리자 여부 확인
			Boolean isAdmin = ((Boolean)ses.getAttribute(S.SESSION_ADMIN));
			if(isAdmin==null || !isAdmin.booleanValue()){
				map.put("err_msg", "관리자로 로그인 바랍니다.");
				return new ModelAndView("login/login", map);
			}
			
			int n = 0;
			if(notice_re_no != 0 ){
				n = this.noticeReSvc.removeNoticeRe(notice_re_no, (String)ses.getAttribute(S.SESSION_LOGIN));
				if(n > 0) System.out.println("댓글 삭제 성공!"); 
			}
			
			int r = this.noticeSvc.incrementHit(notice_no);
			NoticeVo notice = this.noticeSvc.getNotice(notice_no);
			
			if(notice != null){
				
				List<NoticeReVo> reply = this.noticeReSvc.getAllNoticeRe(notice_no);
				int prev_notice = this.noticeSvc.getPrevNoticeNo(notice_no);
				if( prev_notice > 0 ) map.put("prev", prev_notice);
				
				int next_notice = this.noticeSvc.getNextNoticeNo(notice_no);
				if( next_notice > 0 ) map.put("next", next_notice);
				
				if(reply.size() > 0){
					map.put("re_list", reply);
				}
				map.put("r", notice_no);
				
				map.put("no", notice);
				return new ModelAndView("/admin/board/notice/a_notice", map);
			}
			
			else{	
				return new ModelAndView("/admin/board/notice/a_notice");
			}
		}
	
	//공지사항 글 쓰기(등록/수정)(어드민)
	@RequestMapping (value="/admin/board/notice_write.nm", method=RequestMethod.POST)
	public ModelAndView writeNoticeA(HttpServletRequest req, 
			HttpSession ses, 
//			@RequestParam(value="file1", required=false) MultipartFile file1,
//			@RequestParam(value="file2", required=false) MultipartFile file2,
			@RequestParam(value="title", required=false) String t,
			@RequestParam(value="content", required=false) String c,
			@RequestParam(value="r", required=false) int notice_no) 
					throws IllegalStateException, IOException {
		String id = null;
		id = (String) ses.getAttribute(S.SESSION_LOGIN);
		Map<String, Object> map = new HashMap<>();
		String title = null;
		String content = null;
		
		// 관리자 여부 확인
		Boolean isAdmin = ((Boolean)ses.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		
		// 어드민으로 세션에 등록 되지 않으면 아무것도 못한다.
		if ((boolean) ses.getAttribute(S.SESSION_ADMIN) 
				&& id != null && !id.isEmpty() && !id.equals("")) {

			try {
				title = URLDecoder.decode(t, "UTF-8");
				content = URLDecoder.decode(c, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 파일 업로드 상대경로 배운 후 작업.
			/*
			 * final String UPLOAD_FOLDER =
			 * "C:\\spring-tool-suite-3.7.3\\_f5_sts\\FusionNoodle\\src\\main\\webapp\\resources\\img\\";
			 * String ori = file1.getOriginalFilename(); // 원본 파일 이름
			 * System.out.println("orifile => " + ori ); File realFile1 = new
			 * File(UPLOAD_FOLDER, "rm_"+ori); file1.transferTo(realFile1); //
			 * throws IllegalStateException, IOException
			 * 
			 * // 예외 없이... 정상 물리 파일 저장이 완료 되었다면? String ntc_attached_file1 =
			 * realFile1.getName();
			 */

			// 하나라도 빈 내용이면 업로드 안함
			if (title != null && !title.equals("") && content != null && !content.equals("")) {

				// notice_no이 1 보다 작은(0 같은) 경우는 공지사항 등록을 위한 것임
				if (notice_no < 1) {

					int r = this.noticeSvc.addNotice(new NoticeVo(title, content, null, null, id));

					if (r == 1) {
						System.out.println("공지사항 등록 성공!");

					} else
						System.out.println("공지사항 등록 실패!");
				}
				// 아닌 경우는 공지사항 수정을 위한 것임
				else {
					NoticeVo editNotice = new NoticeVo(notice_no, title, content, null, null,
							(String) ses.getAttribute(S.SESSION_LOGIN));
					int r = this.noticeSvc.editNotice(editNotice);

					if (r == 1)
						System.out.println("업데이트 성공");
					else
						System.out.println("업데이트 실패");
					
					//수정된 게시글 상세보기를 위한 객체
					NoticeVo notice = this.noticeSvc.getNotice(notice_no);

					if (notice != null) {
						
						List<NoticeReVo> reply = this.noticeReSvc.getAllNoticeRe(notice_no);
						int prev_notice = this.noticeSvc.getPrevNoticeNo(notice_no);
						if (prev_notice > 0)
							map.put("prev", prev_notice);

						int next_notice = this.noticeSvc.getNextNoticeNo(notice_no);
						if (next_notice > 0)
							map.put("next", next_notice);

						if (reply.size() > 0) {
							map.put("re_list", reply);
						}
						map.put("r", notice_no);

						map.put("no", notice);
						return new ModelAndView("/admin/board/notice/a_notice", map);
					}
				}
			}
		}
		// 기본으로 나올 리스트
		int block = 1;
		int allPages = 0;
		int blockNums = 0;

		allPages = vNoticeSvc.getAllCount();
		List<VNoticeVo> list = this.vNoticeSvc.getAllNotice(block, allPages);

		if (allPages > 0) {
			blockNums = (int) Math.ceil((double) allPages / S.PAGE_LIMIT);
		}
		map.put("ab", blockNums);
		map.put("nb", block);
		map.put("no_list", list);

		return new ModelAndView("admin/board/notice/a_notice", map);
	}
	
	//공지사항 글 수정하기(어드민)
	// 수정페이지 불러오기 ->글쓰기 페이지
	@RequestMapping(value="admin/board/notice_edit.nm", method=RequestMethod.POST)
	public ModelAndView editNoticeA(HttpServletRequest req,
			HttpSession ses,
			@RequestParam(value="title") String title,
			@RequestParam(value="content") String content,
			@RequestParam(value="r") int notice_no ){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 관리자 여부 확인
		Boolean isAdmin = ((Boolean)ses.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		map.put("no", new NoticeVo(notice_no, title, content, null, null));
		
		return new ModelAndView("admin/board/notice/a_notice", map);
	}
	
	//공지사항 글 삭제하기(어드민)
	@RequestMapping(value="admin/board/notice_delete.nm", method=RequestMethod.GET)
	public String removeNoticeA(HttpServletRequest req,
			HttpSession ses,
			@RequestParam(value="r") int notice_no){
		// 어드민으로 세션에 등록 되지 않으면 아무것도 못한다.
		if ((boolean) ses.getAttribute(S.SESSION_ADMIN)){
			int r = this.noticeSvc.removeNotice(notice_no);
			System.out.println("삭제 메소드 진입");
			if(r == 1) System.out.println("삭제 성공!");
			else System.out.println("삭제 실패!");
		}
		//기본 리스트
		return "redirect:notice.nm";
	}
	
	
	//공지사항 댓글 달기(어드민)
	@RequestMapping (value="admin/board/add_notice_reply_proc.nm", method=RequestMethod.POST)
	public ModelAndView addNoticeReplyA(HttpServletRequest req,
			HttpSession ses,
			@RequestParam(value="r", required=false) int notice_no,
			@RequestParam(value="re_content", required=false) String re_content){
		Map<String, Object> map = new HashMap<>();
		
		// 관리자 여부 확인
		Boolean isAdmin = ((Boolean)ses.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		String content = null;
		if(re_content != null && !re_content.isEmpty() && !re_content.equals(""))
		try {
			content = URLDecoder.decode(re_content, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int r = 0;
		
		if( ses.getAttribute(S.SESSION_LOGIN) != null && content != null)
		{
			r = this.noticeReSvc.addNoticeRe(
				new NoticeReVo(content, 
						notice_no, 
						(String)ses.getAttribute(S.SESSION_LOGIN)));
		
			System.out.println((r == 1) ? "리플 달기 성공" : "리플달기 실패");
		}
		//게시글 다시 가져오는 부분
		NoticeVo notice = this.noticeSvc.getNotice(notice_no);
		System.out.println("notice_no"+notice_no);
		System.out.println("notice_no"+notice);
		if(notice != null){
			
			List<NoticeReVo> reply = this.noticeReSvc.getAllNoticeRe(notice_no);
			int prev_notice = this.noticeSvc.getPrevNoticeNo(notice_no);
			if( prev_notice > 0 ) map.put("prev", prev_notice);
			
			int next_notice = this.noticeSvc.getNextNoticeNo(notice_no);
			if( next_notice > 0 ) map.put("next", next_notice);
			System.out.println("이전"+prev_notice+" 다음"+next_notice);
			
			if(reply.size() > 0){
				map.put("re_list", reply);
			}
			map.put("r", notice_no);
			map.put("no", notice);
			return new ModelAndView("admin/board/notice/a_notice", map);
		}
		
		else{	
			return new ModelAndView("admin/board/notice/a_notice");
		}
	}
	
}
