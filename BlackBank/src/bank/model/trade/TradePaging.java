package bank.model.trade;

import java.sql.SQLException;

public class TradePaging {

	public static int getPageCount() throws SQLException {
		int count = 0;
		count = TradeDao.getCountTrds();
		int ipage = count / 7;
		int m = count % 7;
		if (m > 0) {
			ipage++;
		}
		return ipage;
	}

	public static boolean isPrevPage(int page) throws SQLException {
		if (page > TradeDao.getCountTrds()) {
			return false;
		} else if (page >= 2) {
			return true;
		}
		return false;
	}

	public static boolean isNextPage(int page) throws SQLException {
		if (page < TradeDao.getCountTrds()) {
			return true;
		}
		return false;
	}

}
