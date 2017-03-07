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
			request.setAttribute("error", "모든 칸이 채워져 있어야 합니다.");
			return;
		}
		
		try{
			if(ClientDao.getDuplicationClt(cltRrn)!= null){
			    request.setAttribute("error", "이미 존재하는 주민등록번호입니다.");		
			    return;
			}
			if(ClientDao.setRegisterClt(new ClientBean(cltName,cltRrn,cltTel,cltCel,cltAddr,cltEmail))== 0){
				request.setAttribute("error", "회원가입에 실패하였습니다.");				
			}
		}catch (SQLException e) {	
			request.setAttribute("error", "회원가입에 실패하였습니다.");		
			e.printStackTrace();
		}
	}	
}