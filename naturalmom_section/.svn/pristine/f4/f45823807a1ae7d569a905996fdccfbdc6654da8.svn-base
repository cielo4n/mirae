package com.nmom.soap.data.impl.board.faq;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nmom.soap.data.dao.board.faq.IFaqDao;
import com.nmom.soap.data.model.board.faq.FaqVo;

public class FaqDaoOraImpl extends NamedParameterJdbcDaoSupport implements IFaqDao {
	
	private final String SQL_SELECT_ONE_FAQ = "SELECT faq_no, faq_title, faq_content FROM tb_faq WHERE board_id=3 AND faq_del_check=0 AND faq_no=:faq_no";

	private final String SQL_SELECT_ALL_FAQ_LIST = 
			"SELECT A.* FROM "
			+ "(SELECT rownum as faq_rnum, X.* FROM "
			+ "(SELECT faq_no, faq_title from tb_faq WHERE board_id=3 AND faq_del_check=0 ORDER BY faq_no ASC) X "
			+ "WHERE rownum <= :end) A "
			+ "WHERE A.faq_rnum > :start ORDER BY A.faq_rnum DESC";
	
	private final String SQL_SEARCH_FAQ_TITLE = 
			"SELECT A.* FROM "
			+ "(SELECT rownum as faq_rnum, X.* FROM "
			+ "(SELECT faq_no, faq_title from tb_faq WHERE board_id=3 AND faq_del_check=0 "
			+ "AND faq_title LIKE :keyword ORDER BY faq_no ASC) X "
			+ "WHERE rownum <= :end) A "
			+ "WHERE A.faq_rnum > :start ORDER BY A.faq_rnum DESC";
	
	private final String SQL_SEARCH_FAQ_CONTENT = 
			"SELECT A.* FROM "
			+ "(SELECT rownum as faq_rnum, X.* FROM "
			+ "(SELECT faq_no, faq_title from tb_faq WHERE board_id=3 AND faq_del_check=0 AND "
			+ "faq_content LIKE :keyword ORDER BY faq_no ASC) X "
			+ "WHERE rownum <= :end) A "
			+ "WHERE A.faq_rnum > :start ORDER BY A.faq_rnum DESC";
	
	private final String SQL_SEARCH_FAQ_TITLE_N_CONTENT = 
			"SELECT A.* FROM "
			+ "(SELECT rownum as faq_rnum, X.* FROM "
			+ "(SELECT faq_no, faq_title from tb_faq WHERE board_id=3 AND faq_del_check=0 "
			+ "AND (faq_title LIKE :keyword OR faq_content LIKE :keyword) ORDER BY faq_no ASC) X "
			+ "WHERE rownum <= :end) A "
			+ "WHERE A.faq_rnum > :start ORDER BY A.faq_rnum DESC";

	private final String SQL_INSERT_FAQ = "INSERT INTO tb_faq (faq_title, faq_content, faq_del_check, board_id, mem_id, faq_no) VALUES (:faq_title, :faq_content, 0, 3, :mem_id, FAQ_NO_SEQ.NEXTVAL)";
	private final String SQL_UPDATE_FAQ = "UPDATE tb_faq SET faq_title=:faq_title, faq_content=:faq_content WHERE faq_no=:faq_no";
	private final String SQL_DELETE_FAQ = "UPDATE tb_faq SET faq_del_check=1 WHERE faq_no=:faq_no";

	private final String SQL_SELECT_FAQ_COUNT = "SELECT COUNT(faq_no) FROM tb_faq WHERE FAQ_DEL_CHECK=0";
	
	private final String SQL_SELECT_FAQ_SEARCH_TITLE_COUNT = "SELECT COUNT(faq_no) FROM tb_faq WHERE faq_title LIKE :keyword";
	private final String SQL_SELECT_FAQ_SEARCH_CONTENT_COUNT = "SELECT COUNT(faq_no) FROM tb_faq WHERE faq_content LIKE :keyword";
	private final String SQL_SELECT_FAQ_SEARCH_TITLE_N_CONTENT_COUNT = "SELECT COUNT(faq_no) FROM tb_faq WHERE (faq_title LIKE :keyword OR faq_content LIKE :keyword)";
	
	
	public FaqVo getOneFaq(int faq_no) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("faq_no", faq_no, Types.INTEGER);

		List<FaqVo> faq_list = npjtem.query(SQL_SELECT_ONE_FAQ, ps, new BeanPropertyRowMapper<FaqVo>(FaqVo.class));
		
		if(faq_list!=null && faq_list.size()==1){
			return faq_list.get(0);
		} else {
			return null;
		}
	}
	
	public List<FaqVo> getAllFaq(int start, int end) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("start", start, Types.INTEGER);
		ps.addValue("end", end, Types.INTEGER);

		return npjtem.query(SQL_SELECT_ALL_FAQ_LIST, ps, new BeanPropertyRowMapper<FaqVo>(FaqVo.class));
	}

	public List<FaqVo> searchFaqTitle(String keyword, int start, int end) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		ps.addValue("start", start, Types.INTEGER);
		ps.addValue("end", end, Types.INTEGER);

		return npjtem.query(SQL_SEARCH_FAQ_TITLE, ps, new BeanPropertyRowMapper<FaqVo>(FaqVo.class));
	}

	public List<FaqVo> searchFaqContent(String keyword, int start, int end) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		ps.addValue("start", start, Types.INTEGER);
		ps.addValue("end", end, Types.INTEGER);

		return npjtem.query(SQL_SEARCH_FAQ_CONTENT, ps, new BeanPropertyRowMapper<FaqVo>(FaqVo.class));
	}

	public List<FaqVo> searchFaqTitleNContent(String keyword, int start, int end) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		ps.addValue("start", start, Types.INTEGER);
		ps.addValue("end", end, Types.INTEGER);

		return npjtem.query(SQL_SEARCH_FAQ_TITLE_N_CONTENT, ps, new BeanPropertyRowMapper<FaqVo>(FaqVo.class));
	}

	public int addFaq(FaqVo faq) {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("faq_title", faq.getFaq_title(), Types.VARCHAR);
		ps.addValue("faq_content", faq.getFaq_content(), Types.VARCHAR);
		ps.addValue("mem_id", faq.getMem_id(), Types.VARCHAR);
		
		return npjtem.update(SQL_INSERT_FAQ, ps);
		
	}

	public int addFaq(String faq_title, String faq_content, String mem_id) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("faq_title", faq_title, Types.VARCHAR);
		ps.addValue("faq_content", faq_content, Types.VARCHAR);
		ps.addValue("mem_id", mem_id, Types.VARCHAR);
		
		return npjtem.update(SQL_INSERT_FAQ, ps);
	}

	public int editFaq(FaqVo faq) {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("faq_title", faq.getFaq_title(), Types.VARCHAR);
		ps.addValue("faq_content", faq.getFaq_content(), Types.VARCHAR);
		ps.addValue("faq_no", faq.getFaq_no(), Types.INTEGER);
		
		return npjtem.update(SQL_UPDATE_FAQ, ps);
	}

	public int editFaq(String faq_title, String faq_content, int faq_no) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("faq_title", faq_title, Types.VARCHAR);
		ps.addValue("faq_content", faq_content, Types.VARCHAR);
		ps.addValue("faq_no", faq_no, Types.INTEGER);
		
		return npjtem.update(SQL_UPDATE_FAQ, ps);
	}

	public int removeFaq(FaqVo faq) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("faq_no", faq.getFaq_no(), Types.INTEGER);
		
		return npjtem.update(SQL_DELETE_FAQ, ps);
	}

	public int removeFaq(int faq_no) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("faq_no", faq_no, Types.INTEGER);
		
		return npjtem.update(SQL_DELETE_FAQ, ps);
	}

	@Override
	public int getFaqCount() throws DataAccessException {
		return this.getJdbcTemplate().queryForInt(SQL_SELECT_FAQ_COUNT);
	}

	@Override
	public int getSearchFaqTitleCount(String keyword) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		
		return npjtem.queryForInt(SQL_SELECT_FAQ_SEARCH_TITLE_COUNT, ps);
	}

	@Override
	public int getSearchFaqContentCount(String keyword) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		
		return npjtem.queryForInt(SQL_SELECT_FAQ_SEARCH_CONTENT_COUNT, ps);
	}

	@Override
	public int getSearchFaqTitleNContentCount(String keyword) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		keyword = "%"+keyword+"%";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		
		return npjtem.queryForInt(SQL_SELECT_FAQ_SEARCH_TITLE_N_CONTENT_COUNT, ps);
	}
}