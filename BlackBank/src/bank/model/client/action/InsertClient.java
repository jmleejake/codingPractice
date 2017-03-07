package bank.model.client.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.client.ClientBean;
import bank.model.client.ClientDao;

public class InsertClient implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
				
		String cltName=request.getParameter("cltName");
		String cltRrn=request.getParameter("cltRrn");		
		String cltTel=request.getParameter("cltTel");				
		String cltCel=request.getParameter("cltCel");				
		String cltAddr=request.getParameter("cltAddr");
		String cltEmail=request.getParameter("cltEmail");
		
		if(cltName == null || cltName.trim().length() == 0 ||
		   cltRrn == null  || cltRrn.trim().length() == 0 ||
		   cltTel == null || cltTel.trim().length() == 0 ||
		   cltCel == null || cltCel.trim().length() == 0 ||
		   cltAddr == null || cltAddr.trim().length() == 0 ||
		   cltEmail == null || cltEmail.trim().length() == 0){
			request.setAttribute("error", "��� ĭ�� ä���� �־�� �մϴ�.");
			return;
		}
		
		try{
			if(ClientDao.getDuplicationClt(cltRrn)!= null){
			    request.setAttribute("error", "�̹� �����ϴ� �ֹε�Ϲ�ȣ�Դϴ�.");		
			    return;
			}
			if(ClientDao.setRegisterClt(new ClientBean(cltName,cltRrn,cltTel,cltCel,cltAddr,cltEmail))== 0){
				request.setAttribute("error", "ȸ�����Կ� �����Ͽ����ϴ�.");				
			}
		}catch (SQLException e) {	
			request.setAttribute("error", "ȸ�����Կ� �����Ͽ����ϴ�.");		
			e.printStackTrace();
		}
	}	
}