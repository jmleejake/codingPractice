package bank.model.product.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.action.Action;
import bank.model.product.ProductBean;
import bank.model.product.ProductDao;

public class UpdateProduct implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prdCode = request.getParameter("prdCode");
		String prdName = request.getParameter("prdName");
		String inter = request.getParameter("interest");
		float interest = Float.parseFloat(inter);
		
		if(prdName == null || prdName.trim().length() == 0 ||
				interest == 0.0){
				request.setAttribute("error", "��� ĭ�� ä���� �־�� �մϴ�.");
				return;
		}
		try {
			if(ProductDao.setModifyPrd(new ProductBean(prdCode, prdName, interest))==0){
				request.setAttribute("error", "��ǰ������ �����Ͽ����ϴ�.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
