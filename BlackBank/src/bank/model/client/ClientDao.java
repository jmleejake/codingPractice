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
	  
	  //모든 고객정보 조회
	  public static List getAllRetrieveClts () throws SQLException {
		  return sqlMapper.queryForList("Client.getAllRetrieveClts");
	  }
	  
	  //주민번호로 한 고객 조회
	  public static ClientBean getRetrieveClt (String cltRrn) throws SQLException {
		  return (ClientBean) sqlMapper.queryForObject("Client.getRetrieveClt", cltRrn);
	  } 
	  
	  //중복되지않는 주민번호인지 검색
	  public static ClientBean getDuplicationClt (String cltRrn) throws SQLException {
		  return (ClientBean) sqlMapper.queryForObject("Client.getDuplicationClt", cltRrn);
	  } 
	  
	  //고객등록
	  public static int setRegisterClt (ClientBean client) throws SQLException {		    
		  return sqlMapper.update("Client.setRegisterClt", client);
	  }
	  
	  //고객정보 수정
	  public static int setModifyClt (ClientBean client) throws SQLException {
		  return sqlMapper.update("Client.setModifyClt", client);
	  }
	  
	  //고객삭제
	  public static int setRemoveClt (String cltRrn) throws SQLException {
		  return sqlMapper.delete("Client.setRemoveClt", cltRrn);
	  }
	  
	  //페이징위한 전체 고객 count
	  public static int getCountClts () throws SQLException {
		  return (Integer) sqlMapper.queryForObject("Client.getCountClts");
	  }
	  
	  //페이징 처리위한 페이지값
	  public static List getPageClt (int page) throws SQLException {
		  return (List) sqlMapper.queryForList("Client.getPageClt", page);
	  }
	  
}
