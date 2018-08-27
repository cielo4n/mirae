package com.nmom.soap.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.nmom.soap.S;
import com.nmom.soap.data.model.board.faq.FaqVo;
import com.nmom.soap.data.model.board.qna.VQnaQnaReVo;
import com.nmom.soap.svc.board.faq.IFaqSvc;

@Controller
public class FaqController {
	
	IFaqSvc faqSvc;

	public void setFaqSvc(IFaqSvc faqSvc) {
		this.faqSvc = faqSvc;
	}

	//FAQ 전체 목록 보여주기 페이지네이션
	@RequestMapping(value="/board/faq/{pp}/list.nm", method = RequestMethod.GET)
	public ModelAndView showFaqBoard(HttpServletRequest req, 
			@PathVariable(value="pp") int pp)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
		//오라클 rownum 의 start, end 계산
		int count = faqSvc.getFaqCount();
		int start = count - (S.PAGE_LIMIT * pp);
		int end = start + S.PAGE_LIMIT;
		
		List<FaqVo> faq_list = faqSvc.getAllFaq(start, end);
		
		//페이지수 계산
		int total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
		
		if(faq_list != null){
			map.put("faq_count", count);
			map.put("faq_list", faq_list);
			map.put("pp", pp);
			map.put("total", total_pages);
			
		}
		
		ModelAndView mav = new ModelAndView("board/faq/b_faq", map);
		return mav;
		
	}
	
	//FAQ 목록보기
	@RequestMapping(value="/board/faq.nm", method={RequestMethod.GET})
	public String boardFaq(HttpServletRequest req)
	{
		return "redirect:/board/faq/1/list.nm";
	}

	//FAQ 다음글 가기
	@RequestMapping(value="/board/faq/next/read.nm", method=RequestMethod.GET)
	public ModelAndView faqNextRead(HttpServletRequest req,
			@RequestParam(value="fr_no") String fr_no,
			@RequestParam(value="rn") String rn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		List<FaqVo> faq_list;
		int rownum;
		
		try{
			if(rn != null && fr_no!=null){
				rownum = Integer.parseInt(rn);
				faq_list = faqSvc.getAllFaq(rownum, rownum+1);
				
				if(faq_list.size() == 1){ //다음글 있음
					map.put("fr_no", faq_list.get(0).getFaq_no());
					map.put("rn", rownum+1);
					
				} else {
					map.put("fr_no", fr_no);
					map.put("rn", rownum);
					map.put("next_err", "t");
					System.out.println("다음글이 없습니다");
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("다음글 가려는데 정보 못받아옴");
			return new ModelAndView("redirect:/board/faq.nm", map);
		}
		
		return new ModelAndView("redirect:/board/faq/read.nm", map);
	}
	
	//FAQ 이전글 가기
	@RequestMapping(value="/board/faq/prev/read.nm", method=RequestMethod.GET)
	public ModelAndView faqPreviousRead(HttpServletRequest req,
			@RequestParam(value="fr_no") String fr_no,
			@RequestParam(value="rn") String rn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		List<FaqVo> faq_list;
		int rownum;
		
		try{
			if(rn != null && fr_no!=null){
				rownum = Integer.parseInt(rn);
				faq_list = faqSvc.getAllFaq(rownum-2, rownum-1);
				
				if(faq_list.size() == 1){ //이전글 있음
					map.put("fr_no", faq_list.get(0).getFaq_no());
					map.put("rn", rownum-1);
					
				} else {
					map.put("fr_no", fr_no);
					map.put("rn", rownum);
					map.put("prev_err", "t");
					System.out.println("이전글이 없습니다");
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("이전글 가려는데 정보 못받아옴");
			return new ModelAndView("redirect:/board/faq.nm", map);
		}
		
		return new ModelAndView("redirect:/board/faq/read.nm", map);
	}
	
	//FAQ 질문 검색 페이지네이션
	@RequestMapping(value ="/board/faq/{pp}/search.nm", method=RequestMethod.GET)
	public ModelAndView boardSearchFaq(HttpServletRequest req, 
			@PathVariable(value="pp") int pp,
			@RequestParam(value="sch") String sch,
			@RequestParam(value="kw", required=false) String kw){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<FaqVo> faq_list = null;
		int count = 0;
		int start = 0;
		int end = 0;
		int total_pages = 0;
		
		if(kw==null){
			kw="";
		}
		
		try {
			kw = URLDecoder.decode(kw, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			System.out.println("인코딩 문제 발생");
		}

		if(sch.equals("tt")){
			count = faqSvc.getSearchFaqTitleCount(kw);
			start = count - (S.PAGE_LIMIT * pp);
			end = start + S.PAGE_LIMIT;
			total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
			faq_list = faqSvc.searchFaqTitle(kw, start, end);
			
		}else if(sch.equals("con")){
			count = faqSvc.getSearchFaqContentCount(kw);
			start = count - (S.PAGE_LIMIT * pp);
			end = start + S.PAGE_LIMIT;
			total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
			faq_list = faqSvc.searchFaqContent(kw, start, end);
			
		}else if(sch.equals("ttcon")){
			count = faqSvc.getSearchFaqTitleNContentCount(kw);
			start = count - (S.PAGE_LIMIT * pp);
			end = start + S.PAGE_LIMIT;
			total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
			faq_list = faqSvc.searchFaqTitleNContent(kw, start, end);
		}
		
		if(faq_list != null){
			map.put("faq_count", count);
			map.put("faq_list", faq_list);
			map.put("pp", pp);
			map.put("total", total_pages);
		}
		
		ModelAndView mav = new ModelAndView("board/faq/b_faq", map);
		return mav;
	}

	//자주하는 질문 하나 읽기
	@RequestMapping(value="/board/faq/read.nm", method=RequestMethod.GET)
	public ModelAndView faqRead(HttpServletRequest req,
		@RequestParam(value="fr_no") String fr_no){
		Map<String,Object> map = new HashMap<String,Object>();

		int faqno;
		
		try{
			if(fr_no != null){
				faqno = Integer.parseInt(fr_no);
				FaqVo faq_vo = faqSvc.getOneFaq(faqno);
				
				if(faq_vo!=null){
					map.put("fvo", faq_vo);
					return new ModelAndView("/board/faq/b_faq", map);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("자주하는 질문 글 정보 받아오기 실패");
		}
		return new ModelAndView("redirect:/board/faq.nm", map);
		
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	
	//TODO
	
	//관리자 FAQ 전체 목록 보여주기 페이지네이션
	@RequestMapping(value="/admin/board/faq/{pp}/list.nm", method = RequestMethod.GET)
	public ModelAndView adminShowFaqBoard(HttpServletRequest req, HttpSession se,
			@PathVariable(value="pp") int pp)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
		// 관리자인지 확인
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}

		//오라클 rownum 의 start, end 계산
		int count = faqSvc.getFaqCount();
		int start = count - (S.PAGE_LIMIT * pp);
		int end = start + S.PAGE_LIMIT;
		
		List<FaqVo> faq_list = faqSvc.getAllFaq(start, end);
		
		//페이지수 계산
		int total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
		
		if(faq_list != null){
			map.put("faq_count", count);
			map.put("faq_list", faq_list);
			map.put("pp", pp);
			map.put("total", total_pages);
			
		}
		
		ModelAndView mav = new ModelAndView("admin/board/faq/a_faq", map);
		return mav;
		
	}
	
	//관리자 FAQ 목록보기
	@RequestMapping(value="/admin/board/faq.nm", method={RequestMethod.GET})
	public String adminBoardFaq(HttpServletRequest req)
	{
		return "redirect:/admin/board/faq/1/list.nm";
	}

	//관리자 FAQ 다음글 가기
	@RequestMapping(value="/admin/board/faq/next/read.nm", method=RequestMethod.GET)
	public ModelAndView adminFaqNextRead(HttpServletRequest req,
			@RequestParam(value="fr_no") String fr_no,
			@RequestParam(value="rn") String rn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		List<FaqVo> faq_list;
		int rownum;
		
		try{
			if(rn != null && fr_no!=null){
				rownum = Integer.parseInt(rn);
				faq_list = faqSvc.getAllFaq(rownum, rownum+1);
				
				if(faq_list.size() == 1){ //다음글 있음
					map.put("fr_no", faq_list.get(0).getFaq_no());
					map.put("rn", rownum+1);
					
				} else {
					map.put("fr_no", fr_no);
					map.put("rn", rownum);
					map.put("next_err", "t");
					System.out.println("다음글이 없습니다");
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("다음글 가려는데 정보 못받아옴");
			return new ModelAndView("redirect:/admin/board/faq.nm", map);
		}
		
		return new ModelAndView("redirect:/admin/board/faq/read.nm", map);
	}
	
	//관리자 FAQ 이전글 가기
	@RequestMapping(value="/admin/board/faq/prev/read.nm", method=RequestMethod.GET)
	public ModelAndView adminFaqPreviousRead(HttpServletRequest req,
			@RequestParam(value="fr_no") String fr_no,
			@RequestParam(value="rn") String rn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		List<FaqVo> faq_list;
		int rownum;
		
		try{
			if(rn != null && fr_no!=null){
				rownum = Integer.parseInt(rn);
				faq_list = faqSvc.getAllFaq(rownum-2, rownum-1);
				
				if(faq_list.size() == 1){ //이전글 있음
					map.put("fr_no", faq_list.get(0).getFaq_no());
					map.put("rn", rownum-1);
					
				} else {
					map.put("fr_no", fr_no);
					map.put("rn", rownum);
					map.put("prev_err", "t");
					System.out.println("이전글이 없습니다");
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("이전글 가려는데 정보 못받아옴");
			return new ModelAndView("redirect:/admin/board/faq.nm", map);
		}
		
		return new ModelAndView("redirect:/admin/board/faq/read.nm", map);
	}
	
	//관리자 FAQ 질문 검색 페이지네이션
	@RequestMapping(value ="/admin/board/faq/{pp}/search.nm", method=RequestMethod.GET)
	public ModelAndView adminBoardSearchFaq(HttpServletRequest req, 
			HttpSession se,
			@PathVariable(value="pp") int pp,
			@RequestParam(value="sch") String sch,
			@RequestParam(value="kw", required=false) String kw){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		// 관리자인지 확인
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}		
				
		List<FaqVo> faq_list = null;
		int count = 0;
		int start = 0;
		int end = 0;
		int total_pages = 0;
		
		if(kw==null){
			kw="";
		}
		
		try {
			kw = URLDecoder.decode(kw, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			System.out.println("인코딩 문제 발생");
		}

		if(sch.equals("tt")){
			count = faqSvc.getSearchFaqTitleCount(kw);
			start = count - (S.PAGE_LIMIT * pp);
			end = start + S.PAGE_LIMIT;
			total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
			faq_list = faqSvc.searchFaqTitle(kw, start, end);
			
		}else if(sch.equals("con")){
			count = faqSvc.getSearchFaqContentCount(kw);
			start = count - (S.PAGE_LIMIT * pp);
			end = start + S.PAGE_LIMIT;
			total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
			faq_list = faqSvc.searchFaqContent(kw, start, end);
			
		}else if(sch.equals("ttcon")){
			count = faqSvc.getSearchFaqTitleNContentCount(kw);
			start = count - (S.PAGE_LIMIT * pp);
			end = start + S.PAGE_LIMIT;
			total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
			faq_list = faqSvc.searchFaqTitleNContent(kw, start, end);
		}
		
		if(faq_list != null){
			map.put("faq_count", count);
			map.put("faq_list", faq_list);
			map.put("pp", pp);
			map.put("total", total_pages);
		}
		
		ModelAndView mav = new ModelAndView("admin/board/faq/a_faq", map);
		return mav;
	}

	//관리자 자주하는 질문 하나 읽기
	@RequestMapping(value="/admin/board/faq/read.nm", method=RequestMethod.GET)
	public ModelAndView adminFaqRead(HttpServletRequest req,
		@RequestParam(value="fr_no") String fr_no){
		Map<String,Object> map = new HashMap<String,Object>();

		int faqno;
		
		try{
			if(fr_no != null){
				faqno = Integer.parseInt(fr_no);
				FaqVo faq_vo = faqSvc.getOneFaq(faqno);
				
				if(faq_vo!=null){
					map.put("fvo", faq_vo);
					return new ModelAndView("/admin/board/faq/a_faq", map);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("자주하는 질문 글 정보 받아오기 실패");
		}
		return new ModelAndView("redirect:/admin/board/faq.nm", map);
		
	}
	
	// 자주하는 질문 추가하는 화면
	@RequestMapping(value="/admin/board/faq/add_form.nm", method=RequestMethod.GET)
	public ModelAndView prepareAddFaqForm(HttpServletRequest req)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fwa", true); //faq write add
		System.out.println("1");
		return new ModelAndView("admin/board/faq/a_faq", map);
	}
	
	// 자주하는 질문 추가하는 과정
	@RequestMapping(value="/admin/board/faq/add_proc.nm", method=RequestMethod.POST)
	public String addNewFaq(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="title", required=false) String title,
			@RequestParam(value="content", required=false) String content)
	{
		if(title == null || title.equals("")){
			title = "(제목없음)";
		}
		if(content == null || content.equals("")){
			content = "(내용없음)";
		}
		try{
		String loggedin = (String)ses.getAttribute("loggedin");
		int r = faqSvc.addFaq(title, content, loggedin);
			if(r!=1){
				System.out.println("글 등록 실패");
			}
		} catch(Exception e){
			System.out.println("자주하는질문 작성시 글정보, 아이디 받아오기 실패");
		}
		return "redirect:/admin/board/faq.nm";
	}
	

	// 자주하는 질문 글편집하는 화면
	@RequestMapping(value="/admin/board/faq/edit_form.nm", method=RequestMethod.GET)
	public ModelAndView prepareEditFaqForm(HttpServletRequest req,
			@RequestParam(value="fe_no") String fe_no){
		
		int faq_no;
		FaqVo faq_vo;
		
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(fe_no!=null){
				faq_no = Integer.parseInt(fe_no);
				faq_vo = faqSvc.getOneFaq(faq_no);
				map.put("fvo", faq_vo);
				map.put("fwe", true); //faq write edit
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("자주하는질문 글 편집 정보 받아오기 실패");
		}
		
		return new ModelAndView("admin/board/faq/a_faq", map);
	}
	
	// 자주하는질문 글편집 하는 과정
	@RequestMapping(value="/admin/board/faq/edit_proc.nm", method=RequestMethod.POST)
	public String editOldFaq(HttpServletRequest req,
			@RequestParam(value="fe_no", required=false) String fe_no,
			@RequestParam(value="title", required=false) String title,
			@RequestParam(value="content", required=false) String content)
	{
		int faq_no;

		if(title == null || title.equals("")){
			title = "(제목없음)";
		}
		if(content == null || content.equals("")){
			content = "(내용없음)";
		}
		
		try{
			if(fe_no!=null){
				faq_no = Integer.parseInt(fe_no);
				int r = faqSvc.editFaq(title, content, faq_no);
				
				if(r!=1){
					System.out.println("자주하는 질문 글 수정 실패");
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("자주하는 질문 글 편집 정보 받아오기 실패");
		}
		return "redirect:/admin/board/faq.nm";
	}
	
	// 자주하는 질문 글 삭제하는 과정
	@RequestMapping(value="/admin/board/faq/del_proc.nm", method=RequestMethod.GET)
	public String removeFaqProcess(HttpServletRequest req,
			@RequestParam(value="fd_no") String fd_no){
		int faq_no;
		try{
			if(fd_no!=null){
				faq_no = Integer.parseInt(fd_no);
				
				int r = faqSvc.removeFaq(faq_no); //선택된 글 삭제
				if(r!=1){
					System.out.println("글 삭제 실패");
					return "redirect:/admin/board/faq.nm";
				}
			}
		} catch(Exception e){
			System.out.println("글삭제 정보 받아오기 실패");
		}
		return "redirect:/admin/board/faq.nm";
	}
	
	
	/*

	//QNA 질문 검색 페이지네이션
	@RequestMapping(value ="/admin/board/qna/{pp}/search.nm", method=RequestMethod.GET)
	public ModelAndView adminBoardSearchQna(HttpServletRequest req, 
			HttpSession se,
			@PathVariable(value="pp") int pp,
			@RequestParam(value="sch") String sch,
			@RequestParam(value="kw", required=false) String kw){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		// 관리자인지 확인
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}		
		
		List<VQnaQnaReVo> qna_list = null;
		int count = 0;
		int start = 0;
		int end = 0;
		int total_pages = 0;
		
		if(kw==null){
			kw="";
		}
		
		try {
			kw = URLDecoder.decode(kw, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			System.out.println("인코딩 문제 발생");
		}

		if(sch.equals("tt")){
			count = vQnaQnareSvc.getSearchQnaTitleCount(kw);
			start = count - (S.PAGE_LIMIT * pp);
			end = start + S.PAGE_LIMIT;
			total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
			qna_list = vQnaQnareSvc.searchQnaTitle(kw, start, end);
			
		}else if(sch.equals("con")){
			count = vQnaQnareSvc.getSearchQnaContentCount(kw);
			start = count - (S.PAGE_LIMIT * pp);
			end = start + S.PAGE_LIMIT;
			total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
			qna_list = vQnaQnareSvc.searchQnaContent(kw, start, end);
			
		}else if(sch.equals("ttcon")){
			count = vQnaQnareSvc.getSearchQnaTitleNContentCount(kw);
			start = count - (S.PAGE_LIMIT * pp);
			end = start + S.PAGE_LIMIT;
			total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
			qna_list = vQnaQnareSvc.searchQnaTitleNContent(kw, start, end);
		}
		
		if(qna_list != null){
			map.put("qna_count", count);
			map.put("qna_list", qna_list);
			map.put("pp", pp);
			map.put("total", total_pages);
		}
		
		ModelAndView mav = new ModelAndView("admin/board/qna/a_qna", map);
		return mav;
	}
*/
}
