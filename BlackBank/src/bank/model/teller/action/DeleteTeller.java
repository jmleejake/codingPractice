package bank.model.teller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.teller.TellerBean;
import bank.model.teller.TellerDao;

public class DeleteTeller implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tlrPw=request.getParameter("tlrPw");
		
		if(tlrPw == null || tlrPw.trim().length() == 0){
			request.setAttribute("error","비밀번호가 입력되지 않았습니다.");
			return;
		}		
		
		try{			
			if(TellerDao.setRemoveTlr(tlrPw)!= 0){
			}else{
				request.setAttribute("error","teller delete에러");
			}
		}catch (Exception e) {
			e.printStackTrace();				
		}			
	}
}
