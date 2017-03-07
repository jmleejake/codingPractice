package bank.model.product;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


public class ProductDao {
	private static SqlMapClient sqlMapper;  
	static {
		try {
			Reader reader = Resources.getResourceAsReader("/sqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	
	//모든상품의 정보조회
	public static List getAllRetrievePrds() throws SQLException{
		return sqlMapper.queryForList("Product.getAllRetrievePrds");
	}
	
	//상품코드로 정보조회
	public static ProductBean getRetrievePrd(String prdCode) throws SQLException{
		return (ProductBean)sqlMapper.queryForObject("Product.getRetrievePrd", prdCode);
	}
	
	//상품등록
	public static int setRegisterPrd(ProductBean product) throws SQLException {
		return sqlMapper.update("Product.setRegisterPrd", product);
	}
	
	//상품수정
	public static int setModifyPrd(ProductBean product) throws SQLException {
		return sqlMapper.update("Product.setModifyPrd", product);
	}
	
	//상품삭제 
	public static int setDeletePrd(ProductBean product) throws SQLException{
		return sqlMapper.delete("Product.setDeletePrd", product);
	}
}
