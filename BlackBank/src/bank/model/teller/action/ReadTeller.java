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
		
		if(tlrId==null || tlrId.trim().length() == 0 || tlrId.equals("ID�� �Է��ϼ���")){
			request.setAttribute("error","�ڷ��˻��� ���� ID�� �Էµ��� �ʾҽ��ϴ�.");
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
			request.setAttribute("error", "�������� �ʴ� ID�Դϴ�.");
			e.printStackTrace();
		}
    }
	
	public String helloName(String name) {
		String message = null;
		try {
			if(TellerDao.getRetrieveTlrId(name)!=null){
				message = "�ߺ��� ID";
			}
			else{
				message = "������ ID";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
}
