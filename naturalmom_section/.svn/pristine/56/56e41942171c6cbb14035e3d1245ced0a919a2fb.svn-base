package com.nmom.soap.data.impl.board.qna;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.nmom.soap.data.dao.board.qna.IQnaReDao;
import com.nmom.soap.data.model.board.qna.QnaReVo;

public class QnaReDaoOraImpl extends NamedParameterJdbcDaoSupport implements IQnaReDao{
	
	private final String SELECT_QNA_RE = 
			"SELECT qna_re_no, qna_re_content, qna_re_write_day, mem_id FROM tb_qna_re WHERE qna_re_del_check=0 AND qna_no=:qna_no ORDER BY qna_re_no ASC";

	private final String INSERT_QNA_RE = 
			"INSERT INTO tb_qna_re (qna_re_no, qna_re_content, qna_re_write_day, qna_re_del_check, qna_no, mem_id) "
			+ "VALUES (QNA_RE_NO_SEQ.NEXTVAL, :qna_re_content, SYSDATE, 0, :qna_no, :mem_id)";

	private final String UPDATE_QNA_RE = 
			"UPDATE tb_qna_re SET qna_re_content=:qna_re_content, qna_re_write_day=SYSDATE WHERE qna_re_no=:qna_re_no";
	
	private final String DELETE_QNA_RE = 
			"UPDATE tb_qna_re SET qna_re_del_check=1 WHERE qna_re_no=:qna_re_no"; 
	
	public List<QnaReVo> getQnaReByQnaNo(int qna_no) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_no", qna_no, Types.INTEGER);
		return npjtem.query(SELECT_QNA_RE, ps, new BeanPropertyRowMapper<QnaReVo>(QnaReVo.class));
	}

	public int addQnaRe(QnaReVo qnare) throws DataAccessException {
		KeyHolder kh = new GeneratedKeyHolder();
		
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		
		ps.addValue("qna_re_content", qnare.getQna_re_content(), Types.VARCHAR);
		ps.addValue("qna_no", qnare.getQna_no(), Types.INTEGER);
		ps.addValue("mem_id", qnare.getMem_id(), Types.VARCHAR);
		
		return npjtem.update(INSERT_QNA_RE, ps, kh);

	}

	public int addQnaRe(String qna_re_content, int qna_no, String mem_id) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		
		ps.addValue("qna_re_content", qna_re_content, Types.VARCHAR);
		ps.addValue("qna_no", qna_no, Types.INTEGER);
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		
		return npjtem.update(INSERT_QNA_RE, ps);
	}

	public int editQnaRe(QnaReVo qnare) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		
		ps.addValue("qna_re_no", qnare.getQna_re_no(), Types.INTEGER);
		ps.addValue("qna_re_content", qnare.getQna_re_content(), Types.VARCHAR);
		
		return npjtem.update(UPDATE_QNA_RE, ps);
	}

	public int editQnaRe(int qna_re_no, String qna_re_content) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		
		ps.addValue("qna_re_no", qna_re_no, Types.INTEGER);
		ps.addValue("qna_re_content", qna_re_content, Types.VARCHAR);
		
		return npjtem.update(UPDATE_QNA_RE, ps);
	}

	public int removeQnaRe(QnaReVo qnare) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		
		ps.addValue("qna_re_no", qnare.getQna_re_no(), Types.INTEGER);
		
		return npjtem.update(DELETE_QNA_RE, ps);
	}

	public int removeQnaRe(int qna_re_no) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		
		ps.addValue("qna_re_no", qna_re_no, Types.INTEGER);
		
		return npjtem.update(DELETE_QNA_RE, ps);
	}

}