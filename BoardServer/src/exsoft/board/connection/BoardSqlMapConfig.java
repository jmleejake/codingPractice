package exsoft.board.connection;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class BoardSqlMapConfig {
	private static final SqlMapClient sqlClient;
	
	static {
		try {
			System.out.println("---------------------Connection----------------------");
			Reader reader = Resources.getResourceAsReader("/sqlMapConfig.xml");
			sqlClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance!!"+e,e);
		}
	}
	
	public static SqlMapClient getInstance(){
		return sqlClient;
	}
}
