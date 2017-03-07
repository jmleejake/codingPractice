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
	  
	  //��� ��������
	  public static List getAllRetrieveAccs () throws SQLException {
		  return sqlMapper.queryForList("Account.getAllRetrieveAccs");
	  }
	  
	  //���¹�ȣ������ ������ȸ�ϱ�
	  public static AccountBean getRetrieveAcc (String accNum) throws SQLException {
		  return (AccountBean) sqlMapper.queryForObject("Account.getRetrieveAcc", accNum);
	  }
	  
	  //���µ��
	  public static int setRegisterAcc (AccountBean account) throws SQLException {		    
		  return sqlMapper.update("Account.setRegisterAcc", account);
	  }	  
	  
	  //��ü Ʈ������ó��
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
	  
	  //�������� ����
	  public static int setModifyAcc (AccountBean account) throws SQLException {		    
		  return sqlMapper.update("Account.setModifyAcc", account);
	  }
	  
	  //�ش� ���¹�ȣ�� �ܾ׼���
	  public static int setRemoveAcc (AccountBean account) throws SQLException {
		  return sqlMapper.delete("Account.setRemoveAcc", account);
	  }
	  
	  //����ȣ�� ���¹�ȣ�� ���¹�ȣ ��������(�ش� ���� ���°� �ƴϸ� �˻��ȵǰ� ����.)
	  public static String getAccNumByCltNum (AccountBean account) throws SQLException {
		  return (String) sqlMapper.queryForObject("Account.getAccNumByCltNum", account);
	  }
	  
	  //�ش� ���¼� (count)
	  public static int getRetrieveAccByCount(String accNum) throws SQLException {
		  return (Integer) sqlMapper.queryForObject("Account.getRetrieveAccByCount", accNum);
	  }
	  
	  //���뿹�� �ݸ�����
	  public static int setModifyAccOr () throws SQLException {		    
		  return sqlMapper.update("Account.setModifyAccOr");
	  }
	  
	  //���࿹�� �ݸ�����
	  public static int setModifyAccSa () throws SQLException {		    
		  return sqlMapper.update("Account.setModifyAccSa");
	  }
	  
	  //���¹�ȣ����Ȯ��
	  public static String searchAccNum (String accNum) throws SQLException {
		  return (String) sqlMapper.queryForObject("Account.searchAccNum", accNum);
	  }

}
