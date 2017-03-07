package bank.model.trade.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.account.AccountBean;
import bank.model.account.AccountDao;
import bank.model.trade.TradeBean;
import bank.model.trade.TradeDao;

public class TransferTrade implements Action {
	//이체
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accNum = request.getParameter("accNum").trim();		//이체될 계좌번호
		String trdNum = request.getParameter("trdNum").trim();		//이체할 계좌번호
		String balance = request.getParameter("balance").trim();	
		String strMoney = request.getParameter("trdMoney").trim();
		
		if(accNum == null || accNum.trim().length() == 0||
			trdNum == null || trdNum.trim().length() == 0||
			balance == null || balance.trim().length() == 0||
			strMoney == null || strMoney.trim().length() == 0){
			request.setAttribute("error", "이체를 위한 값들이 부족합니다.");
			return;
		}
		
		int trdMoney = Integer.parseInt(strMoney); 					//이체할 금액		
		String trdCode="이체";						
		
		try{
			if(!accNum.equals(trdNum)){		// 이체할 계좌와 이체될 계좌가 같으면 안된다
				if(!(trdMoney > Integer.parseInt(balance))&&!(trdMoney==0)){	// 이체할 계좌의 잔액이 이체금액보다 적으면 안되고 이체금액이 0 원이면 안된다			
			    	 if(AccountDao.getRetrieveAcc(trdNum)!= null){		// 이체될 계좌의 존재유무 확인    		 
		    			int count = (TradeDao.getRetrieveTrd(accNum))+1;		    			
		    			AccountDao.setTransAcc(new AccountBean(accNum,trdMoney),
		    								   new AccountBean(trdNum,trdMoney), 
		    								   new TradeBean(count, accNum, (Integer.parseInt(balance)- trdMoney), trdCode, trdMoney));
		    			
		    			count = (TradeDao.getRetrieveTrd(trdNum))+1;		// 이체될 계좌의 거래번호 부여
						int trdBalance = AccountDao.getRetrieveAcc(trdNum).getBalance();		// 이체될 계좌번호로 조회후 잔액을 가져온다	
						TradeDao.infoTrd(new TradeBean(count, trdNum, trdBalance, trdCode, trdMoney));	// 이체될 계좌의 거래내역 생성		 
			    	 }
				}else{
					request.setAttribute("error", "계좌의 잔액보다 이체하고자 하는 액수가 더 큽니다!!!");
				}
			}else{			
				request.setAttribute("error", "보내는 계좌와 받는 계좌가 같을 수 없습니다.");
			}				
			request.setAttribute("accountRead", AccountDao.getRetrieveAcc(accNum));													
			request.setAttribute("tradeList", TradeDao.getRetrieveTrds(accNum));
		}catch (SQLException e) {			
			e.printStackTrace();				
		}					
	}
}








