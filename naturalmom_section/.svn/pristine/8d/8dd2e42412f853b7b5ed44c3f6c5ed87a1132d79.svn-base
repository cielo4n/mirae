package com.nmom.soap.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nmom.soap.S;
import com.nmom.soap.data.model.board.review.ReviewVo;
import com.nmom.soap.data.model.board.review.Review_ReVo;
import com.nmom.soap.data.model.board.review.VReview_AdminVo;
import com.nmom.soap.svc.board.review.IReviewSvc;
import com.nmom.soap.svc.board.review.IReview_ReSvc;
import com.nmom.soap.svc.board.review.IVReview_AdminSvc;
import com.nmom.soap.svc.board.review.IVReview_FrontSvc;

@Controller
public class ReviewController
{
	IReviewSvc reviewSvc;
	IReview_ReSvc review_reSvc;
	IVReview_AdminSvc review_adminSvc;
	IVReview_FrontSvc review_frontSvc;
	
	public void setReviewSvc(IReviewSvc reviewSvc) 
	{
		this.reviewSvc = reviewSvc;
	}
	
	public void setReview_reSvc(IReview_ReSvc review_reSvc) 
	{
		this.review_reSvc = review_reSvc;
	}
	
	public void setReview_adminSvc(IVReview_AdminSvc review_adminSvc) 
	{
		this.review_adminSvc = review_adminSvc;
	}
	
	public void setReview_frontSvc(IVReview_FrontSvc review_frontSvc) 
	{
		this.review_frontSvc = review_frontSvc;
	}
	
	
//*********************************************************************************************관리자 페이지 영역	
	
	// 상품후기 목록
	@RequestMapping(value ="/admin/board/review.nm", method=RequestMethod.GET)
	public ModelAndView review_list(HttpServletRequest req, HttpSession session, 
			@RequestParam(value="page", defaultValue="1") int page)
	{
		Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (isAdmin!= null && isAdmin.booleanValue())
		{
			int all_reviews = review_adminSvc.getCountAllReviews();
		
			int all_pages = (int)(Math.ceil((double)all_reviews / S.PAGE_LIMIT));
			List<VReview_AdminVo> review_list = review_adminSvc.getAllList(page);
			map.put("rp", new Integer(page));
			map.put("rvw_list", review_list);
			map.put("all_pages", all_pages);
			
			return new ModelAndView("admin/board/review/a_review", map);
		}
		else	// 관리자 계정으로 로그인 하지 않았을 때
		{
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
	}
	
	// 검색 결과 표시
	@RequestMapping(value ="/admin/board/review_search.nm", method=RequestMethod.GET)
	public ModelAndView review_list_search(HttpServletRequest req, HttpSession session,
			@RequestParam(value="option", required=false) String option,
			@RequestParam(value="search", required=false) String search,
			@RequestParam(value="page", defaultValue="1") int page)
	{
		Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (isAdmin!= null && isAdmin.booleanValue())
		{
			// 인코딩 -> 디코딩 처리
			try {
				search = URLDecoder.decode(search, "UTF-8");
			} catch (UnsupportedEncodingException e) {e.printStackTrace();}
			
			int all_reviews = -1;
			int all_pages = 1;
			
			List<VReview_AdminVo> review_list = null;
	
			if(option.equals("title"))
			{
				review_list = review_adminSvc.getReviews_by_title(search, page);
				all_reviews = review_adminSvc.getCountReviewsByTitle(search);
				all_pages = (int)(Math.ceil((double)all_reviews / S.PAGE_LIMIT));
			}
			else if(option.equals("content"))
			{
				review_list = review_adminSvc.getReviews_by_content(search, page);
				all_reviews = review_adminSvc.getCountReviewsByContent(search);
				all_pages = (int)(Math.ceil((double)all_reviews / S.PAGE_LIMIT));
			}
			else if(option.equals("id"))
			{
				review_list = review_adminSvc.getReviews_by_id(search, page);
				all_reviews = review_adminSvc.getCountReviewsById(search);
				all_pages = (int)(Math.ceil((double)all_reviews / S.PAGE_LIMIT));
			}
			else if(option.equals("title_n_content"))
			{
				review_list = review_adminSvc.getReviews_by_title_n_content(search, page);
				all_reviews = review_adminSvc.getCountReviewsByTitleNContent(search);
				all_pages = (int)(Math.ceil((double)all_reviews / S.PAGE_LIMIT));
			}
			
			map.put("rp", new Integer(page));
			map.put("rvw_list", review_list);
			map.put("all_pages", all_pages);
			
			return new ModelAndView("admin/board/review/a_review", map);
		}
		else	// 관리자 모드로 로그인하지 않았을 때
		{
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
	}
	
	// 글 읽기
	@RequestMapping(value ="/admin/board/review_read.nm", method=RequestMethod.GET, params="r")
	public ModelAndView read_review(HttpServletRequest req, HttpSession session,
			@RequestParam(value="r", required=false) int review_no)
	{
		Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (isAdmin!= null && isAdmin.booleanValue())
		{
			String id = (String)session.getAttribute(S.SESSION_LOGIN);
			ReviewVo rvw = reviewSvc.getOneReview(review_no);

			int countReviews = review_adminSvc.getCountAllReviews();
			
			VReview_AdminVo review = review_adminSvc.getOneReview(review_no);
			List<Review_ReVo> reply = review_reSvc.getAllRe(review_no);
			map.put("count", new Integer(countReviews));
			map.put("id", id);
			map.put("isAdmin", isAdmin);
			map.put("review", review);
			map.put("reply", reply);
			
			return new ModelAndView("admin/board/review/a_review", map);
		}
		else	// 관리자 계정으로 로그인 안됐을 시
		{
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
	}
	
	// 이전글, 다음글 이동
	@RequestMapping(value="/admin/board/review_read_m.nm", method=RequestMethod.GET, params="r")
	public ModelAndView read_review_move(HttpServletRequest request, HttpSession session,
			@RequestParam(value="r") int review_no, @RequestParam(value="d") String direction)
	{
		Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (isAdmin!= null && isAdmin.booleanValue())
		{
			
			ReviewVo rvw = null;
			int chn_no = review_no;
			
			do
			{
				// 이전글
				if (direction.equals("p"))
					chn_no -= 1;
				// 다음글
				else if (direction.equals("n"))
					chn_no += 1;
				
				rvw = reviewSvc.getOneReview(chn_no);
			} while (rvw.getRvw_del_check() > 0);
			
			int countReviews = review_adminSvc.getCountAllReviews();
			
			VReview_AdminVo review = review_adminSvc.getOneReview(chn_no);
			List<Review_ReVo> reply = review_reSvc.getAllRe(chn_no);
			map.put("count", new Integer(countReviews));
			map.put("review", review);
			map.put("reply", reply);
		
			return new ModelAndView("admin/board/review/a_review", map);
		}
		else
		{
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
	}
	
	// 댓글 달기
	@RequestMapping(value="/admin/board/review_reg_re_proc.nm", method=RequestMethod.POST)
	public ModelAndView register_reviewReply_a(HttpServletRequest request, HttpSession session,
			@RequestParam(value="rvw_re_content", required=false) String rvw_re_content,
			@RequestParam(value="rvw_no", required=false) int rvw_no)
	{
		// 세션에서 아이디와 관리자인지 여부를 얻어옴
		String id = (String)session.getAttribute(S.SESSION_LOGIN);
		Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (isAdmin!= null && isAdmin.booleanValue())
		{
			Review_ReVo new_reply = new Review_ReVo();
			new_reply.setMem_id(id);
			new_reply.setRvw_no(rvw_no);
			new_reply.setRvw_re_content(rvw_re_content);
			
			if (review_reSvc.addRe(new_reply) == S.PROCESS_SUCCESS)
			{
				return new ModelAndView("redirect:/admin/board/review_read.nm?r=" + rvw_no, null);
			}
			else
			{
				System.out.println("댓글 등록 실패");
				return new ModelAndView("redirect:/admin/board/review_read.nm?r=" + rvw_no + "&rst=rrfalse", null);
			}
		}
		else
		{
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", null);
		}
	}
	
	// 댓글 및 글 삭제
	@RequestMapping(value="/admin/board/review_del_proc.nm", method=RequestMethod.GET)
	public ModelAndView delete_reviewNRe_a(HttpServletRequest request, HttpSession session,
			@RequestParam(value="c", required=false) String c,
			@RequestParam(value="no", required=false) int no)
	{
		// 세션에서 아이디와 관리자인지 여부를 얻어옴
		Boolean isAdmin = ((Boolean)session.getAttribute(S.SESSION_ADMIN));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (isAdmin!= null && isAdmin.booleanValue())
		{
			// 글 삭제인 경우
			if(c.equals("r"))
			{
				if (reviewSvc.removeReview(no) == S.PROCESS_SUCCESS)
					return new ModelAndView("redirect:/admin/board/review.nm", null);
				else
					return new ModelAndView("redirect:/admin/board/review_read.nm?r=" + no + "&rst=dfalse", null);
			}
			// 댓글 삭제인 경우
			else if(c.equals("rr"))
			{
				int review_no = review_reSvc.getRvwNoOfRe(no);
				
				if (review_reSvc.removeRe(no) == S.PROCESS_SUCCESS)
					return new ModelAndView("redirect:/admin/board/review_read.nm?r=" + review_no, null);
				else
				{
					System.out.println("댓글 삭제 실패");
					return new ModelAndView("redirect:/admin/board/review_read.nm?r=" + review_no + "&rst=rdfalse", null);
				}
			}
			else
				return new ModelAndView("redirect:/admin/board/review.nm", null);
		}
		else
		{
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
	}
	
//*********************************************************************************************관리자 페이지 영역	
//*********************************************************************************************사용자 페이지 영역	
	
	// 글쓰기 페이지 준비하기
	@RequestMapping(value="/product/review_write_popup.nm", method=RequestMethod.GET)
	public ModelAndView prepareWriteReview(HttpServletRequest request, HttpSession session,
			@RequestParam(value="p_no", defaultValue = "0") int product_no)
	{
		if (session.getAttribute(S.SESSION_LOGIN) == null && request.getParameter("rst") == null)
			return new ModelAndView("redirect:/product/review_write_popup.nm?rst=login", null);

		// 세션처리
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product_no", product_no);
		
		return new ModelAndView("board/review/review_write_popup", map);
	}
	
	// 리뷰 등록하기
	@RequestMapping(value="/product/reg_review_proc.nm", method=RequestMethod.POST)
	public String registerReview(HttpServletRequest request, HttpSession session,
			ReviewVo review)
	{
		// 세션처리 (request.getParameter("rst") == null -> 글쓰기 등록 후 세션이 null이 돼 if문에 들어오는 것 방지
		if (session.getAttribute(S.SESSION_LOGIN) == null && request.getParameter("rst") == null)
			return "redirect:/product/review_write_popup.nm?rst=login";
		
		if (reviewSvc.addReview(review) == S.PROCESS_SUCCESS)
			return "redirect:/product/review_write_popup.nm?rst=true";
		else
			return "redirect:/product/review_write_popup.nm?rst=false";
	}
	
	// 수정 페이지 준비하기
	@RequestMapping(value="/product/review_modify_popup.nm", method=RequestMethod.GET)
	public ModelAndView prepareModifyReview(HttpServletRequest request, HttpSession session,
			@RequestParam(value="r_no", defaultValue = "0") int review_no)
	{
		// 세션처리
		if (session.getAttribute(S.SESSION_LOGIN) == null && request.getParameter("rst") == null)
			return new ModelAndView("redirect:/product/review_modify_popup.nm?rst=login", null);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("review", reviewSvc.getOneReview(review_no));
		
		return new ModelAndView("board/review/review_modify_popup", map);
	}
	
	// 리뷰 수정하기
	@RequestMapping(value="/product/modi_review_proc.nm", method=RequestMethod.POST)
	public String modifyReview(HttpServletRequest request, HttpSession session,
			ReviewVo review)
	{
		// 세션처리
		if (session.getAttribute(S.SESSION_LOGIN) == null && request.getParameter("rst") == null)
			return "redirect:/product/review_modify_popup.nm?rst=login";
		
		int result = reviewSvc.editReview(review);
		if (result == S.PROCESS_SUCCESS)
			return "redirect:/product/review_modify_popup.nm?rst=true";
		else
			return "redirect:/product/review_modify_popup.nm?rst=false";
	}
	
	// 댓글 달기
	@RequestMapping(value="/product/review_reg_re_proc.nm", method=RequestMethod.POST)
	public ModelAndView register_reviewReply(HttpServletRequest request, HttpSession session,
			@RequestParam(value="rvw_re_content", required=false) String rvw_re_content,
			@RequestParam(value="rvw_no", required=false) int rvw_no,
			@RequestParam(value="product_no") int product_no)
	{
		String id = (String)session.getAttribute(S.SESSION_LOGIN);
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (id != null && !id.isEmpty())
		{
			Review_ReVo new_reply = new Review_ReVo();
			new_reply.setMem_id(id);
			new_reply.setRvw_no(rvw_no);
			new_reply.setRvw_re_content(rvw_re_content);
			
			if (review_reSvc.addRe(new_reply) == S.PROCESS_SUCCESS)
			{
				return new ModelAndView("redirect:/product/detail.nm?pdno=" + product_no + "&rst=rrtrue#review", null);
			}
			else
			{
				System.out.println("댓글 등록 실패");
				return new ModelAndView("redirect:/product/detail.nm?pdno=" + product_no + "&rst=rrfalse#review", null);
			}
		}
		else
		{
			// 로그인 해달라는 에러 메시지
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
	}
	
	// 댓글 및 글 삭제
	@RequestMapping(value="/product/review_del_proc.nm", method=RequestMethod.GET)
	public ModelAndView delete_review_n_re(HttpServletRequest request, HttpSession session,
			@RequestParam(value="c", required=false) String c,
			@RequestParam(value="no", required=false) int no,
			@RequestParam(value="p_no", required=false) int p_no)
	{
		// 세션에서 아이디와 관리자인지 여부를 얻어옴
		String id = (String)session.getAttribute(S.SESSION_LOGIN);
		Boolean isAdmin = (Boolean)session.getAttribute(S.SESSION_ADMIN);
		String wroteId = (c.equals("r") ? reviewSvc.getOneReview(no).getMem_id() : review_reSvc.getOneReply(no).getMem_id()); 
		Map<String, Object> map = new HashMap<String, Object>();
		
		if ((id != null && id.equals(wroteId))
				|| (isAdmin!= null && isAdmin.booleanValue()))
		{
			// 글 삭제인 경우
			if(c.equals("r"))
			{
				if (reviewSvc.removeReview(no) == S.PROCESS_SUCCESS)
					return new ModelAndView("redirect:/product/detail.nm?pdno=" + p_no + "#review", null);
				else
				{
					System.out.println("글 삭제 실패");
					return new ModelAndView("redirect:/product/detail.nm?pdno=" + p_no + "&rst=dfalse#review", null);
				}
					
			}
			// 댓글 삭제인 경우
			else if(c.equals("rr"))
			{				
				if (review_reSvc.removeRe(no) == S.PROCESS_SUCCESS)
					return new ModelAndView("redirect:/product/detail.nm?pdno=" + p_no + "&rst=rdtrue#review", null);
				else
				{
					System.out.println("댓글 삭제 실패");
					return new ModelAndView("redirect:/product/detail.nm?pdno=" + p_no + "&rst=rdfalse#review", null);
				}
			}
			else
				return new ModelAndView("redirect:/product/detail.nm?pdno=" + p_no, null);
		}
		else
		{
			// 로그인 해달라는 에러 메시지
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
	}
}
