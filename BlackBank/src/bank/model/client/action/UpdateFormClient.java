package bank.model.client.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.client.ClientBean;
import bank.model.client.ClientDao;

public class UpdateFormClient implements Action {	// 

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cltRrn=request.getParameter("cltRrn");
		if(cltRrn == null || cltRrn.trim().length() == 0){
			request.setAttribute("error", "주민등록번호가 입력되지 않았습니다");
			return;
		}
		
		try{
			request.setAttribute("resultContent", ClientDao.getRetrieveClt(cltRrn));			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
