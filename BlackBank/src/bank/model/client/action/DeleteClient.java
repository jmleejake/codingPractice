package bank.model.client.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.client.ClientDao;

public class DeleteClient implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String cltRrn=request.getParameter("cltRrn");		
		if(	cltRrn == null || cltRrn.trim().length() == 0){
			request.setAttribute("error", "주민등록번호가 입력되지 않았습니다.");
			return;
		}		
		
		try{			
			if(ClientDao.setRemoveClt(cltRrn)== 0){		
				request.setAttribute("error","delete에러");
			}
		}catch (Exception e) {
			request.setAttribute("error", "회원삭제시 계좌가 없어야 합니다.");
			e.printStackTrace();				
		}			
	}
}

