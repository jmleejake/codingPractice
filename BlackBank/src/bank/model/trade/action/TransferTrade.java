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
	//��ü
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accNum = request.getParameter("accNum").trim();		//��ü�� ���¹�ȣ
		String trdNum = request.getParameter("trdNum").trim();		//��ü�� ���¹�ȣ
		String balance = request.getParameter("balance").trim();	
		String strMoney = request.getParameter("trdMoney").trim();
		
		if(accNum == null || accNum.trim().length() == 0||
			trdNum == null || trdNum.trim().length() == 0||
			balance == null || balance.trim().length() == 0||
			strMoney == null || strMoney.trim().length() == 0){
			request.setAttribute("error", "��ü�� ���� ������ �����մϴ�.");
			return;
		}
		
		int trdMoney = Integer.parseInt(strMoney); 					//��ü�� �ݾ�		
		String trdCode="��ü";						
		
		try{
			if(!accNum.equals(trdNum)){		// ��ü�� ���¿� ��ü�� ���°� ������ �ȵȴ�
				if(!(trdMoney > Integer.parseInt(balance))&&!(trdMoney==0)){	// ��ü�� ������ �ܾ��� ��ü�ݾ׺��� ������ �ȵǰ� ��ü�ݾ��� 0 ���̸� �ȵȴ�			
			    	 if(AccountDao.getRetrieveAcc(trdNum)!= null){		// ��ü�� ������ �������� Ȯ��    		 
		    			int count = (TradeDao.getRetrieveTrd(accNum))+1;		    			
		    			AccountDao.setTransAcc(new AccountBean(accNum,trdMoney),
		    								   new AccountBean(trdNum,trdMoney), 
		    								   new TradeBean(count, accNum, (Integer.parseInt(balance)- trdMoney), trdCode, trdMoney));
		    			
		    			count = (TradeDao.getRetrieveTrd(trdNum))+1;		// ��ü�� ������ �ŷ���ȣ �ο�
						int trdBalance = AccountDao.getRetrieveAcc(trdNum).getBalance();		// ��ü�� ���¹�ȣ�� ��ȸ�� �ܾ��� �����´�	
						TradeDao.infoTrd(new TradeBean(count, trdNum, trdBalance, trdCode, trdMoney));	// ��ü�� ������ �ŷ����� ����		 
			    	 }
				}else{
					request.setAttribute("error", "������ �ܾ׺��� ��ü�ϰ��� �ϴ� �׼��� �� Ů�ϴ�!!!");
				}
			}else{			
				request.setAttribute("error", "������ ���¿� �޴� ���°� ���� �� �����ϴ�.");
			}				
			request.setAttribute("accountRead", AccountDao.getRetrieveAcc(accNum));													
			request.setAttribute("tradeList", TradeDao.getRetrieveTrds(accNum));
		}catch (SQLException e) {			
			e.printStackTrace();				
		}					
	}
}








