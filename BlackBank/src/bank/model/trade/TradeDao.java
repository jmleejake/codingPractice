package bank.model.trade;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TradeDao {
	private static SqlMapClient sqlMapper;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("/sqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			System.out.println(sqlMapper);
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(
					"Something bad happened while building the SqlMapClient instance."
							+ e, e);
		}
	}
	
	//계좌번호에 대한 거래목록
	public static List getRetrieveTrds(String accNum) throws SQLException {
		return sqlMapper.queryForList("Trade.getRetrieveTrds", accNum);
	}
	
	//해당 계좌번호에 대한 거래의 수 (count)
	public static int getRetrieveTrd(String accNum) throws SQLException {
		return (Integer) sqlMapper.queryForObject("Trade.getRetrieveTrd", accNum);
	}
	
	//입금, 출금
	public static int infoTrd(TradeBean trade) throws SQLException {
		return sqlMapper.update("Trade.infoTrd", trade);
	}
	
	//페이징위한 전체 거래 count
	public static int getCountTrds() throws SQLException {
		return (Integer) sqlMapper.queryForObject("Trade.getCountTrds");
	}
	
	//페이징 처리위한 페이지값
	public static List getPageTrd(TradeBean trade) throws SQLException {
		return (List) sqlMapper.queryForList("Trade.getPageTrd", trade);
	}
	
	//거래삭제
	public static int setRemoveTrd (String accNum) throws SQLException {
	      return sqlMapper.delete("Trade.setRemoveTrd", accNum);
	} 

}