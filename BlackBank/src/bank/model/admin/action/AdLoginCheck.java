package bank.model.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.controller.action.Action;
import bank.model.admin.AdminBean;
import bank.model.admin.AdminDao;

public class AdLoginCheck implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adId=request.getParameter("id");
		String adPw=request.getParameter("pw");
		
		if(adId == null || adId.trim().length() == 0 || adPw == null || adPw.trim().length() == 0){
			request.setAttribute("error", "사용자아이디 또는 비밀번호가 입력되지 않았습니다.");
			return;
		}
		
		try{
			AdminBean adContent = AdminDao.getRetrieveAdIdPw(new AdminBean(adId,adPw));
			
			if(adContent != null){
				HttpSession session = request.getSession();
				session.setAttribute("adminMember", adContent.getAdName());
			}else{
				request.setAttribute("error","사용자아이디 또는 비밀번호가 일치하지 않습니다");
			}
		}catch (Exception e) {
			e.printStackTrace();	
		}
	}
}
