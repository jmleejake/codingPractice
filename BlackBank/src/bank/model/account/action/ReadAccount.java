package bank.model.account.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.controller.action.Action;
import bank.model.account.AccountBean;
import bank.model.account.AccountDao;
import bank.model.client.ClientBean;
import bank.model.trade.TradeDao;

public class ReadAccount implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accNum = request.getParameter("accNum");
		ClientBean cb = (ClientBean)session.getAttribute("resultContent");
		int cltNum = cb.getCltNum();
		
		if(accNum==null){
			request.setAttribute("error", "���¸� �о���� ���¹�ȣ�� �����ϴ� �Է����ּ���.");
			return;
		}
		
		try{
			if(accNum.equals(AccountDao.getAccNumByCltNum(new AccountBean(cltNum, accNum)))){
				request.setAttribute("accountRead", AccountDao.getRetrieveAcc(accNum));													
				request.setAttribute("tradeList", TradeDao.getRetrieveTrds(accNum));
			}else{
				request.setAttribute("error", "�������� �ʴ� �����Դϴ�.");
			}
		}catch (Exception e) {
			request.setAttribute("error", "���������� �� �ŷ���� ȣ�⿡ ����!!");
			e.printStackTrace();
		}		
	}
}