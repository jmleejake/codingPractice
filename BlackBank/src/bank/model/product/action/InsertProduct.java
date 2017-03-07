package bank.model.product.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.product.ProductBean;
import bank.model.product.ProductDao;

public class InsertProduct implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prdCode = request.getParameter("prdCode");
		String prdName = request.getParameter("prdName");  
		String inter = request.getParameter("interest");
		float interest = Float.parseFloat(inter);
		String adminPw = request.getParameter("adminPw");
		
		if(prdCode == null || prdCode.trim().length() == 0 ||
		   prdName == null  || prdName.trim().length() == 0 ||
		   interest == 0.0||
		   adminPw == null || adminPw.trim().length() == 0){
			  request.setAttribute("error", "��� ĭ�� ä���� �־�� �մϴ�");
			  return;
		 }
		  
		try{
			if(ProductDao.setRegisterPrd(new ProductBean(prdCode, prdName, interest, adminPw))== 0){
				   request.setAttribute("error", "��ǰ��Ͽ� �����Ͽ����ϴ�.");    
			 }
		}catch (SQLException e) {   
			 e.printStackTrace();
		}
	} 
}