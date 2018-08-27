package com.nmom.soap.data.impl.board.notice;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.nmom.soap.data.dao.board.notice.IVNoticeDao;
import com.nmom.soap.data.model.board.notice.VNoticeVo;

public class VNoticeDaoOraImpl extends NamedParameterJdbcDaoSupport implements IVNoticeDao {
	
	final String GET_ALL_NOTICE = 
			"SELECT A.notice_no, A.ntc_title, A.ntc_re_no, A.ntc_write_day, A.ntc_hits, A.mem_id FROM "
			+ "(SELECT rownum as no_rownum, V.notice_no, V.ntc_title, V.ntc_content, "
			+ "V.ntc_re_no, V.ntc_write_day, V.ntc_hits, V.mem_id FROM"
			+ " v_notice V) A "
			+ "WHERE A.no_rownum >= :start AND A.no_rownum <= :end";
	
	final String GET_SEARCH_BY_TITLE_NOTICE = 
			"SELECT A.notice_no, A.ntc_title, A.ntc_re_no, A.ntc_write_day, A.ntc_hits, A.mem_id FROM "
			+ "(SELECT rownum as no_rownum, V.notice_no, V.ntc_title, V.ntc_content, "
			+ "V.ntc_re_no, V.ntc_write_day, V.ntc_hits, V.mem_id FROM"
			+ " v_notice V) A "
			+ "WHERE ntc_title LIKE :search "
			+ "AND A.no_rownum >= :start AND A.no_rownum <= :end";
			
//	"SELECT notice_no,  ntc_title, ntc_re_no, ntc_write_day, ntc_hits, mem_id FROM v_notice WHERE  ntc_title LIKE '%휴무%' AND ROWNUM >= :start AND ROWNUM <= :end";
	final String GET_SEARCH_BY_CONTENT_NOTICE = 
			"SELECT A.notice_no, A.ntc_title, A.ntc_re_no, A.ntc_write_day, A.ntc_hits, A.mem_id FROM "
			+ "(SELECT rownum as no_rownum, V.notice_no, V.ntc_title, V.ntc_content, "
			+ "V.ntc_re_no, V.ntc_write_day, V.ntc_hits, V.mem_id FROM"
			+ " v_notice V) A "
			+ "WHERE ntc_content LIKE :search "
			+ "AND A.no_rownum >= :start AND A.no_rownum <= :end";
	//뷰에 콘텐트 없다.
/*	final String GET_SEARCH_BY_ID_NOTICE = 
			"SELECT A.notice_no, A.ntc_title, A.ntc_re_no, A.ntc_write_day, A.ntc_hits, A.mem_id FROM "
			+ "(SELECT rownum as no_rownum, V.notice_no, V.ntc_title, V.ntc_content, "
			+ "V.ntc_re_no, V.ntc_write_day, V.ntc_hits, V.mem_id FROM"
			+ " v_notice V) A "
			+ "WHERE mem_id LIKE :search "
			+ "AND A.no_rownum >= :start AND A.no_rownum <= :end";*/
	
	final String GET_SEARCH_BY_TITLE_N_CONTENT_NOTICE = 
			"SELECT A.notice_no, A.ntc_title, A.ntc_re_no, A.ntc_write_day, A.ntc_hits, A.mem_id FROM "
			+ "(SELECT rownum as no_rownum, V.notice_no, V.ntc_title, V.ntc_content, "
			+ "V.ntc_re_no, V.ntc_write_day, V.ntc_hits, V.mem_id FROM"
			+ " v_notice V) A "
			+ "WHERE (ntc_title LIKE :search OR ntc_content LIKE :search) "
			+ "AND A.no_rownum >= :start AND A.no_rownum <= :end";
			
	final String GET_ALL_COUNT = 
			"SELECT COUNT(notice_no) FROM v_notice";
	
	final String GET_ALL_COUNT_SEARCH_BY_TITLE_NOTICE = 
			"SELECT COUNT(notice_no) "
			+ "FROM v_notice "
			+ "WHERE ntc_title LIKE :search";
	
	final String GET_ALL_COUNT_SEARCH_BY_CONTENT_NOTICE = 
			"SELECT COUNT(notice_no) "
			+ "FROM v_notice "
			+ "WHERE ntc_content LIKE :search";
	
	final String GET_ALL_COUNT_SEARCH_BY_ID_NOTICE = 
			"SELECT COUNT(notice_no) "
			+ "FROM v_notice "
			+ "WHERE mem_id LIKE :search";
	
	final String GET_ALL_COUNT_SEARCH_BY_TITLE_N_CONTENT_NOTICE = 
			"SELECT COUNT(notice_no) "
			+ "FROM v_notice "
			+ "WHERE (ntc_title LIKE :search OR ntc_content LIKE :search)";
	
	final int LIMIT = 10; 
	
	public List<VNoticeVo> getAllNotice(int start, int end) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("start", new Integer(start), Types.INTEGER);
		ps.addValue("end", new Integer(end), Types.INTEGER);
		List<VNoticeVo> list = getNamedParameterJdbcTemplate().query(
				GET_ALL_NOTICE, 
				ps,
				BeanPropertyRowMapper.newInstance(VNoticeVo.class));
		if (list != null)
			return list;
		return null;
	}

	public List<VNoticeVo> getSearchByTitleNotice(String search, int start, int end) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("search", "%"+search+"%", Types.VARCHAR);
		ps.addValue("start", new Integer(start), Types.INTEGER);
		ps.addValue("end", new Integer(end), Types.INTEGER);
		List<VNoticeVo> list = getNamedParameterJdbcTemplate().query(
				GET_SEARCH_BY_TITLE_NOTICE, 
				ps,
				BeanPropertyRowMapper.newInstance(VNoticeVo.class));
		if (list != null)
			return list;
		return null;
	}

	public List<VNoticeVo> getSearchByContentNotice(String search, int start, int end) throws DataAccessException {
		// TODO Auto-generated method stub
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("search", "%"+search+"%", Types.VARCHAR);
		ps.addValue("start", new Integer(start), Types.INTEGER);
		ps.addValue("end", new Integer(end), Types.INTEGER);
		List<VNoticeVo> list = getNamedParameterJdbcTemplate().query(
				GET_SEARCH_BY_CONTENT_NOTICE,
				ps,
				BeanPropertyRowMapper.newInstance(VNoticeVo.class));
		if (list != null)
			return list;
		return null;
	}
/*
	public List<VNoticeVo> getSearchByIdNotice(String search, int start, int end) throws DataAccessException {
		// TODO Auto-generated method stub
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("search", "%"+search+"%", Types.VARCHAR);
		ps.addValue("start", new Integer(start), Types.INTEGER);
		ps.addValue("end", new Integer(end), Types.INTEGER);
		List<VNoticeVo> list = getNamedParameterJdbcTemplate().query(
				GET_SEARCH_BY_ID_NOTICE,
				ps,
				BeanPropertyRowMapper.newInstance(VNoticeVo.class));
		if (list != null)
			return list;
		return null;
	}*/


	public List<VNoticeVo> getSearchByTitleNContentNotice(String search, int start, int end) throws DataAccessException {
		// TODO Auto-generated method stub
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("search", "%"+search+"%", Types.VARCHAR);
		ps.addValue("start", new Integer(start), Types.INTEGER);
		ps.addValue("end", new Integer(end), Types.INTEGER);
		List<VNoticeVo> list = getNamedParameterJdbcTemplate().query(
				GET_SEARCH_BY_TITLE_N_CONTENT_NOTICE,
				ps,
				BeanPropertyRowMapper.newInstance(VNoticeVo.class));
		if (list != null)
			return list;
		return null;
	}

	public int getAllCount() throws DataAccessException {
		return getJdbcTemplate().queryForInt(GET_ALL_COUNT);
	}

	@Override
	public int getAllCountByTitle(String search) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("search", "%"+search+"%", Types.VARCHAR);
		return getNamedParameterJdbcTemplate().queryForInt(
				GET_ALL_COUNT_SEARCH_BY_TITLE_NOTICE,
				ps);
	}

	@Override
	public int getAllCountByContent(String search) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("search", "%"+search+"%", Types.VARCHAR);
		return getNamedParameterJdbcTemplate().queryForInt(
				GET_ALL_COUNT_SEARCH_BY_CONTENT_NOTICE,
				ps);
	}

	@Override
	public int getAllCountById(String search) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("search", "%"+search+"%", Types.VARCHAR);
		return getNamedParameterJdbcTemplate().queryForInt(
				GET_ALL_COUNT_SEARCH_BY_ID_NOTICE,
				ps);
	}

	@Override
	public int getAllCountByTitleNContent(String search) throws DataAccessException {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("search", "%"+search+"%", Types.VARCHAR);
		return getNamedParameterJdbcTemplate().queryForInt(
				GET_ALL_COUNT_SEARCH_BY_TITLE_N_CONTENT_NOTICE,
				ps);
	}
}
