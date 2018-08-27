package com.nmom.soap.data.impl.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nmom.soap.data.dao.member.IMemberDao;
import com.nmom.soap.data.model.member.MemberVo;


public class MemberDaoOraImpl extends NamedParameterJdbcDaoSupport implements IMemberDao {
	
	NamedParameterJdbcTemplate nameTemplate;
	JdbcTemplate jtem;
	
	// SQL Query
	private final String SQL_MEMBER_SELECT_ONE_BY_ID 
				= "SELECT * FROM TB_MEMBER WHERE MEM_ID=?";
	private final String SQL_MEMBER_SELECT_ONE_BY_NAME_AND_EMAIL 
				= "SELECT * FROM TB_MEMBER	WHERE MEM_NAME =? and MEM_EMAIL=?";
	private final String SQL_MEMBER_SELECT_ID ="select mem_id from tb_member";
	private final String SQL_MEMBER_INSERT 
		="insert into tb_member values (:mem_id, :mem_pw, :mem_name, :mem_phone, :mem_addr_post, :mem_addr_detail, :mem_email, :mem_birth, :mem_gender, 0, 1)";
	private final String SQL_MEMBER_UPDATE_LEVEL_CD ="UPDATE NMDB.tb_member SET mem_level_cd=? WHERE mem_id=?";
	private final String SQL_MEMBER_UPDATE_DROP_OUT = "UPDATE NMDB.tb_member SET drop_out = 1 WHERE mem_id=?";
	private final String SQL_MEMBER_UPDATE_INFO 
		="UPDATE NMDB.tb_member SET "
				+ "mem_pw=:mem_pw, mem_phone=:mem_phone, mem_addr_post=:mem_addr_post, mem_addr_detail=:mem_addr_detail, mem_email=:mem_email "
				+ "WHERE mem_id=:mem_id";
	private final String SQL_MEMBER_SELECT_ALL ="SELECT * FROM TB_MEMBER WHERE drop_out = 0";
	private final String SQL_MEMBER_SELECT_BY_CONDITION 
		="SELECT mem_id, mem_name, mem_addr_detail, mem_phone, mem_email, "
				+ "mem_birth, mem_gender, MEM_LEVEL_CD FROM tb_member WHERE (drop_out='0' ";
			
			
			
	// Constructor
	public MemberDaoOraImpl() {

	}
	

	//Overriding Method
	@Override		// 비밀번호 찾기, 로그인 체크, 회원정보 수정 불러오기
	public MemberVo getOneMember(String id) {
		jtem = getJdbcTemplate();
		List<MemberVo> member_list = jtem.query(SQL_MEMBER_SELECT_ONE_BY_ID, 
						new RowMapper<MemberVo>(){
			@Override
			public MemberVo mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberVo member = new MemberVo(
													rs.getString("mem_id"), 
													rs.getString("mem_pw"), 
													rs.getString("mem_name"), 
													rs.getString("mem_phone"), 
													rs.getString("mem_addr_post"), 
													rs.getString("mem_addr_detail"), 
													rs.getString("mem_email"), 
													rs.getDate("mem_birth"), 
													rs.getInt("mem_gender"), 
													rs.getInt("drop_out"), 
													rs.getInt("mem_level_cd"));
				return member;
				}
			}, id );
		
		if( member_list != null && member_list.size() == 1 )
			return member_list.get(0);
		else
			return null;
	}
	
	
	
	@Override		// 아이디 찾기,
	public MemberVo getOneMember(String name, String email) {
		jtem = getJdbcTemplate();
		List<MemberVo> member_list = jtem.query(SQL_MEMBER_SELECT_ONE_BY_NAME_AND_EMAIL, 
						new RowMapper<MemberVo>(){
			@Override
			public MemberVo mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberVo member = new MemberVo(
													rs.getString("mem_id"), 
													rs.getString("mem_pw"), 
													rs.getString("mem_name"), 
													rs.getString("mem_phone"), 
													rs.getString("mem_addr_post"), 
													rs.getString("mem_addr_detail"), 
													rs.getString("mem_email"), 
													rs.getDate("mem_birth"), 
													rs.getInt("mem_gender"), 
													rs.getInt("drop_out"), 
													rs.getInt("mem_level_cd"));
				return member;
				}
			}, new Object[]{ name, email } );
		
		if( member_list != null && member_list.size() == 1 )
			return member_list.get(0);
		else
			return null;
	}

	
@Override		// 아이디 중복 확인
public boolean checkId(String id) {
	jtem = getJdbcTemplate();
	List<MemberVo> mem_list = jtem.query(SQL_MEMBER_SELECT_ID, new RowMapper<MemberVo>() {
		@Override
		public MemberVo mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberVo mem = new MemberVo();
			mem.setMem_id(rs.getString("mem_id"));
			return mem;
		}
	});
	
	for(MemberVo m:mem_list){
		if(m.getMem_id().equals(id)){
			return false;
		}
	}
	return true;
}


	@Override	// 회원가입
	public int addMember(MemberVo member) {
		nameTemplate = getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();

		ps.addValue("mem_id", member.getMem_id(), Types.VARCHAR);
		ps.addValue("mem_pw", member.getMem_pw(), Types.VARCHAR);
		ps.addValue("mem_name", member.getMem_name(), Types.VARCHAR);
		ps.addValue("mem_phone", member.getMem_phone(), Types.VARCHAR);
		ps.addValue("mem_addr_post", member.getMem_addr_post(), Types.VARCHAR);
		ps.addValue("mem_addr_detail", member.getMem_addr_detail(), Types.VARCHAR);
		ps.addValue("mem_email", member.getMem_email(), Types.VARCHAR);
		ps.addValue("mem_birth", member.getMem_birth(), Types.DATE);
		ps.addValue("mem_gender", member.getMem_gender(), Types.INTEGER);

		return nameTemplate.update(SQL_MEMBER_INSERT, ps);
	}

	
	
	@Override		// 회원등급 변경 (관리자:10/일반회원:1/불량회원:2)
	public int editMemberLevel(String id, int level) {
		jtem = getJdbcTemplate();
		
		return jtem.update(SQL_MEMBER_UPDATE_LEVEL_CD, 
				new Object[]{ new Integer(level), id }, 
				new int[]{Types.INTEGER, Types.VARCHAR});
	}

	
	
	@Override		// 회원 탈퇴 (사용자, 관리자)
	public int removeMember(String id) {
		jtem = getJdbcTemplate();
		
		return jtem.update(SQL_MEMBER_UPDATE_DROP_OUT, id);
	}

	
	
	@Override	// 회원정보 수정
	public int editMember(MemberVo member) {
		nameTemplate = getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();

		ps.addValue("mem_pw", member.getMem_pw(), Types.VARCHAR);
		ps.addValue("mem_phone", member.getMem_phone(), Types.VARCHAR);
		ps.addValue("mem_addr_post", member.getMem_addr_post(), Types.VARCHAR);
		ps.addValue("mem_addr_detail", member.getMem_addr_detail(), Types.VARCHAR);
		ps.addValue("mem_email", member.getMem_email(), Types.VARCHAR);
		ps.addValue("mem_id", member.getMem_id(), Types.VARCHAR);
		
		return nameTemplate.update(SQL_MEMBER_UPDATE_INFO, ps);
	}

	@Override
	public List<MemberVo> getAllMember() {
		jtem =getJdbcTemplate();
		
		return jtem.query(SQL_MEMBER_SELECT_ALL,
				new BeanPropertyRowMapper<MemberVo>(MemberVo.class));
	}
	

	@Override
	public List<MemberVo> getMembersByCondition(String id, String name, String phone, 
			String email, Date birth, int gender, int level) {
		
		nameTemplate = getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(SQL_MEMBER_SELECT_BY_CONDITION);
		
		if(id!=null && !(id.equals("")) && !(id.isEmpty())){
			buffer.append("AND mem_id LIKE :mem_id ");
			ps.addValue("mem_id", "%"+id+"%"); }
		
		if(name!=null && !(name.equals("")) && !(name.isEmpty())){
			buffer.append("AND mem_name LIKE :mem_name ");
			ps.addValue("mem_name",  "%"+name+"%"); }
		
		if(phone!=null && !(phone.equals("")) && !(phone.isEmpty())){
			buffer.append("AND mem_phone=:mem_phone ");
			ps.addValue("mem_phone", phone); }
		
		if(email!=null && !(email.equals("")) && !(email.isEmpty())){
			buffer.append("AND mem_email=:mem_email ");
			ps.addValue("mem_email", email); }
		
		if(birth!=null && !(birth.equals("")) ){
			buffer.append("AND mem_birth=:mem_birth ");
			ps.addValue("mem_birth", birth); }
		
		if(gender!=0 ){
			buffer.append("AND mem_gender=:mem_gender ");
			ps.addValue("mem_gender", gender); }
		
		if(level!=0){
			buffer.append("AND mem_level_cd=:mem_level_cd ");
			ps.addValue("mem_level_cd", level); }
		buffer.append(")");
		
		
		return nameTemplate.query(buffer.toString(), ps, new RowMapper<MemberVo>() {
			@Override
			public MemberVo mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberVo member= new MemberVo();
				member.setMem_id(rs.getString("mem_id") );
				member.setMem_name(rs.getString("mem_name") );
				member.setMem_addr_detail(rs.getString("mem_addr_detail") );
				member.setMem_phone(rs.getString("mem_phone") );
				member.setMem_email(rs.getString("mem_email") );
				member.setMem_birth(rs.getDate("mem_birth"));
				member.setMem_gender(rs.getInt("mem_gender") );
				member.setMem_level_cd(rs.getInt("mem_level_cd") );
				
				return member;
			}
		});
	}


}
