package com.nmom.soap.data.impl.board.qna;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nmom.soap.data.dao.board.qna.IVQnaQnareDao;
import com.nmom.soap.data.model.board.qna.VQnaQnaReVo;

public class VQnaQnareDaoOraImpl extends NamedParameterJdbcDaoSupport implements IVQnaQnareDao {

	private final String SQL_SELECT_ONE_QNA = 
			"SELECT qna_no, qna_title, qna_write_day, qna_hits, qna_content, qna_pw, qna_pos, qna_ref, mem_id, qna_re_count FROM v_qna_qnare WHERE qna_no=:qna_no";
	
	private final String SQL_SELECT_ALL_QNA_LIST = 
			"SELECT A.* FROM "
			+ "(SELECT rownum as qna_rnum, X.* FROM "
			+ "(SELECT qna_no, qna_title, qna_write_day, qna_hits, qna_pw, qna_pos, qna_ref, mem_id, qna_re_count "
			+ "FROM v_qna_qnare) X WHERE rownum <= :end) A "
			+ "WHERE A.qna_rnum > :start ORDER BY A.qna_rnum DESC";
	
	private final String SQL_SEARCH_QNA_TITLE = 
			"SELECT A.* FROM "
			+ "(SELECT rownum as qna_rnum, X.* FROM "
			+ "(SELECT qna_no, qna_title, qna_write_day, qna_hits, qna_pw, qna_pos, qna_ref, mem_id, qna_re_count "
			+ "FROM v_qna_qnare WHERE qna_title LIKE :keyword) X WHERE rownum <= :end) A "
			+ "WHERE A.qna_rnum > :start ORDER BY A.qna_rnum DESC";

	private final String SQL_SEARCH_QNA_CONTENT = 
			"SELECT A.* FROM "
			+ "(SELECT rownum as qna_rnum, X.* FROM "
			+ "(SELECT qna_no, qna_title, qna_write_day, qna_hits, qna_pw, qna_pos, qna_ref, mem_id, qna_re_count "
			+ "FROM v_qna_qnare WHERE qna_content LIKE :keyword) X WHERE rownum <= :end) A "
			+ "WHERE A.qna_rnum > :start ORDER BY A.qna_rnum DESC";
	
	private final String SQL_SEARCH_QNA_TITLE_N_CONTENT = 
			"SELECT A.* FROM "
			+ "(SELECT rownum as qna_rnum, X.* FROM "
			+ "(SELECT qna_no, qna_title, qna_write_day, qna_hits, qna_pw, qna_pos, qna_ref, mem_id, qna_re_count "
			+ "FROM v_qna_qnare WHERE (qna_title LIKE :keyword OR qna_content LIKE :keyword)) X WHERE rownum <= :end) A "
			+ "WHERE A.qna_rnum > :start ORDER BY A.qna_rnum DESC";
	
	private final String SQL_SELECT_QNA_COUNT = "SELECT COUNT(qna_no) FROM v_qna_qnare";
	
	private final String SQL_SELECT_QNA_SEARCH_TITLE_COUNT = "SELECT COUNT(qna_no) FROM v_qna_qnare WHERE qna_title LIKE :keyword";
	private final String SQL_SELECT_QNA_SEARCH_CONTENT_COUNT = "SELECT COUNT(qna_no) FROM v_qna_qnare WHERE qna_content LIKE :keyword";
	private final String SQL_SELECT_QNA_SEARCH_TITLE_N_CONTENT_COUNT = "SELECT COUNT(qna_no) FROM v_qna_qnare WHERE (qna_title LIKE :keyword OR qna_content LIKE :keyword)";
	
	public VQnaQnaReVo getOneQna(int qna_no) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_no", qna_no, Types.INTEGER);

		List<VQnaQnaReVo> qna_list = npjtem.query(SQL_SELECT_ONE_QNA, ps, new BeanPropertyRowMapper<VQnaQnaReVo>(VQnaQnaReVo.class));
		
		if(qna_list!=null && qna_list.size()==1){
			return qna_list.get(0);
		} else {
			return null;
		}
	}

	public List<VQnaQnaReVo> getAllQna(int start, int end) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("start", start, Types.INTEGER);
		ps.addValue("end", end, Types.INTEGER);

		return npjtem.query(SQL_SELECT_ALL_QNA_LIST, ps, new BeanPropertyRowMapper<VQnaQnaReVo>(VQnaQnaReVo.class));
	}

	public List<VQnaQnaReVo> searchQnaTitle(String keyword, int start, int end) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		ps.addValue("start", start, Types.INTEGER);
		ps.addValue("end", end, Types.INTEGER);

		return npjtem.query(SQL_SEARCH_QNA_TITLE, ps, new BeanPropertyRowMapper<VQnaQnaReVo>(VQnaQnaReVo.class));
	}

	public List<VQnaQnaReVo> searchQnaContent(String keyword, int start, int end) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		ps.addValue("start", start, Types.INTEGER);
		ps.addValue("end", end, Types.INTEGER);
		
		return npjtem.query(SQL_SEARCH_QNA_CONTENT, ps, new BeanPropertyRowMapper<VQnaQnaReVo>(VQnaQnaReVo.class));
	}

	public List<VQnaQnaReVo> searchQnaTitleNContent(String keyword, int start, int end) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		ps.addValue("start", start, Types.INTEGER);
		ps.addValue("end", end, Types.INTEGER);
		
		return npjtem.query(SQL_SEARCH_QNA_TITLE_N_CONTENT, ps, new BeanPropertyRowMapper<VQnaQnaReVo>(VQnaQnaReVo.class));
	}

	@Override
	public int getQnaCount() throws DataAccessException {
		return this.getJdbcTemplate().queryForInt(SQL_SELECT_QNA_COUNT);
	}

	@Override
	public int getQnaSearchTitleCount(String keyword) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		
		return npjtem.queryForInt(SQL_SELECT_QNA_SEARCH_TITLE_COUNT, ps);
	}

	@Override
	public int getQnaSearchContentCount(String keyword) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		
		return npjtem.queryForInt(SQL_SELECT_QNA_SEARCH_CONTENT_COUNT, ps);
	}

	@Override
	public int getQnaSearchTitleNContentCount(String keyword) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		
		return npjtem.queryForInt(SQL_SELECT_QNA_SEARCH_TITLE_N_CONTENT_COUNT, ps);
	}

}