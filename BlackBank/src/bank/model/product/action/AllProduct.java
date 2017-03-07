package bank.model.product.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.product.ProductDao;

public class AllProduct implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{			
			request.setAttribute("allProduct", ProductDao.getAllRetrievePrds());			
		}catch (Exception e) {
			request.setAttribute("error", "��� ��ǰ ����Ʈ�� �ҷ����� ���߽��ϴ�.");
			e.printStackTrace();
		}
	}	
}