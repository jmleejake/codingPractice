package bank.model.client.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.client.ClientBean;
import bank.model.client.ClientDao;

public class UpdateClient implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cltTel=request.getParameter("cltTel");
		String cltCel=request.getParameter("cltCel");
		String cltAddr=request.getParameter("cltAddr");				
		String cltEmail=request.getParameter("cltEmail");
		String cltRrn=request.getParameter("cltRrn");
		
		if(cltTel == null || cltTel.trim().length() == 0 ||
			cltCel == null || cltCel.trim().length() == 0 ||
			cltAddr == null || cltAddr.trim().length() == 0 ||
			cltEmail == null || cltEmail.trim().length() == 0 ||
			cltRrn == null || cltRrn.trim().length() == 0){
			request.setAttribute("error", "모든 칸이 채워져 있어야 합니다.");
			return;
		}
		
		try{							
			if(ClientDao.setModifyClt(new ClientBean(cltTel,cltCel,cltAddr,cltEmail,cltRrn))!= 0){
				request.setAttribute("resultContent", ClientDao.getRetrieveClt(cltRrn));
			}else{
				request.setAttribute("error", "수정이 불가합니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}	
