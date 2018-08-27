package com.nmom.soap.data.impl.board.qna;

import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nmom.soap.data.dao.board.qna.IQnaDao;
import com.nmom.soap.data.model.board.qna.QnaVo;

public class QnaDaoOraImpl extends NamedParameterJdbcDaoSupport implements IQnaDao{
	private final String SQL_SECRET_PW_CHECK="SELECT COUNT(qna_no) FROM tb_qna WHERE qna_no=:qna_no AND qna_pw=:qna_pw";
	
	private final String SQL_INSERT_QNA = 
	"INSERT INTO tb_qna (qna_no, qna_title, qna_write_day, qna_hits, qna_content, qna_del_check, qna_pw, qna_pos, qna_ref, board_id, mem_id) "
	+ "VALUES (QNA_NO_SEQ.NEXTVAL,:qna_title, SYSDATE, 0, :qna_content, 0, :qna_pw, 0, QNA_NO_SEQ.CURRVAL, 4, :mem_id)";
	
	private final String SQL_INSERT_QNA_ANSWER = 
	"INSERT INTO tb_qna (qna_no, qna_title, qna_write_day, qna_hits, qna_content, qna_del_check, qna_pw, qna_pos, qna_ref, board_id, mem_id) "
	+ "VALUES (QNA_NO_SEQ.NEXTVAL,:qna_title, SYSDATE, 0, :qna_content, 0, :qna_pw, :qna_pos, :qna_ref, 4, :mem_id)";
	
	private final String SQL_UPDATE_QNA = "UPDATE tb_qna SET qna_title=:qna_title, qna_content=:qna_content, qna_pw=:qna_pw WHERE qna_no=:qna_no";
	
	private final String SQL_DELETE_QNA = "UPDATE tb_qna SET qna_del_check=1 WHERE qna_no=:qna_no";
	private final String SQL_DELETE_QNA_BY_REF = "UPDATE tb_qna SET qna_del_check=1 WHERE qna_ref=:qna_ref";
	
	private final String SQL_SELECT_ONE_SIMPLE_QNA = "SELECT qna_no, qna_title, mem_id, qna_pw, qna_content FROM tb_qna WHERE qna_no=:qna_no";
	
	private final String SQL_INCREASE_QNA_HITS = "UPDATE tb_qna SET qna_hits = qna_hits+1 WHERE qna_no=:qna_no";
	
	private final String SQL_PUSH_REAR_POS = "UPDATE tb_qna SET qna_pos=qna_pos+1 WHERE qna_ref=:qna_ref AND qna_pos>:qna_pos";
	private final String SQL_PUSH_FRONT_POS = "UPDATE tb_qna SET qna_pos=qna_pos-1 WHERE qna_ref=:qna_ref AND qna_pos>:qna_pos";
	
	private final String SQL_SELECT_SIMPLE_QNA_BY_REF_N_POS = "SELECT qna_no, qna_title, qna_ref, qna_pos from tb_qna WHERE qna_pos=:qna_pos AND qna_ref=:qna_ref";
	
	public boolean secretQnaPwCheck(int qna_no, String qna_pw) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_no", qna_no, Types.INTEGER);
		ps.addValue("qna_pw", qna_pw, Types.VARCHAR);
		int r = npjtem.queryForInt(SQL_SECRET_PW_CHECK, ps);
		
		if(r == 1) return true;
		else return false;
	}

	public int addQna(String qna_title, String qna_content, String qna_pw, String mem_id) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_title", qna_title, Types.VARCHAR);
		ps.addValue("qna_content", qna_content, Types.VARCHAR);
		ps.addValue("qna_pw", qna_pw, Types.VARCHAR);
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		
		return npjtem.update(SQL_INSERT_QNA, ps);
	}

	public int addQnaAnswer(String qna_title, String qna_content, String qna_pw, String mem_id, int qna_pos, int qna_ref) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_title", qna_title, Types.VARCHAR);
		ps.addValue("qna_content", qna_content, Types.VARCHAR);
		ps.addValue("qna_pw", qna_pw, Types.VARCHAR);
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		ps.addValue("qna_pos", qna_pos, Types.INTEGER);
		ps.addValue("qna_ref", qna_ref, Types.INTEGER);
		
		return npjtem.update(SQL_INSERT_QNA_ANSWER, ps);
	}

	public int editQna(QnaVo qna) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		
		ps.addValue("qna_no", qna.getQna_no(), Types.INTEGER);
		ps.addValue("qna_title", qna.getQna_title(), Types.VARCHAR);
		ps.addValue("qna_content", qna.getQna_content(), Types.VARCHAR);
		ps.addValue("qna_pw", qna.getQna_pw(), Types.VARCHAR);
		
		return npjtem.update(SQL_UPDATE_QNA, ps);
	}

	public int editQna(int qna_no, String qna_title, String qna_content, String qna_pw) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		
		ps.addValue("qna_no", qna_no, Types.INTEGER);
		ps.addValue("qna_title", qna_title, Types.VARCHAR);
		ps.addValue("qna_content", qna_content, Types.VARCHAR);
		ps.addValue("qna_pw", qna_pw, Types.VARCHAR);
		
		return npjtem.update(SQL_UPDATE_QNA, ps);
	}

	public int removeQna(int qna_no) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_no", qna_no);

		return npjtem.update(SQL_DELETE_QNA, ps);
	}

	public int removeQnaByRef(int qna_ref) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_ref", qna_ref);

		return npjtem.update(SQL_DELETE_QNA_BY_REF, ps);
	}

	@Override
	public QnaVo getOneSimpleQna(int qna_no) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_no", qna_no, Types.INTEGER);

		return npjtem.queryForObject(SQL_SELECT_ONE_SIMPLE_QNA, ps, new BeanPropertyRowMapper<QnaVo>(QnaVo.class));
	}

	@Override
	public int increaseQnaHits(int qna_no) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_no", qna_no, Types.INTEGER);

		return npjtem.update(SQL_INCREASE_QNA_HITS, ps);
	}

	@Override
	public int pushRearPos(int qna_parent_ref, int qna_parent_pos) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_ref", qna_parent_ref, Types.INTEGER);
		ps.addValue("qna_pos", qna_parent_pos, Types.INTEGER);

		return npjtem.update(SQL_PUSH_REAR_POS, ps);
	}

	@Override
	public int pushFrontPos(int qna_parent_ref, int qna_parent_pos) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_ref", qna_parent_ref, Types.INTEGER);
		ps.addValue("qna_pos", qna_parent_pos, Types.INTEGER);

		return npjtem.update(SQL_PUSH_FRONT_POS, ps);	
	}

	@Override
	public QnaVo getSimpleQnaByRefNPos(int qna_ref, int qna_pos) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("qna_ref", qna_ref, Types.INTEGER);
		ps.addValue("qna_pos", qna_pos, Types.INTEGER);
		return npjtem.queryForObject(SQL_SELECT_SIMPLE_QNA_BY_REF_N_POS, ps, new BeanPropertyRowMapper<QnaVo>(QnaVo.class));
	}
}
