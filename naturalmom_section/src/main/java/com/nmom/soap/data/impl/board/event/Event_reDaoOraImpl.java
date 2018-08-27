package com.nmom.soap.data.impl.board.event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nmom.soap.data.dao.board.event.IEvent_reDao;
import com.nmom.soap.data.model.board.event.Event_reVo;



public class Event_reDaoOraImpl extends NamedParameterJdbcDaoSupport implements IEvent_reDao {
	
	NamedParameterJdbcTemplate nameTemplate;
	JdbcTemplate jtem;
	
	private final String SQL_EVENT_RE_SELECT_LIST 
		= "SELECT mem_id, evt_re_content, evt_re_write_day, EVENT_RE_NO, evt_no FROM tb_event_re "
				+ "WHERE evt_re_del_check=0 AND evt_no = ? ORDER BY EVENT_RE_NO ASC";
	private final String SQL_EVENT_RE_INSERT = "INSERT INTO tb_event_re VALUES(EVENT_RE_NO_SEQ.NEXTVAL, :evt_re_content, SYSDATE, 0, :evt_no, :mem_id)";
	private final String SQL_EVENT_RE_UPDATE_DEL_CD = "UPDATE tb_event_re SET evt_re_del_check=1 WHERE event_re_no=?";
	private final String SQL_EVENT_RE_SELECT_ONE = "SELECT * FROM tb_event_re WHERE event_re_no=?";


	@Override	// 댓글 불러오기
	public List<Event_reVo> getEventRe(int event_no) {
		jtem = getJdbcTemplate();
		return jtem.query(SQL_EVENT_RE_SELECT_LIST,
						new Object[]{ event_no }, new RowMapper<Event_reVo>() {
							@Override
							public Event_reVo mapRow(ResultSet rs, int arg1) throws SQLException {
								Event_reVo event_re = new Event_reVo();
								event_re.setMem_id(rs.getString("mem_id") );
								event_re.setEvt_re_content(rs.getString("evt_re_content") );
								event_re.setEvt_re_write_day(rs.getDate("evt_re_write_day") );
								event_re.setEvent_re_no(rs.getInt("EVENT_RE_NO") );
								event_re.setEvt_no(rs.getInt("evt_no"));
								return event_re;	}
							});
	}
	
	@Override
	public Event_reVo getOneRe(int event_re_no) {
		return getJdbcTemplate().queryForObject(SQL_EVENT_RE_SELECT_ONE,
										new BeanPropertyRowMapper<Event_reVo>(Event_reVo.class),
										event_re_no);
	}

	
	
	@Override	// 댓글쓰기
	public int addRe(Event_reVo re) {
		nameTemplate = getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("evt_re_content", re.getEvt_re_content());
		ps.addValue("evt_no", re.getEvt_no());
		ps.addValue("mem_id", re.getMem_id());
		
		return nameTemplate.update(SQL_EVENT_RE_INSERT, ps);
	}


	@Override	// 댓글 삭제
	public int removeRe(int event_re_no) {
		jtem = getJdbcTemplate();
		return jtem.update(SQL_EVENT_RE_UPDATE_DEL_CD, new Object[]{new Integer(event_re_no)});
	}


}
