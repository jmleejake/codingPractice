package bank.model.teller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.controller.action.Action;
import bank.model.client.ClientDao;
import bank.model.teller.TellerDao;

public class AllTeller implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession();
			session.setAttribute("list", TellerDao.getAllRetrieveTlr());	
		}catch (Exception e) {			
			request.setAttribute("error","teller list¿¡·¯");
		}
	}	
}
