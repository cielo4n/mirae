package com.nmom.soap.data.impl.product;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nmom.soap.data.dao.product.IProductDao;
import com.nmom.soap.data.model.product.ProductVo;

public class ProductDaoOraImpl extends NamedParameterJdbcDaoSupport implements IProductDao 
{
	// 상품번호로 상품 가져오기
	private final String GET_ONE_PRODUCT = "SELECT * FROM tb_product WHERE product_no = ?";
	// 상품 수정하기
	private final String EDIT_ONE_PRODUCT = "UPDATE tb_product SET product_name = :product_name, category_cd = :category_cd, "
			+ "selling_price = :selling_price, cost_price = :cost_price, stock = :stock, weight = :weight, "
			+ "represent_img = :represent_img, detail_img = :detail_img, summary_ex = :summary_ex, "
			+ "detail_ex = :detail_ex, display_state = :display_state, sale_state = :sale_state "
			+ "WHERE product_no = :product_no";
	// 진열 상태 수정하기
	private final String EDIT_DISPLAY_STATE = "UPDATE tb_product SET display_state = :display_state WHERE product_no = :product_no";
	// 판매 상태 수정하기
	private final String EDIT_SALE_STATE = "UPDATE tb_product SET sale_state = :sale_state WHERE product_no = :product_no";	
	// 삭제 상태 수정하기
	private final String EDIT_DELETED_STATE = "UPDATE tb_product SET deleted_state = :deleted_state, "
			+ "display_state = 1, sale_state = 1 WHERE product_no = :product_no";
	// 상품 등록하기
	private final String ADD_ONE_PRODUCT = "INSERT INTO tb_product ("
			+ "product_name, selling_price, cost_price, stock, display_state, sale_state, represent_img, "
			+ "detail_img, summary_ex, detail_ex, deleted_state, weight, category_cd, product_no) VALUES ("
			+ ":product_name, :selling_price, :cost_price, :stock, 1, 1, :represent_img,"
			+ ":detail_img, :summary_ex, :detail_ex, 0, :weight, :category_cd, PRODUCT_NO_SEQ.NEXTVAL)";
	
	// 재고 가져오기
	private final String GET_STOCK_OF_PRODUCT = "SELECT stock FROM tb_product WHERE product_no = ?";
	// 재고 빼기
	private final String SUB_STOCK_OF_PRODUCT = "UPDATE tb_product SET stock = stock - :amount WHERE product_no = :product_no";
	// 재고 더하기
	private final String ADD_STOCK_OF_PRODUCT = "UPDATE tb_product SET stock = stock + :amount WHERE product_no = :product_no";
	
	// 상품 찾기
	private final String SEARCH_PRODUCT = "SELECT product_no, product_name, selling_price, sale_state, represent_img, summary_ex, stock FROM tb_product WHERE display_state=1 AND deleted_state=0 AND (product_name LIKE :keyword OR summary_ex LIKE :keyword)";
	
	//************************************************************//
	
	//상품 목록 페이지
	private final String SELECT_ALL_PRODUCT = "SELECT product_no, product_name, selling_price, sale_state, represent_img, summary_ex, stock FROM tb_product WHERE display_state=1 AND deleted_state=0";
	
	//카테고리에 따라 상품목록 가져옴
	private final String SELECT_PRODUCT_BY_CATEGORY_CD="SELECT product_no, product_name, selling_price, sale_state, represent_img, summary_ex, stock FROM tb_product WHERE display_state=1 AND deleted_state=0 AND category_cd=:category_cd";
	
	//상품이름으로 상품 가져옴
	private final String SELECT_PRODUCT_BY_PRODUCT_NAME = "SELECT product_no, product_name, selling_price, sale_state, represent_img, summary_ex, stock FROM tb_product WHERE display_state=1 AND deleted_state=0 AND product_name LIKE :product_name";
	
	//************************************************************//

	public ProductVo getOneProduct(int product_no) throws DataAccessException
	{
		List<ProductVo> list = getJdbcTemplate().query(GET_ONE_PRODUCT, 
				new BeanPropertyRowMapper<ProductVo>(ProductVo.class), new Integer(product_no));
		
		if (list != null && list.size() > 0)
			return list.get(0);
		
		else
			return null;
	}

	public int addProduct(ProductVo product) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("product_name", product.getProduct_name(), Types.VARCHAR);
		msps.addValue("selling_price", product.getSelling_price(), Types.INTEGER);
		msps.addValue("cost_price", product.getCost_price(), Types.INTEGER);
		msps.addValue("stock", product.getStock(), Types.INTEGER);
		msps.addValue("represent_img", product.getRepresent_img(), Types.VARCHAR);
		msps.addValue("detail_img", product.getDetail_img(), Types.VARCHAR);
		msps.addValue("summary_ex", product.getSummary_ex(), Types.VARCHAR);
		msps.addValue("detail_ex", product.getDetail_ex(), Types.VARCHAR);
		msps.addValue("weight", product.getWeight(), Types.INTEGER);
		msps.addValue("category_cd", product.getCategory_cd(), Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(ADD_ONE_PRODUCT, msps);
	}

	public int editDisplayState(int product_no, int state) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("display_state", new Integer(state), Types.INTEGER);
		msps.addValue("product_no", product_no, Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(EDIT_DISPLAY_STATE, msps);
	}

	public int editSaleState(int product_no, int state) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("sale_state", new Integer(state), Types.INTEGER);
		msps.addValue("product_no", product_no, Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(EDIT_SALE_STATE, msps);
	}

	public int editDeletedState(int product_no, int state) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("deleted_state", new Integer(state), Types.INTEGER);
		msps.addValue("product_no", product_no, Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(EDIT_DELETED_STATE, msps);
	}

	public int editOneProduct(ProductVo product) throws DataAccessException
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("product_name", product.getProduct_name(), Types.VARCHAR);
		msps.addValue("category_cd", product.getCategory_cd(), Types.INTEGER);
		msps.addValue("selling_price", product.getSelling_price(), Types.INTEGER);
		msps.addValue("cost_price", product.getCost_price(), Types.INTEGER);
		msps.addValue("stock", product.getStock(), Types.INTEGER);
		msps.addValue("weight", product.getWeight(), Types.INTEGER);
		msps.addValue("represent_img", product.getRepresent_img(), Types.VARCHAR);
		msps.addValue("detail_img", product.getDetail_img(), Types.VARCHAR);
		msps.addValue("summary_ex", product.getSummary_ex(), Types.VARCHAR);
		msps.addValue("detail_ex", product.getDetail_ex(), Types.VARCHAR);
		msps.addValue("display_state", product.getDisplay_state(), Types.INTEGER);
		msps.addValue("sale_state", product.getSale_state(), Types.INTEGER);
		msps.addValue("product_no", product.getProduct_no(), Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(EDIT_ONE_PRODUCT, msps);
	}
	
	@Override
	public int getStockOfProduct(int product_no)
	{
		return getJdbcTemplate().queryForInt(GET_STOCK_OF_PRODUCT, new Integer(product_no));
	}

	@Override
	public int subStockOfProduct(int amount, int product_no)
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("amount", new Integer(amount), Types.INTEGER);
		msps.addValue("product_no", new Integer(product_no), Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(SUB_STOCK_OF_PRODUCT, msps);
	}

	@Override
	public int addStockOfProduct(int amount, int product_no) 
	{
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("amount", new Integer(amount), Types.INTEGER);
		msps.addValue("product_no", new Integer(product_no), Types.INTEGER);
		
		return getNamedParameterJdbcTemplate().update(ADD_STOCK_OF_PRODUCT, msps);
	}
	
	//************************************************************//
	
	public List<ProductVo> getAllProduct() throws DataAccessException {
		return this.getJdbcTemplate().query(SELECT_ALL_PRODUCT, new BeanPropertyRowMapper<ProductVo>(ProductVo.class));
	}

	public List<ProductVo> getProductByCategoryCd(int category_cd) throws DataAccessException {
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("category_cd", category_cd, Types.INTEGER);
		return npjtem.query(SELECT_PRODUCT_BY_CATEGORY_CD, ps, new BeanPropertyRowMapper<ProductVo>(ProductVo.class));
	}

	@Override
	public List<ProductVo> searchProduct(String keyword) throws DataAccessException {
		keyword = "%"+keyword+"%";
		
		NamedParameterJdbcTemplate npjtem = this.getNamedParameterJdbcTemplate();
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("keyword", keyword, Types.VARCHAR);
		return npjtem.query(SEARCH_PRODUCT, ps, new BeanPropertyRowMapper<ProductVo>(ProductVo.class));
	}
	
	//************************************************************//
}
