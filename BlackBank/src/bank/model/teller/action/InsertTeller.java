package bank.model.teller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.teller.TellerBean;
import bank.model.teller.TellerDao;

public class InsertTeller implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tlrId=request.getParameter("tlrId");
		String tlrPw=request.getParameter("tlrPw");
		String tlrName=request.getParameter("tlrName");
		String tlrRrn=request.getParameter("tlrRrn");		
		String tlrTel=request.getParameter("tlrTel");				
		String tlrCel=request.getParameter("tlrCel");				
		String tlrAddr=request.getParameter("tlrAddr");
		String tlrEmail=request.getParameter("tlrEmail");
		
		if(tlrId == null || tlrId.trim().length() == 0 ||
		   tlrPw == null || tlrPw.trim().length() == 0 ||		
		   tlrName == null || tlrName.trim().length() == 0 ||
		   tlrRrn == null  || tlrRrn.trim().length() == 0 ||
		   tlrTel == null || tlrTel.trim().length() == 0 ||
		   tlrCel == null || tlrCel.trim().length() == 0 ||
		   tlrAddr == null || tlrAddr.trim().length() == 0 ||
		   tlrEmail == null || tlrEmail.trim().length() == 0){
			request.setAttribute("error","텔러가입을위한 값들이 채워지지 않았습니다.");
			return;
		}
		
		TellerBean tContent=new TellerBean(tlrId,tlrPw,tlrName,tlrRrn,tlrTel,tlrCel,tlrAddr,tlrEmail);
		System.out.println(tContent);
		try{
			if(TellerDao.getRetrieveTlrId(tlrId) != null){
				request.setAttribute("error", "이미 가입된 텔러 아이디입니다.");
				return;
			}
			if(TellerDao.setRegisterTlr(tContent)!= 0){
				request.setAttribute("check", tContent);
			}else{
				request.setAttribute("error","teller insert에러");
			}
		}catch (Exception e) {
				e.printStackTrace();					
		}
	}	
}
