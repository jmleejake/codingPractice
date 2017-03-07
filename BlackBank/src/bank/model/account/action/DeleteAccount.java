package bank.model.account.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.controller.action.Action;
import bank.model.account.AccountBean;
import bank.model.account.AccountDao;
import bank.model.trade.TradeDao;

public class DeleteAccount implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String accNum = request.getParameter("accNum");		
		String accPw = request.getParameter("accPw");	
		
		if(	accNum == null || accNum.trim().length() == 0 ||
			accPw == null || accPw.trim().length() == 0){
			request.setAttribute("error","계좌 삭제를 위한 데이터 다시 입력해 주세요.");
			return;
		}	

		try{			
			if(AccountDao.setRemoveAcc(new AccountBean(accNum, accPw))!= 0){
				HttpSession session = request.getSession();
				TradeDao.setRemoveTrd(accNum);
				session.setAttribute("accountList", AccountDao.getAllRetrieveAccs());
			}else{
				request.setAttribute("error","계좌삭제 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();				
		}			
	}
}

