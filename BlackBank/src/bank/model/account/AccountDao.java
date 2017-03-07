package bank.model.account;

import java.io.IOException;
import java.io.Reader;

import java.sql.SQLException;

import java.util.List;



import bank.model.trade.TradeBean;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class AccountDao { 
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
	  
	  //모든 계좌정보
	  public static List getAllRetrieveAccs () throws SQLException {
		  return sqlMapper.queryForList("Account.getAllRetrieveAccs");
	  }
	  
	  //계좌번호가지고 계좌조회하기
	  public static AccountBean getRetrieveAcc (String accNum) throws SQLException {
		  return (AccountBean) sqlMapper.queryForObject("Account.getRetrieveAcc", accNum);
	  }
	  
	  //계좌등록
	  public static int setRegisterAcc (AccountBean account) throws SQLException {		    
		  return sqlMapper.update("Account.setRegisterAcc", account);
	  }	  
	  
	  //이체 트랜젝션처리
	  public static void setTransAcc (AccountBean account1,AccountBean account2, TradeBean trade) throws SQLException {
		  try{
			  sqlMapper.startTransaction();
			  sqlMapper.update("Account.setWTransAcc", account1);
			  sqlMapper.update("Account.setDTransAcc", account2);
			  sqlMapper.update("Trade.infoTrd", trade);
			  sqlMapper.commitTransaction();
		  }catch(Exception e){
			  e.printStackTrace();
		  }finally{
			  sqlMapper.endTransaction();
		  }
	  }
	  
	  //계좌정보 수정
	  public static int setModifyAcc (AccountBean account) throws SQLException {		    
		  return sqlMapper.update("Account.setModifyAcc", account);
	  }
	  
	  //해당 계좌번호의 잔액수정
	  public static int setRemoveAcc (AccountBean account) throws SQLException {
		  return sqlMapper.delete("Account.setRemoveAcc", account);
	  }
	  
	  //고객번호와 계좌번호로 계좌번호 가져오기(해당 고객의 계좌가 아니면 검색안되게 수행.)
	  public static String getAccNumByCltNum (AccountBean account) throws SQLException {
		  return (String) sqlMapper.queryForObject("Account.getAccNumByCltNum", account);
	  }
	  
	  //해당 계좌수 (count)
	  public static int getRetrieveAccByCount(String accNum) throws SQLException {
		  return (Integer) sqlMapper.queryForObject("Account.getRetrieveAccByCount", accNum);
	  }
	  
	  //보통예금 금리적용
	  public static int setModifyAccOr () throws SQLException {		    
		  return sqlMapper.update("Account.setModifyAccOr");
	  }
	  
	  //저축예금 금리수정
	  public static int setModifyAccSa () throws SQLException {		    
		  return sqlMapper.update("Account.setModifyAccSa");
	  }
	  
	  //계좌번호유무확인
	  public static String searchAccNum (String accNum) throws SQLException {
		  return (String) sqlMapper.queryForObject("Account.searchAccNum", accNum);
	  }

}
