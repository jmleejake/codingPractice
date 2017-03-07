package bank.model.product.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.controller.action.Action;
import bank.model.product.ProductBean;
import bank.model.product.ProductDao;

public class ReadProduct implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prdCode=request.getParameter("prdCode");
		
		if(prdCode == null || prdCode.trim().length() == 0 || prdCode.equals("��ǰ�ڵ� �Է�")){
			request.setAttribute("error", "��ǰ�ڵ尡 �Էµ��� �ʾҽ��ϴ�.");
			return;
		}
		
		try{
			request.setAttribute("productContent", ProductDao.getRetrievePrd(prdCode));
		}catch (Exception e) {
			e.printStackTrace();					
		}
	}
}