package com.nmom.soap.data.impl.board.notice;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.nmom.soap.data.dao.board.notice.INoticeReDao;
import com.nmom.soap.data.model.board.notice.NoticeReVo;

public class NoticeReDaoOraImpl extends NamedParameterJdbcDaoSupport implements INoticeReDao {
	
	final String GET_ALL_NOTICE_RE = 
			"SELECT * FROM tb_notice_re WHERE notice_no = ? AND ntc_re_del_check = 0";
	
	final String GET_ONE_NOTICE_RE = 
			"SELECT * FROM tb_notice_re WHERE notice_re_no = ?";
	
	final String ADD_NOTICE_RE = "INSERT INTO "
			+ "tb_notice_re (ntc_re_content, ntc_re_write_day, ntc_re_del_check, notice_no, mem_id, notice_re_no) "
			+ "VALUES (:ntc_re_content, SYSDATE, 0, :notice_no, :mem_id, NOTICE_RE_NO_SEQ.NEXTVAL)";
	
	final String EDIT_NOTICE_RE = 
			"UPDATE NMDB.tb_notice_re SET ntc_re_content = :ntc_re_content, ntc_re_write_day = SYSDATE "
			+ "WHERE notice_re_no = :notice_re_no AND mem_id = :mem_id";
	
	final String REMOVE_NOTICE_RE = 
			"UPDATE NMDB.tb_notice_re SET ntc_re_del_check = 1 "
			+ "WHERE notice_re_no = :notice_re_no AND mem_id = :mem_id";
	
	
	public List<NoticeReVo> getAllNoticeRe(int notice_no) throws DataAccessException {
		return getJdbcTemplate().query(GET_ALL_NOTICE_RE, 
				BeanPropertyRowMapper.newInstance(NoticeReVo.class), 
				notice_no);
	}

	
	public int addNoticeRe(NoticeReVo notice_re) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("ntc_re_content", notice_re.getNtc_re_content(), Types.VARCHAR);
		ps.addValue("notice_no", new Integer(notice_re.getNotice_no()), Types.INTEGER);
		ps.addValue("mem_id", notice_re.getMem_id(), Types.VARCHAR);
		int r = this.getNamedParameterJdbcTemplate().update(ADD_NOTICE_RE, ps);
		return r;
	}

	
	public int editNoticeRe(NoticeReVo notice_re) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("ntc_re_content", notice_re.getNtc_re_content(), Types.VARCHAR);
		ps.addValue("notice_re_no", new Integer(notice_re.getNotice_re_no()), Types.INTEGER);
		ps.addValue("mem_id", notice_re.getMem_id(), Types.VARCHAR);
		int r = this.getNamedParameterJdbcTemplate().update(EDIT_NOTICE_RE, ps);
		return r;
	}

	
	public int removeNoticeRe(int notice_re_no, String mem_id) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("notice_re_no", new Integer(notice_re_no), Types.INTEGER);
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		int r = this.getNamedParameterJdbcTemplate().update(REMOVE_NOTICE_RE, ps);
		return r;
	}


	@Override
	public NoticeReVo getOneNoticeRe(int notice_re_no) {
		List<NoticeReVo> list = getJdbcTemplate().query(GET_ONE_NOTICE_RE, 
				BeanPropertyRowMapper.newInstance(NoticeReVo.class), 
				notice_re_no);
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}

	
}
