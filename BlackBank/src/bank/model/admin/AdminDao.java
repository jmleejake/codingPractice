package bank.model.admin;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class AdminDao { 

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
	  
	  //로그인 관리자조회(ID,PW)
	  public static AdminBean getRetrieveAdIdPw(AdminBean admin) throws SQLException {	 
		  return (AdminBean)sqlMapper.queryForObject("Admin.getRetrieveAdIdPw", admin);
	  }
}
