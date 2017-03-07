package bank.model.product.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.product.ProductBean;
import bank.model.product.ProductDao;

public class DeleteProduct implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	  String prdCode = request.getParameter("prdCode");
	  String adminPw = request.getParameter("adminPw");
	  
	  if(prdCode == null || prdCode.trim().length() == 0||
		 adminPw == null || adminPw.trim().length() == 0){
		  request.setAttribute("error", "��ǰ������ ���� ������ ä������ �ʾҽ��ϴ�.");
		  return;
	  }
	  
	  try{   
	   if(ProductDao.setDeletePrd(new ProductBean(prdCode, adminPw))!= 0){
	   }else{
	    request.setAttribute("error", "��ǰ������ �����Ͽ����ϴ�.");
	   }
	  }catch (Exception e) {
	   e.printStackTrace();    
	  }   
   }
}
