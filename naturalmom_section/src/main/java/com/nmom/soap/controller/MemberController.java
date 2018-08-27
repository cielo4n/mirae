package com.nmom.soap.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.nmom.soap.data.model.member.MemberVo;
import com.nmom.soap.data.model.member.MyEmail;
import com.nmom.soap.svc.member.IMailRegistrationNotification;
import com.nmom.soap.svc.member.IMemberSvc;

@Controller
public class MemberController {
	
	IMemberSvc memberSvc;
	IMailRegistrationNotification emailSvc;
	
	public static List<MemberVo> s_member_list;
	
	public void setMemberSvc(IMemberSvc memberSvc) {
		this.memberSvc = memberSvc;
	}
	public void setEmailSvc(IMailRegistrationNotification emailSvc) {
		this.emailSvc = emailSvc;
	}
	
	
	///////////////////////////////////////////////////////////// 로그인
	@RequestMapping(value="login_proc.nm", method=RequestMethod.POST)
	public ModelAndView login_proc(HttpServletRequest req,
									HttpSession se,
									@RequestParam(value="login_id")String login_id,
									@RequestParam(value="login_pw")String login_pw){
		Map<String, Object> map = new HashMap<>();
		MemberVo m = memberSvc.getOneMember(login_id);
		
		if(m!=null && m.getMem_pw().equals(login_pw) && m.getDrop_out() != 1){
			se.setAttribute("loggedin", login_id);
				
				if(m.getMem_level_cd()==10){
					se.setAttribute("admin", true);
				}
			return new ModelAndView("redirect:/index.nm", map);
		}else{
			map.put("err_msg", "아이디와 비밀번호를 확인해주세요.");
			return new ModelAndView("login/login", map);
		}
	}
	
	///////////////////////////////////////////////////////////// 아이디 패스워드 찾기
	@RequestMapping(value="pop_findId.nm", method=RequestMethod.GET)
	public ModelAndView popup_findId(HttpServletRequest req){
		
		return new ModelAndView("login/login_popup");
	}
	
	// 아이디 찾기
	@RequestMapping(value="pop_findId1.nm", method=RequestMethod.POST)
	public ModelAndView popup_findId1(HttpServletRequest req, 
									@RequestParam(value="name1") String name1,
									@RequestParam(value="email1") String email1,
									@RequestParam(value="email2") String email2
									){
		String foundId;
		String email = mergeEmail(email1, email2);
		MemberVo mem =  memberSvc.getOneMember(name1, email);
		
		if(mem== null){
			foundId = "없음";
		}else{
			foundId = mem.getMem_id()!=null ? mem.getMem_id() : "없음" ;
			if(mem.getDrop_out()==1){ foundId ="탈퇴"; }
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("resultId", foundId);
		
		return new ModelAndView("login/login_popup", map);
	}
	
	// 비밀번호 찾기
	@RequestMapping(value="pop_findId2.nm", method=RequestMethod.POST)
	public ModelAndView popup_findId2(HttpServletRequest req,
									@RequestParam(value="id")String id,
									@RequestParam(value="name2")String name2,
									@RequestParam(value="email3")String email3,
									@RequestParam(value="email4")String email4
									){
		String foundPw;
		String email = mergeEmail(email3, email4);
		MemberVo mem =  memberSvc.getOneMember(name2, email);
		
		if(mem== null){
			foundPw = "없음";
		}else{

		foundPw = mem.getMem_pw()!=null? mem.getMem_pw() : "없음";
		if(!mem.getMem_id().equals(id)){ foundPw ="없음"; }
		if(mem.getDrop_out()==1){ foundPw ="탈퇴"; }
		}
		Map<String, Object> map = new HashMap<>();
		
		
		
		if(!foundPw.equals("없음") && !foundPw.equals("탈퇴")){
			emailSvc.sendMyEmail(new MyEmail("manager@naturalmom.com", email, 
										mem.getMem_name()+"님, 자연맘에서 전송한 메일입니다.", foundPw));
			foundPw = "이메일 전송";
		}
		
		map.put("resultPw", foundPw);
		return new ModelAndView("login/login_popup", map);
	}
	
	
	
	///////////////////////////////////////////////////////////// 로그아웃
	@RequestMapping(value="logout_proc.nm", method=RequestMethod.GET)
	public String logout_proc(HttpServletRequest req,
									HttpSession se){
		se.removeAttribute("loggedin");
		se.removeAttribute("admin");
		se.invalidate();
		return "redirect:/index.nm";
	}
	
	
	
	//////////////////////////////////////////////////////////// 회원가입 페이지
	
	@RequestMapping(value ="/join.nm", method=RequestMethod.POST)
	public String menu_join(HttpServletRequest req){
		return "join/membership";
	}
	
	
	// 아이디 중복확인 팝업
	@RequestMapping(value="pop_checkId.nm", method=RequestMethod.GET)
	public ModelAndView popup_checkId(HttpServletRequest req,
									@RequestParam(value="check") String id){
		boolean result = memberSvc.checkId(id);
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(result);
		System.out.println(id);
		
		if(id.equals("")){
			map.put("checking_id", id);
			map.put("flash_msg", "아이디를 입력해주세요.");
			return new ModelAndView("join/membership_pop_checkId",map);
		}else if(id.length()<6){
			map.put("checking_id", id);
			map.put("flash_msg", "아이디가 너무 짧습니다.");
			return new ModelAndView("join/membership_pop_checkId",map);
		}else if(id.length()>18){
			map.put("checking_id", id);
			map.put("flash_msg", "아이디가 너무 깁니다.");
			return new ModelAndView("join/membership_pop_checkId",map);
		}else if(result){
			map.put("checking_id", id);
			map.put("flash_msg", "사용할 수 있는 아이디입니다.");
			return new ModelAndView("join/membership_pop_checkId",map);
		}else{
			map.put("checking_id", id);
			map.put("flash_msg", "이미 사용중인 아이디입니다.");
			return new ModelAndView("join/membership_pop_checkId",map);
		}
	}
	
	// 아이디 중복확인 팝업 내 다시 중복확인
	@RequestMapping(value="checkId.nm", method=RequestMethod.GET)
	public ModelAndView checkId(HttpServletRequest req,
			@RequestParam(value="check") String id){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("check", id);
		return new ModelAndView("redirect:/pop_checkId.nm",map);
	}
	
	// 회원가입 처리
	@RequestMapping(value="join_complete.nm", method=RequestMethod.POST)
	public ModelAndView join_proc(HttpServletRequest req,
										@RequestParam(value="id") String id,
										@RequestParam(value="pw") String pw,
										@RequestParam(value="name") String name,
										@RequestParam(value="gender") int gender,
										@RequestParam(value="year") String year,
										@RequestParam(value="month") int month,
										@RequestParam(value="day") int day,
										@RequestParam(value="phone1") String phone1,
										@RequestParam(value="phone2") String phone2,
										@RequestParam(value="phone3") String phone3,
										@RequestParam(value="email1") String email1,
										@RequestParam(value="email2") String email2,
										@RequestParam(value="post_num") String post_num,
										@RequestParam(value="address") String address,
										@RequestParam(value="address_detail") String address_detail
											){		
		
		String phone= mergePhone(phone1, phone2, phone3);
		String email= mergeEmail(email1, email2);
		Date birth = mergeBirth(year, month, day);
		String address_all = mergeAddress(address, address_detail);
		
		System.out.println(memberSvc.addMember
		(new MemberVo(id, pw, name, phone, post_num, address_all, email, birth, gender)));
		
		return new ModelAndView("join/membership");
	}
	
	
	
	
	
	
	
	
	// 회원정보 수정(정보 불러오기) //////////////////////////////////////////////////////////마이페이지
	@RequestMapping(value="myinfo_edit.nm", method=RequestMethod.GET)
	public ModelAndView edit_member(HttpServletRequest req,
									HttpSession se){
		Map<String, Object> map = new HashMap<>();
		
		String id = (String)se.getAttribute(S.SESSION_LOGIN);
		MemberVo member =  memberSvc.getOneMember(id);
		String[] phone = member.getMem_phone().split("-");
		String[] email = member.getMem_email().split("@");
		String[] address = member.getMem_addr_detail().split("@");
		
		map.put("m", member);
		map.put("phone", phone);
		map.put("email", email);
		map.put("address", address);
		
		return new ModelAndView("mypage/mypage", map);
	}
	
	
	// 회원정보 수정 실행
	@RequestMapping(value="edit_complete.nm", method=RequestMethod.POST)
	public ModelAndView edit_member_proc(HttpServletRequest req,
										@RequestParam(value="id") String id,
										@RequestParam(value="pw") String pw,
										@RequestParam(value="phone1") String phone1,
										@RequestParam(value="phone2") String phone2,
										@RequestParam(value="phone3") String phone3,
										@RequestParam(value="email1") String email1,
										@RequestParam(value="email2") String email2,
										@RequestParam(value="post_num") String post_num,
										@RequestParam(value="address") String address,
										@RequestParam(value="address_detail") String address_detail ){
		String phone = mergePhone(phone1, phone2, phone3);
		String email = mergeEmail(email1, email2);
		String address_all = mergeAddress(address, address_detail);
		
		Map<String, Object> map = new HashMap<>();
		
		System.out.println
			(memberSvc.editMember(new MemberVo().edit_member_form(id, pw, phone, post_num, address_all, email)));
		
		map.put("page", "edit");
		return new ModelAndView("redirect:myinfo_edit.nm", map) ;
	}
	
	
	// 회원탈퇴
	@RequestMapping(value="dropout_proc.nm", method=RequestMethod.GET)
	public ModelAndView dropout_proceed(HttpServletRequest req,
								HttpSession se ){
		Map<String, Object> map = new HashMap<>();
		String id = (String)se.getAttribute(S.SESSION_LOGIN);
		
		System.out.println(memberSvc.removeMember(id));
		map.put("flash_msg", "정상 탈퇴처리 되었습니다. <br> 지금까지 자연맘을 이용해주셔서 감사합니다.");
		se.invalidate();
		
		return new ModelAndView("empty", map);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////관리자 회원관리
	@RequestMapping(value ="/admin/member.nm", method=RequestMethod.GET)
	public ModelAndView admin_member(HttpServletRequest req,
									HttpSession se){
		
		Map<String, Object> map = new HashMap<>();
		
		// 관리자 여부 확인
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		s_member_list = memberSvc.getAllMember();
		admin_list_format(s_member_list);
		
		map.put("member", s_member_list);
		
		return new ModelAndView("admin/member/a_member", map);
	}
	
	// SORT
	@RequestMapping(value ="/admin/member.nm", method=RequestMethod.GET, params="Lineup=true")
	public ModelAndView admin_member_sort(HttpServletRequest req,
										HttpSession se,
										@RequestParam(value="sort") String sort,
										@RequestParam(value="m") String m ){
		System.out.println(sort);
		System.out.println(m);
		Map<String, Object> map = new HashMap<>();
		
		// 관리자 여부 확인
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		map.put("member", s_member_list);
		map.put("sort", sort);
		map.put("m", m);
		
		return new ModelAndView("admin/member/a_member", map);
	}
	
	// 회원관리 검색
	@RequestMapping(value="/admin/member_search.nm", method=RequestMethod.POST)
	public ModelAndView admin_member_search(HttpServletRequest req,
											HttpSession se,
											@RequestParam(value="id") String id,
											@RequestParam(value="name") String name,
											@RequestParam(value="phone1") String phone1,
											@RequestParam(value="phone2") String phone2,
											@RequestParam(value="phone3") String phone3,
											@RequestParam(value="email1") String email1,
											@RequestParam(value="email2") String email2,
											@RequestParam(value="year") String year,
											@RequestParam(value="month") int month,
											@RequestParam(value="day") int day,
											@RequestParam(value="gender") int gender,
											@RequestParam(value="level_no") int level_no
											){
		Map<String, Object> map = new HashMap<>();
		
		// 관리자 여부 확인
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
		if(isAdmin==null || !isAdmin.booleanValue()){
			map.put("err_msg", "관리자로 로그인 바랍니다.");
			return new ModelAndView("login/login", map);
		}
		
		String phone= mergePhone(phone1, phone2, phone3);
		String email= mergeEmail(email1, email2);
		Date birth = mergeBirth(year, month, day);
		
		s_member_list = memberSvc.getMembersByCondition(id, name, phone, email, birth, gender, level_no);
		
		admin_list_format(s_member_list);
		map.put("member", s_member_list);
		
		return new ModelAndView("admin/member/a_member", map);
	}
	
	// 회원 상태 변경 처리
	@RequestMapping(value="/admin/member_manage.nm", method=RequestMethod.GET)
	public ModelAndView admin_member_manage(HttpServletRequest req,
											@RequestParam(value="proc") String proc,
											@RequestParam(value="id") String[] id){
		
		if(proc.equals("drop")){
			for(int i=0; i< id.length; i++){
				memberSvc.removeMember(id[i]);
			}
			
		}else if(proc.equals("black")){
			
			for(int i=0; i< id.length; i++){
				MemberVo one = memberSvc.getOneMember(id[i]);
			
				if(one.getMem_level_cd()==S.LEVEL_MEMBER){
					memberSvc.editMemberLevel(id[i], S.LEVEL_BLACKLIST);
				}else if(one.getMem_level_cd()==S.LEVEL_BLACKLIST){
					memberSvc.editMemberLevel(id[i], S.LEVEL_MEMBER);
				}
			}
		}
		
		
		Map<String, Object> map = new HashMap<>();
		s_member_list = memberSvc.getAllMember();
		admin_list_format(s_member_list);
		
		map.put("member", s_member_list);
		return new ModelAndView("admin/member/a_member", map);
	}
	
	
	// 관리자 비밀번호 변경
	@RequestMapping(value="/admin/edited.nm", method=RequestMethod.POST)
	public ModelAndView admin_edit_pw(HttpServletRequest req,
								HttpSession se,
								@RequestParam(value="pw") String pw){
	    Map<String, Object> map = new HashMap<>();
		Boolean isAdmin = ((Boolean)se.getAttribute(S.SESSION_ADMIN));
	    if(isAdmin==null || !isAdmin.booleanValue()){
	       map.put("err_msg", "관리자로 로그인 바랍니다.");
	       return new ModelAndView("login/login", map);
	    }
		
		String id = (String) se.getAttribute(S.SESSION_LOGIN);
		MemberVo admin = memberSvc.getOneMember(id);
		admin.setMem_pw(pw);
		memberSvc.editMember(admin);
		
		return new ModelAndView("redirect:edit.nm");
	}
	
	
	
	
	// ****************************************************************************************** method
	void admin_list_format(List<MemberVo> member_list){
		for(int i=0; i < member_list.size(); i++){
			// 주소 변환
			member_list.get(i).setMem_addr_detail
				(member_list.get(i).getMem_addr_detail().replace("@", "<br>"));
			
			// 생년월일 변환
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			member_list.get(i).setMem_pw
				(format.format(member_list.get(i).getMem_birth())); 
			
			
			// 관리자는 제외
			if( member_list.get(i).getMem_level_cd()== S.LEVEL_ADMIN){
				member_list.remove(i);
				i--;
			}
		}
	}
	
	String mergePhone(String phone1, String phone2, String phone3){
		if( !phone1.equals("") && phone1!=null
				&&!phone2.equals("") && phone2!=null
				&&!phone3.equals("") && phone3!=null ){
			return phone1 +"-"+ phone2 +"-"+ phone3;
		}else{
			return null;
		}
	}
	
	String mergeEmail(String email1, String email2){
		if ( !email1.equals("") && email1!=null
				&& !email2.equals("") && email2!=null){
			return email1 + "@" + email2;
		}else{
			return null;
		}
	}
	
	Date mergeBirth(String year, int month, int day){
		if( !year.equals("") && year !=null
				&& month != 0 && day != 0){
			int intYear = Integer.parseInt(year);
			intYear = intYear-1900;
			return new Date(intYear, month, day);
		}else{
			return null;
		}
	}
	
	String mergeAddress(String address, String address_detail){
		if( !address.equals("") && address !=null
				&& !address_detail.equals("") && address_detail !=null){
			return address+"@"+address_detail;
		}else{
			return null;
		}
		
	}
	
	


}
