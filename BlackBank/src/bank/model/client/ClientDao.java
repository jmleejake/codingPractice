package bank.model.client;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class ClientDao {
	
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
	  
	  //��� ������ ��ȸ
	  public static List getAllRetrieveClts () throws SQLException {
		  return sqlMapper.queryForList("Client.getAllRetrieveClts");
	  }
	  
	  //�ֹι�ȣ�� �� �� ��ȸ
	  public static ClientBean getRetrieveClt (String cltRrn) throws SQLException {
		  return (ClientBean) sqlMapper.queryForObject("Client.getRetrieveClt", cltRrn);
	  } 
	  
	  //�ߺ������ʴ� �ֹι�ȣ���� �˻�
	  public static ClientBean getDuplicationClt (String cltRrn) throws SQLException {
		  return (ClientBean) sqlMapper.queryForObject("Client.getDuplicationClt", cltRrn);
	  } 
	  
	  //�����
	  public static int setRegisterClt (ClientBean client) throws SQLException {		    
		  return sqlMapper.update("Client.setRegisterClt", client);
	  }
	  
	  //������ ����
	  public static int setModifyClt (ClientBean client) throws SQLException {
		  return sqlMapper.update("Client.setModifyClt", client);
	  }
	  
	  //������
	  public static int setRemoveClt (String cltRrn) throws SQLException {
		  return sqlMapper.delete("Client.setRemoveClt", cltRrn);
	  }
	  
	  //����¡���� ��ü �� count
	  public static int getCountClts () throws SQLException {
		  return (Integer) sqlMapper.queryForObject("Client.getCountClts");
	  }
	  
	  //����¡ ó������ ��������
	  public static List getPageClt (int page) throws SQLException {
		  return (List) sqlMapper.queryForList("Client.getPageClt", page);
	  }
	  
}
