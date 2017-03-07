package bank.model.teller;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import bank.model.account.AccountBean;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TellerDao { 
	private static TellerBean t;
	
	public static TellerBean getT() {
		return t;
	}

	public static void setT(TellerBean t) {
		TellerDao.t = t;
	}

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
	  
	  //��� �ڷ���ȸ
	  public static List getAllRetrieveTlr () throws SQLException {	  
		  return sqlMapper.queryForList("Teller.getAllRetrieveTlr");
	  }
	  
	  //�ڷ���ȸ(ID)
	  public static TellerBean getRetrieveTlr  (String tlrId) throws SQLException {		
		  return (TellerBean) sqlMapper.queryForObject("Teller.getRetrieveTlr", tlrId);
	  }
	  
	  //ID�ߺ�üũ
	  public static String getRetrieveTlrId  (String tlrId) throws SQLException {		
		  return (String) sqlMapper.queryForObject("Teller.getRetrieveTlrId", tlrId);
	  } 
	  
	  //������Ʈ�� ���� �ڷ���ȸ(ID,PW)
	  public static TellerBean getModRetrieveTlr  (TellerBean Teller) throws SQLException {	 
		  return (TellerBean) sqlMapper.queryForObject("Teller.getModRetrieveTlr", Teller);
	  } 
	
	  //�ڷ�����	
	  public static int setRegisterTlr (TellerBean Teller) throws SQLException {	    
		  return sqlMapper.update("Teller.setRegisterTlr", Teller);
	  }
	  
	  //�ڷ�����(ID,PW)
	  public static int setModifyTlr(TellerBean Teller) throws SQLException {		
		  return sqlMapper.update("Teller.setModifyTlr", Teller);
	  }
	  
	  //�ڷ�����(ID,PW)
	  public static int setRemoveTlr (String tlrPw) throws SQLException {		
		  return sqlMapper.delete("Teller.setRemoveTlr", tlrPw);
	  }	 
}
