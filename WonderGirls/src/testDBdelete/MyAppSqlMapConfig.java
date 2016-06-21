package testDBdelete;

import java.io.FileInputStream;
import java.io.Reader;
import java.util.Properties;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MyAppSqlMapConfig {
	private static final SqlMapClient sqlMap;
	 
	 static {
	  try {
	   String resource = "./testDBdelete/SqlMapConfig.xml";
	   Reader reader = Resources.getResourceAsReader(resource);
	   sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
	  } catch (Exception e) {
	   e.printStackTrace();
	   throw new RuntimeException("Error initializing class. Cause:" + e);
	  }
	 }

	 public static SqlMapClient getSqlMapInstance() {
	  return sqlMap;
	 }
	 
	 public static Properties getProperties() {
		 Properties p = new Properties();
		 
		 try {
				p.load(new FileInputStream(
						//"D:/Source/Practice/workspace/BoardServer/src/config.properties"));
						"D:/Source/Practice/workspace/WonderGirls/src/testDBdelete/SqlMapConfig.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return p;
	}

}
