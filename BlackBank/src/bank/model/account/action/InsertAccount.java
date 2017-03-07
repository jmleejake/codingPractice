package bank.model.account.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.controller.action.Action;
import bank.model.account.AccountBean;
import bank.model.account.AccountDao;
import bank.model.client.ClientBean;
import bank.model.trade.TradeDao;

public class InsertAccount implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					 
		HttpSession session = request.getSession();
		int count = 1;
		java.util.Date today = new java.util.Date() ;
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MMdd-");
		String date = s.format(today);		
		String accNum = date+count;		
				
		ClientBean cb = (ClientBean)session.getAttribute("resultContent");		
		String accPw=request.getParameter("accPw");								
		String expDay=request.getParameter("expDay");				
		String payDay=request.getParameter("payDay");
		String prdCode=request.getParameter("prdCode");
		
		if(accNum == null || accNum.trim().length() == 0 ||
			accPw == null  || accPw.trim().length() == 0 ||				
			prdCode == null || prdCode.trim().length() == 0){
			request.setAttribute("error", "계좌생성을 위한 값들이 부족합니다.");
			return;
		}
		
		int cltNum = cb.getCltNum();				
		try{
			count = (AccountDao.getRetrieveAccByCount(accNum))+1;
			accNum = date+count;
			
			while(AccountDao.searchAccNum(accNum)!=null){
				count++;
				accNum = date+count;
			}
			
			AccountBean aContent=new AccountBean(accNum,cltNum,accPw,expDay,payDay,0,prdCode);
			if(AccountDao.setRegisterAcc(aContent)!= 0){				
				session.setAttribute("accountList", AccountDao.getAllRetrieveAccs());
				request.setAttribute("check", aContent);
			}else{
				request.setAttribute("error","계좌생성에 실패하였습니다.");
			}
			
		}catch (Exception e) {
				e.printStackTrace();					
		}
	}
	
}