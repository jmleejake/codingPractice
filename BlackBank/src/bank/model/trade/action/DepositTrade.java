package bank.model.trade.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.controller.action.Action;
import bank.model.account.AccountBean;
import bank.model.account.AccountDao;
import bank.model.client.ClientBean;
import bank.model.client.ClientDao;
import bank.model.teller.TellerBean;
import bank.model.teller.TellerDao;
import bank.model.trade.TradeBean;
import bank.model.trade.TradeDao;
import bank.util.DataSourceManager;

public class DepositTrade implements Action{
	//입금
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String accNum = request.getParameter("accNum");	
		String balance = request.getParameter("balance");
		String strMoney = request.getParameter("trdMoney");	
		
		int trdMoney = Integer.parseInt(strMoney); 		
		int trdBalance= (Integer.parseInt(balance))+ trdMoney;	
		String trdCode="입금";							
		
		try{
			int count = (TradeDao.getRetrieveTrd(accNum))+1;			
			TradeBean tContent=new TradeBean(count,accNum,trdBalance,trdCode,trdMoney);
			AccountBean aContent=new AccountBean(accNum,trdBalance);
			if(!request.getParameter("command").equals("AREAD")){
				boolean result = false;
				if(TradeDao.infoTrd(tContent)!= 0){		
					if(AccountDao.setModifyAcc(aContent)!=0){
						result = true;
					}
				}		
				request.setAttribute("accountRead", AccountDao.getRetrieveAcc(accNum));													
				request.setAttribute("tradeList", TradeDao.getRetrieveTrds(accNum));
			}
		}catch (SQLException e) {			
			e.printStackTrace();
				
		}					 
	}
}







