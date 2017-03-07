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
		
		if(cltRrn == null || cltRrn.trim().length() == 0 || cltRrn.equals("�ֹε�Ϲ�ȣ �Է�")){
			request.setAttribute("error", "�ֹε�Ϲ�ȣ�� �Էµ��� �ʾҽ��ϴ�.");
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