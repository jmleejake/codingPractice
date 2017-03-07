package bank.model.teller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.controller.action.Action;
import bank.model.teller.TellerBean;
import bank.model.teller.TellerDao;

public class LoginCheck implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tlrId=request.getParameter("id");		
		String tlrPw=request.getParameter("pw");
		HttpSession session = request.getSession();
		
		if(tlrId.trim().length() == 0||tlrPw.trim().length() == 0){
			request.setAttribute("error","로그인을 위한 아이디와 비밀번호값이 없습니다.");
			return;
		}		
		
		try{
			TellerBean tContent = TellerDao.getModRetrieveTlr(new TellerBean(tlrId,tlrPw));
			if(tContent != null){
				session.setAttribute("tellerMember", tContent.getTlrName());
			}else{
				request.setAttribute("error","사용자아이디 또는 비밀번호가 일치하지 않습니다");
			}	
			}catch (Exception e) {
			e.printStackTrace();	

			}
	  }
}
