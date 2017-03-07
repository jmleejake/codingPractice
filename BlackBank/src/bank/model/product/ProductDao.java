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
	
	//����ǰ�� ������ȸ
	public static List getAllRetrievePrds() throws SQLException{
		return sqlMapper.queryForList("Product.getAllRetrievePrds");
	}
	
	//��ǰ�ڵ�� ������ȸ
	public static ProductBean getRetrievePrd(String prdCode) throws SQLException{
		return (ProductBean)sqlMapper.queryForObject("Product.getRetrievePrd", prdCode);
	}
	
	//��ǰ���
	public static int setRegisterPrd(ProductBean product) throws SQLException {
		return sqlMapper.update("Product.setRegisterPrd", product);
	}
	
	//��ǰ����
	public static int setModifyPrd(ProductBean product) throws SQLException {
		return sqlMapper.update("Product.setModifyPrd", product);
	}
	
	//��ǰ���� 
	public static int setDeletePrd(ProductBean product) throws SQLException{
		return sqlMapper.delete("Product.setDeletePrd", product);
	}
}
