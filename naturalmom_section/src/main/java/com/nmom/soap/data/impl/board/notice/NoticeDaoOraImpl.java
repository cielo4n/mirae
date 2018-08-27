package com.nmom.soap.data.impl.board.notice;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.nmom.soap.data.dao.board.notice.INoticeDao;
import com.nmom.soap.data.model.board.notice.NoticeVo;

public class NoticeDaoOraImpl extends NamedParameterJdbcDaoSupport implements INoticeDao {
	
	private final String GET_NOTICE = "SELECT * FROM tb_notice WHERE notice_no = :notice_no";

	private final String ADD_NOTICE = "INSERT INTO tb_notice "
			+ "(ntc_title, ntc_hits, ntc_content, ntc_attached_file1, ntc_attached_file2, board_id, "
			+ "mem_id, notice_no) VALUES (:ntc_title, 0, :ntc_content, :ntc_attached_file1, "
			+ ":ntc_attached_file2, :board_id, :mem_id, NOTICE_NO_SEQ.NEXTVAL)";
	
	private final String EDIT_NOTICE = "UPDATE NMDB.tb_notice SET ntc_title = :ntc_title, ntc_content = :ntc_content, "
			+ "ntc_attached_file1 = :ntc_attached_file1, ntc_attached_file2 = :ntc_attached_file2, ntc_write_day = SYSDATE  "
			+ "WHERE notice_no = :notice_no AND mem_id = :mem_id";
	
	private final String REMOVE_NOTICE = "UPDATE NMDB.tb_notice SET ntc_del_check = 1 "
			+ "WHERE notice_no = :notice_no";

	private final String INCRMENT_HIT_NOTICE = 
			"UPDATE NMDB.tb_notice SET ntc_hits = ntc_hits+1 WHERE notice_no = :notice_no";
	
	private final String PREV_NOTICE_NO = 
			"SELECT (MAX(notice_no)) as no FROM v_notice WHERE notice_no < :notice_no";
	
	private final String NEXT_NOTICE_NO = 
			"SELECT (MIN(notice_no)) as no  FROM v_notice WHERE notice_no > :notice_no";
	
	public NoticeVo getNotice(int notice_no) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("notice_no", new Integer(notice_no), Types.INTEGER);
		
		List<NoticeVo> list = getNamedParameterJdbcTemplate().query(GET_NOTICE, ps,
				BeanPropertyRowMapper.newInstance(NoticeVo.class));
		System.out.println("노티스 다오"+list.get(0));
		if( list != null && list.get(0) != null ) return list.get(0);
		return null;
	}
	
	
	public int addNotice(NoticeVo notice) throws DataAccessException {

		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("ntc_title", notice.getNtc_title(), Types.VARCHAR);
		ps.addValue("ntc_content", notice.getNtc_content(), Types.VARCHAR);
		ps.addValue("ntc_attached_file1", notice.getNtc_attached_file1(), Types.VARCHAR);
		ps.addValue("ntc_attached_file2", notice.getNtc_attached_file2(), Types.VARCHAR);
		ps.addValue("board_id", new Integer(notice.getBoard_id()), Types.INTEGER);
		ps.addValue("mem_id", notice.getMem_id(), Types.VARCHAR);
		int r = this.getNamedParameterJdbcTemplate().update(ADD_NOTICE, ps);
		return r;
	}

	
	public int editNotice(NoticeVo notice) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("ntc_title", notice.getNtc_title(), Types.VARCHAR);
		ps.addValue("ntc_content", notice.getNtc_content(), Types.VARCHAR);
		ps.addValue("ntc_attached_file1", notice.getNtc_attached_file1(), Types.VARCHAR);
		ps.addValue("ntc_attached_file2", notice.getNtc_attached_file2(), Types.VARCHAR);
		ps.addValue("notice_no", new Integer(notice.getNotice_no()), Types.INTEGER);
		ps.addValue("mem_id", notice.getMem_id(), Types.VARCHAR);
		int r = this.getNamedParameterJdbcTemplate().update(EDIT_NOTICE, ps);
		return r;
	}

	
	public int removeNotice(int notice_no) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("notice_no", new Integer(notice_no), Types.INTEGER);
		int r = this.getNamedParameterJdbcTemplate().update(REMOVE_NOTICE, ps);
		return r;
	}


	@Override
	public int incrementHit(int notice_no) {
		
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("notice_no", String.valueOf(notice_no) );
		int r = this.getNamedParameterJdbcTemplate().update(INCRMENT_HIT_NOTICE, ps);
		System.out.println("게시글"+notice_no+" 히트 "+r);
		return r;
	}


	@Override
	public int getPrevNoticeNo(int notice_no) {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("notice_no", new Integer(notice_no), Types.INTEGER);
		int r = this.getNamedParameterJdbcTemplate().
				queryForInt(PREV_NOTICE_NO, ps);
		return r;
	}

	@Override
	public int getNextNoticeNo(int notice_no) {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("notice_no", new Integer(notice_no), Types.INTEGER);
		int r = this.getNamedParameterJdbcTemplate().
				queryForInt(NEXT_NOTICE_NO, ps);
		return r;
	}
	

}
