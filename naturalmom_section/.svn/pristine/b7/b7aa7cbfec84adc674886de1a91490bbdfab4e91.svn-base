package com.nmom.soap.data.dao.member;


import java.util.Date;
import java.util.List;

import com.nmom.soap.data.model.member.MemberVo;


public interface IMemberDao {
	
	// 아이디 찾기, 비밀번호 찾기, 로그인 체크
	MemberVo getOneMember(String id);
	MemberVo getOneMember(String name, String email);
	
	// 아이디 중복확인
	boolean checkId(String id);
	
	// 회원가입
	int addMember(MemberVo member);
	
	// 불량회원
	int editMemberLevel(String id, int level);
	
	// 회원탈퇴
	int removeMember(String id);
	
	// 회원정보 수정, 관리자 비밀번호 수정
	int editMember(MemberVo member);
	
	// 회원조회 (관리자)
	List<MemberVo> getAllMember();
	List<MemberVo> getMembersByCondition(String id, String name, String phone, String email, Date birth, int gender, int level);
}
