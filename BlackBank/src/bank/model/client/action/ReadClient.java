package bank.model.client.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.controller.action.Action;
import bank.model.account.AccountDao;
import bank.model.client.ClientBean;
import bank.model.client.ClientDao;

public class ReadClient implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cltRrn=request.getParameter("cltRrn");
		
		if(cltRrn == null || cltRrn.trim().length() == 0 || cltRrn.equals("주민등록번호 입력")){
			request.setAttribute("error", "주민등록번호가 입력되지 않았습니다.");
			return;
		}
		
		try{
			HttpSession session = request.getSession();
			session.setAttribute("resultContent", ClientDao.getRetrieveClt(cltRrn));
			session.setAttribute("accountList", AccountDao.getAllRetrieveAccs());
		}catch (Exception e) {
			e.printStackTrace();					
	}
  }
}