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
			request.setAttribute("error", "�ֹε�Ϲ�ȣ�� �Էµ��� �ʾҽ��ϴ�.");
			return;
		}		
		
		try{			
			if(ClientDao.setRemoveClt(cltRrn)== 0){		
				request.setAttribute("error","delete����");
			}
		}catch (Exception e) {
			request.setAttribute("error", "ȸ�������� ���°� ����� �մϴ�.");
			e.printStackTrace();				
		}			
	}
}

