package bank.model.teller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.teller.TellerBean;
import bank.model.teller.TellerDao;

public class UpdateTeller implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tlrId=request.getParameter("tlrId");	
		String tlrPw=request.getParameter("tlrPw");
		String tlrTel=request.getParameter("tlrTel");			
		String tlrCel=request.getParameter("tlrCel");
		String tlrAddr=request.getParameter("tlrAddr");				
		String tlrEmail=request.getParameter("tlrEmail");
		
		if(tlrTel == null || tlrTel.trim().length() == 0 ||
			tlrCel == null || tlrCel.trim().length() == 0 ||
			tlrAddr == null || tlrAddr.trim().length() == 0 ||
			tlrEmail == null || tlrEmail.trim().length() == 0 ||
			tlrId == null || tlrId.trim().length() == 0 ||
			tlrPw == null || tlrPw.trim().length() == 0){
			
			request.setAttribute("error", "수정할 값들을 다시 입력해주세요.");
			return;
		}		
		
		try{
			TellerBean tContent = new TellerBean(tlrId,tlrPw,tlrTel,tlrCel,tlrAddr,tlrEmail);
			if(TellerDao.setModifyTlr(tContent)!= 0){
				request.setAttribute("check", tContent);
			}else{
				request.setAttribute("error","update에러");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
