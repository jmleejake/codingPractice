package bank.model.teller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.teller.TellerBean;
import bank.model.teller.TellerDao;

public class ReadTeller implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tlrId=request.getParameter("tlrId");	
		
		if(tlrId==null || tlrId.trim().length() == 0 || tlrId.equals("ID를 입력하세요")){
			request.setAttribute("error","텔러검색을 위한 ID가 입력되지 않았습니다.");
			return;   
		}
			
		try{
			TellerBean tContent=TellerDao.getRetrieveTlr(tlrId);			
			if(tContent != null){
				request.setAttribute("resultContent", tContent);			
			}
			if(!TellerDao.getRetrieveTlrId(tlrId).equals(tlrId)){
			}
		}catch (Exception e) {
			request.setAttribute("error", "존재하지 않는 ID입니다.");
			e.printStackTrace();
		}
    }
	
	public String helloName(String name) {
		String message = null;
		try {
			if(TellerDao.getRetrieveTlrId(name)!=null){
				message = "중복된 ID";
			}
			else{
				message = "가능한 ID";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
}
