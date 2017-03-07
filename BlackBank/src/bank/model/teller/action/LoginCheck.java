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
			request.setAttribute("error","�α����� ���� ���̵�� ��й�ȣ���� �����ϴ�.");
			return;
		}		
		
		try{
			TellerBean tContent = TellerDao.getModRetrieveTlr(new TellerBean(tlrId,tlrPw));
			if(tContent != null){
				session.setAttribute("tellerMember", tContent.getTlrName());
			}else{
				request.setAttribute("error","����ھ��̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			}	
			}catch (Exception e) {
			e.printStackTrace();	

			}
	  }
}
