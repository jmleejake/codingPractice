package bank.model.product.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.product.ProductBean;
import bank.model.product.ProductDao;

public class UpdateFormProduct implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prdCode=request.getParameter("prdCode");
		
		if(prdCode == null || prdCode.trim().length() == 0){
			request.setAttribute("error", "상품코드가 입력되지 않았습니다.");
			return;
		}
		
		try{
			request.setAttribute("resultContent", ProductDao.getRetrievePrd(prdCode));			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
