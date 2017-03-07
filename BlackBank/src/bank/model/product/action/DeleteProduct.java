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
		  request.setAttribute("error", "상품삭제를 위한 값들이 채워지지 않았습니다.");
		  return;
	  }
	  
	  try{   
	   if(ProductDao.setDeletePrd(new ProductBean(prdCode, adminPw))!= 0){
	   }else{
	    request.setAttribute("error", "상품삭제에 실패하였습니다.");
	   }
	  }catch (Exception e) {
	   e.printStackTrace();    
	  }   
   }
}
