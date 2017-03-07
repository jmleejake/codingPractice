package bank.model.client.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.client.ClientDao;

public class AllClient implements Action {
	 
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.setAttribute("list", ClientDao.getAllRetrieveClts());			
		}catch (Exception e) {
			request.setAttribute("error", "고객리스트를 불러오지 못했습니다.");
			e.printStackTrace();
		}
	}	
}
