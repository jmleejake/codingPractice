package bank.model.teller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.teller.TellerBean;
import bank.model.teller.TellerDao;

public class UpdateFormTeller implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tlrId=request.getParameter("tlrId");
		
		if(tlrId == null || tlrId.trim().length() == 0){
			request.setAttribute("error","업데이트창으로 들어가기위한 아이디값이 없습니다.");
			return;				
		}				
		
		try{
			TellerBean tContent=TellerDao.getRetrieveTlr(tlrId);
			if(tContent != null){
				request.setAttribute("resultContent", tContent);			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
