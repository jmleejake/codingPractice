package bank.model.trade.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.account.AccountBean;
import bank.model.account.AccountDao;
import bank.model.trade.TradeBean;
import bank.model.trade.TradeDao;

public class WithdrawTrade implements Action {
	//출금
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accNum = request.getParameter("accNum");	
		String balance = request.getParameter("balance");
		String strMoney = request.getParameter("trdMoney");		
		int trdMoney = Integer.parseInt(strMoney); 		
		int trdBalance= (Integer.parseInt(balance))- trdMoney;	
		String trdCode="출금";							
		
		try{	
			int count = (TradeDao.getRetrieveTrd(accNum))+1;			
			TradeBean tContent=new TradeBean(count,accNum,trdBalance,trdCode,trdMoney);
			AccountBean aContent=new AccountBean(accNum,trdBalance);
			boolean result = false;
			if(!(trdMoney > Integer.parseInt(balance))&&!(trdMoney==0)){
				if(TradeDao.infoTrd(tContent)!= 0){				
					if(AccountDao.setModifyAcc(aContent)!=0){
						result = true;
					}
				}	
			}else{
				request.setAttribute("error", "잔액보다 출금하고자 하는 액수가 더 큽니다!!!");
			}
			request.setAttribute("accountRead", AccountDao.getRetrieveAcc(accNum));													
			request.setAttribute("tradeList", TradeDao.getRetrieveTrds(accNum));
		}catch (SQLException e) {			
			e.printStackTrace();
				
		}					
	}
}
