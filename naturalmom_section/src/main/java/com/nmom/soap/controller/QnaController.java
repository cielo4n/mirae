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
import org.springframework.web.servlet.ModelAndView;

import com.nmom.soap.S;
import com.nmom.soap.data.model.board.qna.QnaReVo;
import com.nmom.soap.data.model.board.qna.QnaVo;
import com.nmom.soap.data.model.board.qna.VQnaQnaReVo;
import com.nmom.soap.svc.board.qna.IQnaReSvc;
import com.nmom.soap.svc.board.qna.IQnaSvc;
import com.nmom.soap.svc.board.qna.IVQnaQnareSvc;

@Controller
public class QnaController {
	IQnaSvc qnaSvc;
	IQnaReSvc qnaReSvc;
	IVQnaQnareSvc vQnaQnareSvc;
	
	public void setQnaSvc(IQnaSvc qnaSvc) {
		this.qnaSvc = qnaSvc;
	}
	public void setQnaReSvc(IQnaReSvc qnaReSvc) {
		this.qnaReSvc = qnaReSvc;
	}
	public void setVQnaQnareSvc(IVQnaQnareSvc vQnaQnareSvc) {
		this.vQnaQnareSvc = vQnaQnareSvc;
	}
	
	//QNA 전체 목록 보여주기 페이지네이션
	@RequestMapping(value="/board/qna/{pp}/list.nm", method = RequestMethod.GET)
	public ModelAndView showQnaBoard(HttpServletRequest req, 
			@PathVariable(value="pp") int pp)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
		//오라클 rownum 의 start, end 계산
		int count = vQnaQnareSvc.getQnaCount();
		int start = count - (S.PAGE_LIMIT * pp);
		int end = start + S.PAGE_LIMIT;
		
		List<VQnaQnaReVo> qna_list = vQnaQnareSvc.getAllQna(start, end);
		
		//페이지수 계산
		int total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
		
		if(qna_list != null){
			map.put("qna_count", count);
			map.put("qna_list", qna_list);
			map.put("pp", pp);
			map.put("total", total_pages);
			
		}
		
		ModelAndView mav = new ModelAndView("board/qna/b_qna", map);
		return mav;
		
	}
	
	//QNA 목록보기
	@RequestMapping(value="/board/qna.nm", method={RequestMethod.GET})
	public String boardQna(HttpServletRequest req)
	{
		return "redirect:/board/qna/1/list.nm";
	}
	
	//QNA 다음글 가기
	@RequestMapping(value="/board/qna/next/read.nm", method=RequestMethod.GET)
	public ModelAndView qnaNextRead(HttpServletRequest req,
			@RequestParam(value="qr_no") String qr_no,
			@RequestParam(value="rn") String rn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		List<VQnaQnaReVo> qnare_list;
		int rownum;
		
		try{
			if(rn != null && qr_no!=null){
				rownum = Integer.parseInt(rn);
				qnare_list = vQnaQnareSvc.getAllQna(rownum, rownum+1);
				
				if(qnare_list.size() == 1){ //다음글 있음
					map.put("qr_no", qnare_list.get(0).getQna_no());
					map.put("rn", rownum+1);
					
				} else {
					map.put("qr_no", qr_no);
					map.put("rn", rownum);
					map.put("next_err", "t");
					System.out.println("다음글이 없습니다");
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("다음글 가려는데 정보 못받아옴");
			return new ModelAndView("redirect:/board/qna.nm", map);
		}
		
		return new ModelAndView("redirect:/board/qna/read.nm", map);
	}
	
	//QNA 이전글 가기
	@RequestMapping(value="/board/qna/prev/read.nm", method=RequestMethod.GET)
	public ModelAndView qnaPreviousRead(HttpServletRequest req,
			@RequestParam(value="qr_no") String qr_no,
			@RequestParam(value="rn") String rn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		List<VQnaQnaReVo> qnare_list;
		int rownum;
		
		try{
			if(rn != null && qr_no!=null){
				rownum = Integer.parseInt(rn);
				qnare_list = vQnaQnareSvc.getAllQna(rownum-2, rownum-1);
				
				if(qnare_list.size() == 1){ //이전글 있음
					map.put("qr_no", qnare_list.get(0).getQna_no());
					map.put("rn", rownum-1);
					
				} else {
					map.put("qr_no", qr_no);
					map.put("rn", rownum);
					map.put("prev_err", "t");
					System.out.println("이전글이 없습니다");
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("이전글 가려는데 정보 못받아옴");
			return new ModelAndView("redirect:/board/qna.nm", map);
		}
		
		return new ModelAndView("redirect:/board/qna/read.nm", map);
	}
	
	//QNA 질문 검색 페이지네이션
	@RequestMapping(value ="/board/qna/{pp}/search.nm", method=RequestMethod.GET)
	public ModelAndView boardSearchQna(HttpServletRequest req, 
			@PathVariable(value="pp") int pp,
			@RequestParam(value="sch") String sch,
			@RequestParam(value="kw", required=false) String kw){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
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
		
		ModelAndView mav = new ModelAndView("board/qna/b_qna", map);
		return mav;
	}
	

	//QNA 하나 읽기
	@RequestMapping(value="/board/qna/read.nm", method=RequestMethod.GET)
	public ModelAndView qnaRead(HttpServletRequest req,
		@RequestParam(value="qr_no") String qr_no)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		VQnaQnaReVo qna_vo;
		List<QnaReVo> qnare_list;
		
		int qnano;
		
		try{
			if(qr_no != null){
				qnano = Integer.parseInt(qr_no);
				qna_vo = vQnaQnareSvc.getOneQna(qnano);
				qnare_list = qnaReSvc.getQnaReByQnaNo(qnano);
				
				if(qna_vo!=null && qnare_list!=null){
					
					//조회수 증가하는 부분
					if(qnaSvc.increaseQnaHits(qna_vo.getQna_no()) == 1){
						//조회수 증가시 다시 가져옴
						qna_vo = vQnaQnareSvc.getOneQna(qnano);
						qnare_list = qnaReSvc.getQnaReByQnaNo(qnano);
					} else {
						System.out.println("조회수 증가 실패");
					}
					map.put("qvo", qna_vo);
					map.put("qnare_list", qnare_list);

					//일반글인지 비밀글인지 분류
					if(qna_vo.getQna_pw()!= null){ //비밀글일때
						map.put("secret", true); 
					}
					return new ModelAndView("/board/qna/b_qna", map);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("글읽기 정보 받아오기 실패");
		}
		return new ModelAndView("redirect:/board/qna.nm", map);
	}
	
	//QNA 비밀글 하나 읽기
	@RequestMapping(value="/board/qna/secret.nm", method=RequestMethod.POST)
	public ModelAndView qnaSecretRead(HttpServletRequest req,
		@RequestParam(value="rn", required=false) String rn,
		@RequestParam(value="qr_no") String qr_no,
		@RequestParam(value="q_pw") String q_pw
	)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		VQnaQnaReVo qna_vo;
		List<QnaReVo> qnare_list;
		
		int qnano;
		
		try{
			if(qr_no != null){
				qnano = Integer.parseInt(qr_no);
				qna_vo = vQnaQnareSvc.getOneQna(qnano);
				qnare_list = qnaReSvc.getQnaReByQnaNo(qnano);
				if(qna_vo!=null){
					map.put("qvo", qna_vo);
					if(qnare_list!=null){
						map.put("qnare_list", qnare_list);
					}
				}

				if(qna_vo.getQna_pw().equals(q_pw)){ //글 비밀번호가 맞음
					return new ModelAndView("/board/qna/b_qna", map);
					
				} else{ //글 비밀번호가 틀림
					map.put("secret", true);
					map.put("incorrect_pw", "잘못된 비밀번호 입니다");
					return new ModelAndView("/board/qna/b_qna", map);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("비밀글 읽기 정보 받아오기 실패");
		}
		return new ModelAndView("redirect:/board/qna.nm", map);
	}
	
	// QNA 글쓰기 사용자가 작성하는 화면
	@RequestMapping(value="/board/qna/add_form.nm", method=RequestMethod.GET)
	public ModelAndView prepareAddQnaForm(HttpServletRequest req,
			@RequestParam(value="pos", required = false) String pos,
			@RequestParam(value="ref", required = false) String ref)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		if(pos!=null && ref!=null){
			try{
				QnaVo ori_qvo = qnaSvc.getSimpleQnaByRefNPos(Integer.parseInt(ref), Integer.parseInt(pos));
				map.put("answer", ori_qvo);
				
			} catch(Exception e){
				System.out.println("원글정보 가져오기 실패");
			}
		}
		
		map.put("qwa", true); //qnq write add
		return new ModelAndView("board/qna/b_qna", map);
	}

	// QNA 글쓰기 사용자가 작성하는 과정
	@RequestMapping(value="/board/qna/add_proc.nm", method=RequestMethod.POST)
	public String addNewQna(HttpServletRequest req,
			@RequestParam(value="title", required=false) String title,
			@RequestParam(value="writer", required=false) String writer,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="secret_check", required=false) boolean secret_check,
			@RequestParam(value="content", required=false) String content,
			@RequestParam(value="old_qna_ref", required=false) String old_qna_ref,
			@RequestParam(value="old_qna_pos", required=false) String old_qna_pos
			)
	{

		if(title == null || title.equals("")){
			title = "(제목없음)";
		}
		if(content == null || content.equals("")){
			content = "(내용없음)";
		}
		
		String qna_pw = null;
		
		if(secret_check){
			if(password == null || password.isEmpty()){
				password = "0000";
				System.out.println("기본 비밀번호 설정");
			}
			qna_pw = password;
		}
		
		if(old_qna_ref!=null && old_qna_pos!=null){ //답변글

			int qna_parent_ref;
			int qna_parent_pos;
			
			try{
				int r;
				
				qna_parent_ref = Integer.parseInt(old_qna_ref);
				qna_parent_pos = Integer.parseInt(old_qna_pos);
				
				System.out.println("old_qna_ref : "+old_qna_ref);
				System.out.println("old_qna_pos : "+old_qna_pos);
				
				int move = qnaSvc.pushRearPos(qna_parent_ref, qna_parent_pos); //뒤로 밀어내 내 자리 마련함
				r = qnaSvc.addQnaAnswer(title, content, qna_pw, writer, qna_parent_pos+1, qna_parent_ref);
				
				if(move==0){
					System.out.println("내가 끝이야");
				} else {
					System.out.println("내가 밀었어");
				}
				
				if(r==1){
					System.out.println("답변 등록 성공");
				}else {
					System.out.println("답변 등록 실패");
				}
				
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("답변추가시 정보 가져오기 실패");
			}
			
		} else { //일반글
			int r = qnaSvc.addQna(title, content, qna_pw, writer);
			if(r==1){
				System.out.println("글 등록 성공");
			}else {
				System.out.println("글 등록 실패");
			}
		}
		return "redirect:/board/qna.nm";
	}
	

	// QNA 글쓰기 사용자가 글편집하는 화면
	@RequestMapping(value="/board/qna/edit_form.nm", method=RequestMethod.GET)
	public ModelAndView prepareEditQnaForm(HttpServletRequest req,
			@RequestParam(value="qe_no") String qe_no){
		
		int qna_no;
		QnaVo qna_vo;
		
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(qe_no!=null){
				qna_no = Integer.parseInt(qe_no);
				qna_vo = qnaSvc.getOneSimpleQna(qna_no);
				map.put("qvo", qna_vo);
				map.put("qwe", true); //qna write edit
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("글 편집 정보 받아오기 실패");
		}
		
		return new ModelAndView("board/qna/b_qna", map);
	}
	
	// QNA 글쓰기 사용자가 글편집 하는 과정
	@RequestMapping(value="/board/qna/edit_proc.nm", method=RequestMethod.POST)
	public String editOldQna(HttpServletRequest req,
			@RequestParam(value="qe_no", required=false) String qe_no,
			@RequestParam(value="title", required=false) String title,
			@RequestParam(value="writer", required=false) String writer,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="secret_check", required=false) boolean secret_check,
			@RequestParam(value="content", required=false) String content)
	{
		int qna_no;
		String qna_pw = null;
		
		if(secret_check){
			if(password == null || password.isEmpty()){
				password = "0000";
				System.out.println("기본 비밀번호 설정");
			}
			qna_pw = password;
		}

		if(title == null || title.equals("")){
			title = "(제목없음)";
		}
		if(content == null || content.equals("")){
			content = "(내용없음)";
		}
		
		try{
			if(qe_no!=null){
				qna_no = Integer.parseInt(qe_no);
				int r = qnaSvc.editQna(qna_no, title, content, qna_pw);
				
				if(r==1){
					System.out.println("글 수정 성공");
				}else {
					System.out.println("글 수정 실패");
				}
				
			}

		} catch(Exception e){
			e.printStackTrace();
			System.out.println("글 편집 정보 받아오기 실패");
		}
		
		return "redirect:/board/qna.nm";
	}
	
	//  /soap/board/delete_proc.nm?
	// QNA 글쓰기 사용자가 글삭제 하는 과정
	@RequestMapping(value="/board/qna/delete_proc.nm", method=RequestMethod.GET)
	public String removeQnaProcess(HttpServletRequest req,
			@RequestParam(value="qd_no") String qd_no,
			@RequestParam(value="ref") String ref,
			@RequestParam(value="pos") String pos){

		int qna_no;
		int qna_ref;
		int qna_pos;
		
		try{
			if(qd_no!=null && ref!=null && pos!=null){
				qna_no = Integer.parseInt(qd_no);
				qna_ref = Integer.parseInt(ref);
				qna_pos = Integer.parseInt(pos);
				
				int r = qnaSvc.removeQna(qna_no); //선택된 글 삭제
				if(r != 1){
					System.out.println("글 삭제 실패");
					return "redirect:/board/qna.nm";
				}
				
				if(qna_pos == 0){ //첫번째 글인 경우 하위에 연결된 답변글을 모두 지움
					qnaSvc.removeQnaByRef(qna_ref); //하위 글 삭제
				} 
				else { //답글인 경우 하위에 연결된 글을 당겨와야함
					qnaSvc.pushFrontPos(qna_ref, qna_pos);
				}
			}
		} catch(Exception e){
			System.out.println("글삭제 정보 받아오기 실패");
		}
		return "redirect:/board/qna.nm";
	}
	
	
	// /board/qna/read/add_reply_proc.nm
	// 댓글 등록하기
	@RequestMapping(value="/board/qna/read/add_reply_proc.nm", method=RequestMethod.POST)
	public ModelAndView addQnaReplyProcess(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="qr_no") String qr_no,
			@RequestParam(value="rn") String rn,
			@RequestParam(value="dat_text") String dat_text)
	{
		String dat_content="";
		int qna_no;
		int qna_rownum;
		String writer = (String)ses.getAttribute("loggedin");
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		if(writer!=null && qr_no!=null && rn!=null && dat_text!=null){
			if(!dat_text.isEmpty()){
				dat_content = dat_text;
			}
			
			try{
				qna_no = Integer.parseInt(qr_no);
				qna_rownum = Integer.parseInt(rn);
				int r = qnaReSvc.addQnaRe(dat_content, qna_no, writer);
				
				if(r == 1){ 
					if(qnaSvc.getOneSimpleQna(Integer.parseInt(qr_no)).getQna_pw()!=null){
						//비밀글일 경우 정보를 다시 받아 뿌려줌
						
						VQnaQnaReVo qna_vo;
						List<QnaReVo> qnare_list;
						
						try{
							if(qr_no != null){
								int qnano = Integer.parseInt(qr_no);
								qna_vo = vQnaQnareSvc.getOneQna(qnano);
								qnare_list = qnaReSvc.getQnaReByQnaNo(qnano);
								
								if(qna_vo!=null && qnare_list!=null){
									
									//조회수 증가하는 부분
									if(qnaSvc.increaseQnaHits(qna_vo.getQna_no()) == 1){
										//조회수 증가시 다시 가져옴
										qna_vo = vQnaQnareSvc.getOneQna(qnano);
										qnare_list = qnaReSvc.getQnaReByQnaNo(qnano);
									} else {
										System.out.println("조회수 증가 실패");
									}
									map.put("qvo", qna_vo);
									map.put("qnare_list", qnare_list);
									return new ModelAndView("/board/qna/b_qna", map);
								}
							}
						} catch(Exception e){
							e.printStackTrace();
							System.out.println("댓글 작성시 비밀글 정보 가져오기 실패");
						}
					} // ~ 비밀글에 댓글 등록
					
					//일반글에 댓글 등록
					map.put("qr_no", qna_no);
					map.put("rn", qna_rownum);
					return new ModelAndView("redirect:/board/qna/read.nm", map);
				}
				System.out.println("댓글 등록 실패");
				
			} catch(Exception e){
				System.out.println("댓글 등록 정보 못받아옴");
				e.printStackTrace();
			}
		
		}
		return new ModelAndView("redirect:/board/qna.nm", map);
	}

	// /board/qna/read/del_reply_proc.nm
	// 댓글 삭제하기
	@RequestMapping(value="/board/qna/read/del_reply_proc.nm", method=RequestMethod.GET)
	public ModelAndView removeQnaReplyProcess(HttpServletRequest req,
			@RequestParam(value="qr_no") String qr_no,
			@RequestParam(value="rn") String rn,
			@RequestParam(value="reno") String reno)
	{
		int qna_no;
		int qna_rownum;
		int qna_re_no;
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(reno!=null && qr_no!=null && rn!=null){
			
			try{
				qna_no = Integer.parseInt(qr_no);
				qna_rownum = Integer.parseInt(rn);
				qna_re_no = Integer.parseInt(reno);
				int r = qnaReSvc.removeQnaRe(qna_re_no);

				if(r == 1){
					if(qnaSvc.getOneSimpleQna(Integer.parseInt(qr_no)).getQna_pw()!=null){
						//비밀글일 경우 정보를 다시 받아 뿌려줌
						
						VQnaQnaReVo qna_vo;
						List<QnaReVo> qnare_list;
						
						try{
							if(qr_no != null){
								qna_vo = vQnaQnareSvc.getOneQna(qna_no);
								qnare_list = qnaReSvc.getQnaReByQnaNo(qna_no);
								
								if(qna_vo!=null && qnare_list!=null){
									
									//조회수 증가하는 부분
									if(qnaSvc.increaseQnaHits(qna_vo.getQna_no()) == 1){
										//조회수 증가시 다시 가져옴
										qna_vo = vQnaQnareSvc.getOneQna(qna_no);
										qnare_list = qnaReSvc.getQnaReByQnaNo(qna_no);
									} else {
										System.out.println("조회수 증가 실패");
									}
									map.put("qvo", qna_vo);
									map.put("qnare_list", qnare_list);
									return new ModelAndView("/board/qna/b_qna", map);
								}
							}
						} catch(Exception e){
							e.printStackTrace();
							System.out.println("댓글 작성시 비밀글 정보 가져오기 실패");
						}
					} // ~ 비밀글에 댓글 삭제
					
					//일반글에 단 댓글 삭제
					map.put("qr_no", qna_no);
					map.put("rn", qna_rownum);
					return new ModelAndView("redirect:/board/qna/read.nm", map);
				}
				System.out.println("댓글 삭제 실패");
				
			} catch(Exception e){
				System.out.println("댓글 삭제 정보 못받아옴");
				e.printStackTrace();
			}
		
		}
		return new ModelAndView("redirect:/board/qna.nm", map);		
	}
	
	/////////////////////////////////////////////////////////////////////////
	//TODO
	/*@RequestMapping(value ="admin/board/qna.nm", method=RequestMethod.GET)
	public String a_board_qna(HttpServletRequest req){
		return "admin/board/qna/a_qna";
	}*/

	//QNA 전체 목록 보여주기 페이지네이션
	@RequestMapping(value="/admin/board/qna/{pp}/list.nm", method = RequestMethod.GET)
	public ModelAndView adminShowQnaBoard(HttpServletRequest req,
			HttpSession se,
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
		int count = vQnaQnareSvc.getQnaCount();
		int start = count - (S.PAGE_LIMIT * pp);
		int end = start + S.PAGE_LIMIT;
		
		List<VQnaQnaReVo> qna_list = vQnaQnareSvc.getAllQna(start, end);
		
		//페이지수 계산
		int total_pages = (int)Math.ceil((double)count/S.PAGE_LIMIT);
		
		if(qna_list != null){
			map.put("qna_count", count);
			map.put("qna_list", qna_list);
			map.put("pp", pp);
			map.put("total", total_pages);
			
		}
		
		ModelAndView mav = new ModelAndView("admin/board/qna/a_qna", map);
		return mav;
		
	}
	
	//QNA 목록보기
	@RequestMapping(value="/admin/board/qna.nm", method={RequestMethod.GET})
	public String adminBoardQna(HttpServletRequest req)
	{
		return "redirect:/admin/board/qna/1/list.nm";
	}
	
	//QNA 다음글 가기
	@RequestMapping(value="/admin/board/qna/next/read.nm", method=RequestMethod.GET)
	public ModelAndView adminQnaNextRead(HttpServletRequest req,
			@RequestParam(value="qr_no") String qr_no,
			@RequestParam(value="rn") String rn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		List<VQnaQnaReVo> qnare_list;
		int rownum;
		
		try{
			if(rn != null && qr_no!=null){
				rownum = Integer.parseInt(rn);
				qnare_list = vQnaQnareSvc.getAllQna(rownum, rownum+1);
				
				if(qnare_list.size() == 1){ //다음글 있음
					map.put("qr_no", qnare_list.get(0).getQna_no());
					map.put("rn", rownum+1);
					
				} else {
					map.put("qr_no", qr_no);
					map.put("rn", rownum);
					map.put("next_err", "t");
					System.out.println("다음글이 없습니다");
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("다음글 가려는데 정보 못받아옴");
			return new ModelAndView("redirect:/admin/board/qna.nm", map);
		}
		
		return new ModelAndView("redirect:/admin/board/qna/read.nm", map);
	}
	
	//QNA 이전글 가기
	@RequestMapping(value="/admin/board/qna/prev/read.nm", method=RequestMethod.GET)
	public ModelAndView adminQnaPreviousRead(HttpServletRequest req,
			@RequestParam(value="qr_no") String qr_no,
			@RequestParam(value="rn") String rn)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		List<VQnaQnaReVo> qnare_list;
		int rownum;
		
		try{
			if(rn != null && qr_no!=null){
				rownum = Integer.parseInt(rn);
				qnare_list = vQnaQnareSvc.getAllQna(rownum-2, rownum-1);
				
				if(qnare_list.size() == 1){ //이전글 있음
					map.put("qr_no", qnare_list.get(0).getQna_no());
					map.put("rn", rownum-1);
					
				} else {
					map.put("qr_no", qr_no);
					map.put("rn", rownum);
					map.put("prev_err", "t");
					System.out.println("이전글이 없습니다");
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("이전글 가려는데 정보 못받아옴");
			return new ModelAndView("redirect:/admin/board/qna.nm", map);
		}
		
		return new ModelAndView("redirect:/admin/board/qna/read.nm", map);
	}
	
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
	

	//QNA 하나 읽기
	@RequestMapping(value="/admin/board/qna/read.nm", method=RequestMethod.GET)
	public ModelAndView adminQnaRead(HttpServletRequest req,
		HttpSession se,
		@RequestParam(value="qr_no") String qr_no)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		VQnaQnaReVo qna_vo;
		List<QnaReVo> qnare_list;
		
		// 관리자인지 확인
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}	
		
		int qnano;
		
		try{
			if(qr_no != null){
				qnano = Integer.parseInt(qr_no);
				qna_vo = vQnaQnareSvc.getOneQna(qnano);
				qnare_list = qnaReSvc.getQnaReByQnaNo(qnano);
				
				if(qna_vo!=null && qnare_list!=null){
					
					//조회수 증가하는 부분
					if(qnaSvc.increaseQnaHits(qna_vo.getQna_no()) == 1){
						//조회수 증가시 다시 가져옴
						qna_vo = vQnaQnareSvc.getOneQna(qnano);
						qnare_list = qnaReSvc.getQnaReByQnaNo(qnano);
					} else {
						System.out.println("조회수 증가 실패");
					}
					map.put("qvo", qna_vo);
					map.put("qnare_list", qnare_list);

					//일반글인지 비밀글인지 분류
					if(qna_vo.getQna_pw()!= null){ //비밀글일때
						map.put("secret", true); 
					}
					return new ModelAndView("/admin/board/qna/a_qna", map);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("글읽기 정보 받아오기 실패");
		}
		return new ModelAndView("redirect:/admin/board/qna.nm", map);
	}
	
	//QNA 비밀글 하나 읽기
	@RequestMapping(value="/admin/board/qna/secret.nm", method=RequestMethod.POST)
	public ModelAndView adminQnaSecretRead(HttpServletRequest req,
		HttpSession se,
		@RequestParam(value="rn", required=false) String rn,
		@RequestParam(value="qr_no") String qr_no,
		@RequestParam(value="q_pw") String q_pw
	)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		VQnaQnaReVo qna_vo;
		List<QnaReVo> qnare_list;
		
		// 관리자인지 확인
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		
		int qnano;
		
		try{
			if(qr_no != null){
				qnano = Integer.parseInt(qr_no);
				qna_vo = vQnaQnareSvc.getOneQna(qnano);
				qnare_list = qnaReSvc.getQnaReByQnaNo(qnano);
				if(qna_vo!=null){
					map.put("qvo", qna_vo);
					if(qnare_list!=null){
						map.put("qnare_list", qnare_list);
					}
				}

				if(qna_vo.getQna_pw().equals(q_pw)){ //글 비밀번호가 맞음
					return new ModelAndView("/admin/board/qna/a_qna", map);
					
				} else{ //글 비밀번호가 틀림
					map.put("secret", true);
					map.put("incorrect_pw", "잘못된 비밀번호 입니다");
					return new ModelAndView("/admin/board/qna/a_qna", map);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("비밀글 읽기 정보 받아오기 실패");
		}
		return new ModelAndView("redirect:/admin/board/qna.nm", map);
	}
	
	// QNA 글쓰기 사용자가 작성하는 화면
	@RequestMapping(value="/admin/board/qna/add_form.nm", method=RequestMethod.GET)
	public ModelAndView adminPrepareAddQnaForm(HttpServletRequest req,
			HttpSession se,
			@RequestParam(value="pos", required = false) String pos,
			@RequestParam(value="ref", required = false) String ref)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
		// 관리자인지 확인
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		
		if(pos!=null && ref!=null){
			try{
				QnaVo ori_qvo = qnaSvc.getSimpleQnaByRefNPos(Integer.parseInt(ref), Integer.parseInt(pos));
				map.put("answer", ori_qvo);
				
			} catch(Exception e){
				System.out.println("원글정보 가져오기 실패");
			}
		}
		
		map.put("qwa", true); //qnq write add
		return new ModelAndView("admin/board/qna/a_qna", map);
	}

	// QNA 글쓰기 사용자가 작성하는 과정
	@RequestMapping(value="/admin/board/qna/add_proc.nm", method=RequestMethod.POST)
	public String adminAddNewQna(HttpServletRequest req,
			@RequestParam(value="title", required=false) String title,
			@RequestParam(value="writer", required=false) String writer,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="secret_check", required=false) boolean secret_check,
			@RequestParam(value="content", required=false) String content,
			@RequestParam(value="old_qna_ref", required=false) String old_qna_ref,
			@RequestParam(value="old_qna_pos", required=false) String old_qna_pos
			)
	{

		if(title == null || title.equals("")){
			title = "(제목없음)";
		}
		if(content == null || content.equals("")){
			content = "(내용없음)";
		}
		
		String qna_pw = null;
		
		if(secret_check){
			if(password == null || password.isEmpty()){
				password = "0000";
				System.out.println("기본 비밀번호 설정");
			}
			qna_pw = password;
		}
		
		if(old_qna_ref!=null && old_qna_pos!=null){ //답변글

			int qna_parent_ref;
			int qna_parent_pos;
			
			try{
				int r;
				
				qna_parent_ref = Integer.parseInt(old_qna_ref);
				qna_parent_pos = Integer.parseInt(old_qna_pos);
				
				System.out.println("old_qna_ref : "+old_qna_ref);
				System.out.println("old_qna_pos : "+old_qna_pos);
				
				int move = qnaSvc.pushRearPos(qna_parent_ref, qna_parent_pos); //뒤로 밀어내 내 자리 마련함
				r = qnaSvc.addQnaAnswer(title, content, qna_pw, writer, qna_parent_pos+1, qna_parent_ref);
				
				if(move==0){
					System.out.println("내가 끝이야");
				} else {
					System.out.println("내가 밀었어");
				}
				
				if(r==1){
					System.out.println("답변 등록 성공");
				}else {
					System.out.println("답변 등록 실패");
				}
				
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("답변추가시 정보 가져오기 실패");
			}
			
		} else { //일반글
			int r = qnaSvc.addQna(title, content, qna_pw, writer);
			if(r==1){
				System.out.println("글 등록 성공");
			}else {
				System.out.println("글 등록 실패");
			}
		}
		return "redirect:/admin/board/qna.nm";
	}
	

	// QNA 글쓰기 사용자가 글편집하는 화면
	@RequestMapping(value="/admin/board/qna/edit_form.nm", method=RequestMethod.GET)
	public ModelAndView adminPrepareEditQnaForm(HttpServletRequest req,
			HttpSession se,
			@RequestParam(value="qe_no") String qe_no){
		
		int qna_no;
		QnaVo qna_vo;
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		// 관리자인지 확인
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		try{
			if(qe_no!=null){
				qna_no = Integer.parseInt(qe_no);
				qna_vo = qnaSvc.getOneSimpleQna(qna_no);
				map.put("qvo", qna_vo);
				map.put("qwe", true); //qna write edit
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("글 편집 정보 받아오기 실패");
		}
		
		return new ModelAndView("admin/board/qna/a_qna", map);
	}
	
	// QNA 글쓰기 사용자가 글편집 하는 과정
	@RequestMapping(value="/admin/board/qna/edit_proc.nm", method=RequestMethod.POST)
	public String adminEditOldQna(HttpServletRequest req,
			@RequestParam(value="qe_no", required=false) String qe_no,
			@RequestParam(value="title", required=false) String title,
			@RequestParam(value="writer", required=false) String writer,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="secret_check", required=false) boolean secret_check,
			@RequestParam(value="content", required=false) String content)
	{
		int qna_no;
		String qna_pw = null;
		
		if(secret_check){
			if(password == null || password.isEmpty()){
				password = "0000";
				System.out.println("기본 비밀번호 설정");
			}
			qna_pw = password;
		}

		if(title == null || title.equals("")){
			title = "(제목없음)";
		}
		if(content == null || content.equals("")){
			content = "(내용없음)";
		}
		
		try{
			if(qe_no!=null){
				qna_no = Integer.parseInt(qe_no);
				int r = qnaSvc.editQna(qna_no, title, content, qna_pw);
				
				if(r==1){
					System.out.println("글 수정 성공");
				}else {
					System.out.println("글 수정 실패");
				}
				
			}

		} catch(Exception e){
			e.printStackTrace();
			System.out.println("글 편집 정보 받아오기 실패");
		}
		
		return "redirect:/admin/board/qna.nm";
	}
	
	//  /soap/admin/board/delete_proc.nm?
	// QNA 글쓰기 사용자가 글삭제 하는 과정
	@RequestMapping(value="/admin/board/qna/delete_proc.nm", method=RequestMethod.GET)
	public String adminRemoveQnaProcess(HttpServletRequest req,
			@RequestParam(value="qd_no") String qd_no,
			@RequestParam(value="ref") String ref,
			@RequestParam(value="pos") String pos){

		int qna_no;
		int qna_ref;
		int qna_pos;
		
		try{
			if(qd_no!=null && ref!=null && pos!=null){
				qna_no = Integer.parseInt(qd_no);
				qna_ref = Integer.parseInt(ref);
				qna_pos = Integer.parseInt(pos);
				
				int r = qnaSvc.removeQna(qna_no); //선택된 글 삭제
				if(r != 1){
					System.out.println("글 삭제 실패");
					return "redirect:/admin/board/qna.nm";
				}
				
				if(qna_pos == 0){ //첫번째 글인 경우 하위에 연결된 답변글을 모두 지움
					qnaSvc.removeQnaByRef(qna_ref); //하위 글 삭제
				} 
				else { //답글인 경우 하위에 연결된 글을 당겨와야함
					qnaSvc.pushFrontPos(qna_ref, qna_pos);
				}
			}
		} catch(Exception e){
			System.out.println("글삭제 정보 받아오기 실패");
		}
		return "redirect:/admin/board/qna.nm";
	}
	
	
	// /admin/board/qna/read/add_reply_proc.nm
	// 댓글 등록하기
	@RequestMapping(value="/admin/board/qna/read/add_reply_proc.nm", method=RequestMethod.POST)
	public ModelAndView adminAddQnaReplyProcess(HttpServletRequest req, HttpSession ses,
			@RequestParam(value="qr_no") String qr_no,
			@RequestParam(value="rn") String rn,
			@RequestParam(value="dat_text") String dat_text)
	{
		String dat_content="";
		int qna_no;
		int qna_rownum;
		String writer = (String)ses.getAttribute("loggedin");
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		if(writer!=null && qr_no!=null && rn!=null && dat_text!=null){
			if(!dat_text.isEmpty()){
				dat_content = dat_text;
			}
			
			try{
				qna_no = Integer.parseInt(qr_no);
				qna_rownum = Integer.parseInt(rn);
				int r = qnaReSvc.addQnaRe(dat_content, qna_no, writer);
				
				if(r == 1){ 
					if(qnaSvc.getOneSimpleQna(Integer.parseInt(qr_no)).getQna_pw()!=null){
						//비밀글일 경우 정보를 다시 받아 뿌려줌
						
						VQnaQnaReVo qna_vo;
						List<QnaReVo> qnare_list;
						
						try{
							if(qr_no != null){
								int qnano = Integer.parseInt(qr_no);
								qna_vo = vQnaQnareSvc.getOneQna(qnano);
								qnare_list = qnaReSvc.getQnaReByQnaNo(qnano);
								
								if(qna_vo!=null && qnare_list!=null){
									
									//조회수 증가하는 부분
									if(qnaSvc.increaseQnaHits(qna_vo.getQna_no()) == 1){
										//조회수 증가시 다시 가져옴
										qna_vo = vQnaQnareSvc.getOneQna(qnano);
										qnare_list = qnaReSvc.getQnaReByQnaNo(qnano);
									} else {
										System.out.println("조회수 증가 실패");
									}
									map.put("qvo", qna_vo);
									map.put("qnare_list", qnare_list);
									return new ModelAndView("/admin/board/qna/a_qna", map);
								}
							}
						} catch(Exception e){
							e.printStackTrace();
							System.out.println("댓글 작성시 비밀글 정보 가져오기 실패");
						}
					} // ~ 비밀글에 댓글 등록
					
					//일반글에 댓글 등록
					map.put("qr_no", qna_no);
					map.put("rn", qna_rownum);
					return new ModelAndView("redirect:/admin/board/qna/read.nm", map);
				}
				System.out.println("댓글 등록 실패");
				
			} catch(Exception e){
				System.out.println("댓글 등록 정보 못받아옴");
				e.printStackTrace();
			}
		
		}
		return new ModelAndView("redirect:/admin/board/qna.nm", map);
	}

	// /admin/board/qna/read/del_reply_proc.nm
	// 댓글 삭제하기
	@RequestMapping(value="/admin/board/qna/read/del_reply_proc.nm", method=RequestMethod.GET)
	public ModelAndView adminRemoveQnaReplyProcess(HttpServletRequest req,
			@RequestParam(value="qr_no") String qr_no,
			@RequestParam(value="rn") String rn,
			@RequestParam(value="reno") String reno)
	{
		int qna_no;
		int qna_rownum;
		int qna_re_no;
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(reno!=null && qr_no!=null && rn!=null){
			
			try{
				qna_no = Integer.parseInt(qr_no);
				qna_rownum = Integer.parseInt(rn);
				qna_re_no = Integer.parseInt(reno);
				int r = qnaReSvc.removeQnaRe(qna_re_no);

				if(r == 1){
					if(qnaSvc.getOneSimpleQna(Integer.parseInt(qr_no)).getQna_pw()!=null){
						//비밀글일 경우 정보를 다시 받아 뿌려줌
						
						VQnaQnaReVo qna_vo;
						List<QnaReVo> qnare_list;
						
						try{
							if(qr_no != null){
								qna_vo = vQnaQnareSvc.getOneQna(qna_no);
								qnare_list = qnaReSvc.getQnaReByQnaNo(qna_no);
								
								if(qna_vo!=null && qnare_list!=null){
									
									//조회수 증가하는 부분
									if(qnaSvc.increaseQnaHits(qna_vo.getQna_no()) == 1){
										//조회수 증가시 다시 가져옴
										qna_vo = vQnaQnareSvc.getOneQna(qna_no);
										qnare_list = qnaReSvc.getQnaReByQnaNo(qna_no);
									} else {
										System.out.println("조회수 증가 실패");
									}
									map.put("qvo", qna_vo);
									map.put("qnare_list", qnare_list);
									return new ModelAndView("/admin/board/qna/a_qna", map);
								}
							}
						} catch(Exception e){
							e.printStackTrace();
							System.out.println("댓글 작성시 비밀글 정보 가져오기 실패");
						}
					} // ~ 비밀글에 댓글 삭제
					
					//일반글에 단 댓글 삭제
					map.put("qr_no", qna_no);
					map.put("rn", qna_rownum);
					return new ModelAndView("redirect:/admin/board/qna/read.nm", map);
				}
				System.out.println("댓글 삭제 실패");
				
			} catch(Exception e){
				System.out.println("댓글 삭제 정보 못받아옴");
				e.printStackTrace();
			}
		
		}
		return new ModelAndView("redirect:/admin/board/qna.nm", map);		
	}
	
	

}