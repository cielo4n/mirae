package com.nmom.soap.data.impl.board.event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nmom.soap.data.dao.board.event.IEventDao;
import com.nmom.soap.data.model.board.event.EventVo;


public class EventDaoOraImpl extends NamedParameterJdbcDaoSupport implements IEventDao {
	
	NamedParameterJdbcTemplate nameTemplate;
	JdbcTemplate jtem;
	
	// SQL
	private final String SQL_EVENT_SELECT_ALL ="SELECT * FROM TB_EVENT";
	private final String SQL_EVENT_SELECT_LIST ="SELECT * FROM NMDB.V_EVENT_LIST";
	private final String SQL_EVNET_SELECT_LIST_START_END 
		="SELECT A.* FROM (SELECT rownum as evt_rnum, V.* from V_EVENT_LIST V ORDER BY V.EVENT_NO DESC) A "
				+ "WHERE A.evt_rnum >= ? AND A.evt_rnum <= ?";
	
	private final String SQL_EVENT_SELECT_ONE 
		= "SELECT * FROM tb_event WHERE evt_del_check=0 and event_no=?";
	private final String SQL_EVENT_SELECT_ONE_BY_ROWNUM
		= "SELECT * FROM NMDB.V_EVENT_LIST_RN WHERE EVT_RNUM = ?";
	
	private final String SQL_EVENT_SELECT_BY_TITLE 
		="SELECT A.* FROM (SELECT rownum as evt_rnum, V.* from V_EVENT_LIST V ORDER BY V.EVENT_NO DESC) A WHERE evt_title LIKE ?";
	private final String SQL_EVENT_SELECT_BY_CONTENT 
		="SELECT A.* FROM (SELECT rownum as evt_rnum, V.* from V_EVENT_LIST V ORDER BY V.EVENT_NO DESC) A WHERE evt_content LIKE ?";
	private final String SQL_EVENT_SELECT_BY_TITLE_AND_CONTENT 
		="SELECT A.* FROM (SELECT rownum as evt_rnum, V.* from V_EVENT_LIST V ORDER BY V.EVENT_NO DESC) A WHERE (evt_title LIKE ? OR evt_content LIKE ?)";
	
	private final String SQL_EVENT_INSERT 
		="INSERT INTO tb_event VALUES(EVENT_NO_SEQ.NEXTVAL, :evt_title, SYSDATE, 1, :evt_content, 0, 2, :mem_id)";
	private final String SQL_EVENT_UPDATE_DEL_CD 
		="UPDATE tb_event SET evt_del_check=1 WHERE event_no=?";
	private final String SQL_EVENT_UPDATE_CONTENT 
		="UPDATE tb_event SET evt_write_day=SYSDATE, evt_title=:evt_title, evt_content=:evt_content WHERE event_no=:event_no";
	private final String SQL_EVENT_UPDATE_HITS
		="UPDATE tb_event SET evt_hits=evt_hits+1 WHERE event_no=?";
	
	
	
	// Method
	@Override			// 모든 이벤트	
	public List<EventVo> getAllEvents() {
		jtem =getJdbcTemplate();
		
		return jtem.query(SQL_EVENT_SELECT_ALL,
				new BeanPropertyRowMapper<EventVo>(EventVo.class));
	}
	
	@Override			// 이벤트 리스트
	public List<EventVo> getEventList() {
		jtem = getJdbcTemplate();
		return jtem.query(SQL_EVENT_SELECT_LIST,
						new Object[]{}, new RowMapper<EventVo>() {
							@Override
							public EventVo mapRow(ResultSet rs, int arg1) throws SQLException {
								EventVo event_list = new EventVo();
								event_list.setEvent_no(rs.getInt("event_no") );
								event_list.setEvt_title(rs.getString("evt_title") );
								event_list.setMem_id(rs.getString("mem_id") );
								event_list.setEvt_write_day(rs.getDate("evt_write_day") );
								event_list.setEvt_hits(rs.getInt("evt_hits") );
								event_list.setCount_re(rs.getInt("count_re") );
								
								return event_list;	}
							});
	}
	@Override
	public List<EventVo> getEventList(int start, int end) {
		jtem = getJdbcTemplate();
		return jtem.query(SQL_EVNET_SELECT_LIST_START_END,
						new Object[]{new Integer(start), new Integer(end)}, new RowMapper<EventVo>() {
							@Override
							public EventVo mapRow(ResultSet rs, int arg1) throws SQLException {
								EventVo event_list = new EventVo();
								event_list.setEvent_no(rs.getInt("event_no") );
								event_list.setEvt_title(rs.getString("evt_title") );
								event_list.setMem_id(rs.getString("mem_id") );
								event_list.setEvt_write_day(rs.getDate("evt_write_day") );
								event_list.setEvt_hits(rs.getInt("evt_hits") );
								event_list.setCount_re(rs.getInt("count_re") );
								event_list.setEvt_rnum(rs.getInt("evt_rnum"));
								
								return event_list;	}
							});
	}

	
	
	@Override	// 게시글 읽기
	public EventVo getOneEvent(int event_no) {
		jtem = getJdbcTemplate();
		List<EventVo> e_list = jtem.query(SQL_EVENT_SELECT_ONE,
				new Object[]{event_no}, new RowMapper<EventVo>() {
					@Override
					public EventVo mapRow(ResultSet rs, int arg1) throws SQLException {
						EventVo event = new EventVo();
						event.setEvent_no(rs.getInt("event_no") );
						event.setEvt_title(rs.getString("evt_title") );
						event.setEvt_write_day(rs.getDate("evt_write_day") );
						event.setEvt_hits(rs.getInt("evt_hits") );
						event.setEvt_content(rs.getString("evt_content"));
						event.setMem_id(rs.getString("mem_id") );
						event.setBoard_id(rs.getInt("board_id"));
						return event;	}
					});
		
		if(e_list !=null && e_list.size()==1){
			return e_list.get(0);
		}else{
			return null;
		}
		
	}
	
	
	@Override	// 로우넘으로 검색
	public EventVo getOneEventByRn(int evt_rnum) throws DataAccessException {
		return jtem.query(SQL_EVENT_SELECT_ONE_BY_ROWNUM, 
							new BeanPropertyRowMapper<EventVo>(EventVo.class), evt_rnum).get(0);
	}
	

	
	@Override	// 제목으로 검색
	public List<EventVo> getEvents_by_title(String search) throws DataAccessException {
		jtem = getJdbcTemplate();
		return jtem.query(SQL_EVENT_SELECT_BY_TITLE,
						new Object[]{"%"+search+"%"}, new RowMapper<EventVo>() {
							@Override
							public EventVo mapRow(ResultSet rs, int arg1) throws SQLException {
								EventVo event_list = new EventVo();
								event_list.setEvent_no(rs.getInt("event_no") );
								event_list.setEvt_title(rs.getString("evt_title") );
								event_list.setMem_id(rs.getString("mem_id") );
								event_list.setEvt_write_day(rs.getDate("evt_write_day") );
								event_list.setEvt_hits(rs.getInt("evt_hits") );
								event_list.setCount_re(rs.getInt("count_re") );
								event_list.setEvt_rnum(rs.getInt("evt_rnum"));
								
								return event_list;	}
							});
	}

	@Override	// 내용으로 검색
	public List<EventVo> getEvents_by_content(String search) throws DataAccessException {
		jtem = getJdbcTemplate();
		return jtem.query(SQL_EVENT_SELECT_BY_CONTENT,
						new Object[]{"%"+search+"%"}, new RowMapper<EventVo>() {
							@Override
							public EventVo mapRow(ResultSet rs, int arg1) throws SQLException {
								EventVo event_list = new EventVo();
								event_list.setEvent_no(rs.getInt("event_no") );
								event_list.setEvt_title(rs.getString("evt_title") );
								event_list.setMem_id(rs.getString("mem_id") );
								event_list.setEvt_write_day(rs.getDate("evt_write_day") );
								event_list.setEvt_hits(rs.getInt("evt_hits") );
								event_list.setCount_re(rs.getInt("count_re") );
								event_list.setEvt_rnum(rs.getInt("evt_rnum"));
								
								return event_list;	}
							});
	}

	@Override	// 제목+내용으로 검색
	public List<EventVo> getEvents_by_title_n_content(String search) throws DataAccessException {
		jtem = getJdbcTemplate();
		return jtem.query(SQL_EVENT_SELECT_BY_TITLE_AND_CONTENT,
						new Object[]{"%"+search+"%", "%"+search+"%"}, new RowMapper<EventVo>() {
							@Override
							public EventVo mapRow(ResultSet rs, int arg1) throws SQLException {
								EventVo event_list = new EventVo();
								event_list.setEvent_no(rs.getInt("event_no") );
								event_list.setEvt_title(rs.getString("evt_title") );
								event_list.setMem_id(rs.getString("mem_id") );
								event_list.setEvt_write_day(rs.getDate("evt_write_day") );
								event_list.setEvt_hits(rs.getInt("evt_hits") );
								event_list.setCount_re(rs.getInt("count_re") );
								event_list.setEvt_rnum(rs.getInt("evt_rnum"));
								
								return event_list;	}
							});
	}
	

	@Override	// 글쓰기
	public int addEvent(EventVo event) throws DataAccessException {
		nameTemplate = getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("evt_title", event.getEvt_title());
		ps.addValue("evt_content", event.getEvt_content());
		ps.addValue("mem_id", event.getMem_id());
		
		return nameTemplate.update(SQL_EVENT_INSERT, ps);
	}

	@Override	// 글삭제
	public int removeEvent(int event_no) throws DataAccessException {
		jtem = getJdbcTemplate();
		return jtem.update(SQL_EVENT_UPDATE_DEL_CD, new Object[]{new Integer(event_no)});
	}
	
	@Override // 글 수정
	public int editEvent(EventVo event) throws DataAccessException {
		nameTemplate = getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("evt_title", event.getEvt_title());
		ps.addValue("evt_content", event.getEvt_content());
		ps.addValue("event_no", event.getEvent_no());
		
		return nameTemplate.update(SQL_EVENT_UPDATE_CONTENT, ps);
	}
	
	@Override
	public int addReadCount(int event_no) throws DataAccessException {
		jtem = getJdbcTemplate();
		return jtem.update(SQL_EVENT_UPDATE_HITS, event_no);
	}

}
