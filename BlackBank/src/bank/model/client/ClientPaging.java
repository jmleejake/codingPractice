package bank.model.client;

import java.sql.SQLException;

public class ClientPaging {
		
	public static int getPageCount () throws SQLException {
		  int count = 0;
		  count = ClientDao.getCountClts();
		  int ipage = count/7;
		  int m = count%7;
		  if(m>0){
			  ipage++;
		  }
		  return ipage;
	  }
	  
	  public static boolean isPrevPage (int page) throws SQLException {
		  if(page>ClientDao.getCountClts()){
			  return false;
		  }else if(page>=2){
			  return true;
		  }
		  return false;
	  }
	  
	  public static boolean isNextPage (int page) throws SQLException {
		  if(page<ClientDao.getCountClts()){
			  return true;
		  }
		  return false;
	  }
	  
}
