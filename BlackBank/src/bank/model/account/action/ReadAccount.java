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
			request.setAttribute("error", "계좌를 읽어들일 계좌번호가 없습니다 입력해주세요.");
			return;
		}
		
		try{
			if(accNum.equals(AccountDao.getAccNumByCltNum(new AccountBean(cltNum, accNum)))){
				request.setAttribute("accountRead", AccountDao.getRetrieveAcc(accNum));													
				request.setAttribute("tradeList", TradeDao.getRetrieveTrds(accNum));
			}else{
				request.setAttribute("error", "존재하지 않는 계좌입니다.");
			}
		}catch (Exception e) {
			request.setAttribute("error", "계좌정보와 그 거래목록 호출에 실패!!");
			e.printStackTrace();
		}		
	}
}