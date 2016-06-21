package jyp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.exsoft.cs.client.IxClient;

public class DBConnectionTest2 {

	/**
	 * Statement, PreparedStatement를 사용해보기위해 create한 class입니다.!!
	 * 
	 * @author jmlee
	 * @since 14 03 25
	 */
	public static void main(String[] args) throws SQLException, Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//DB정보 입력
		String url = "jdbc:oracle:thin:@150.12.2.144:1521:HECMDEV";
		String user = "TEST_EDMS";
		String password = "TEST_EDMS";
		
		try {
			//DB Driver정보
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
			String user_id = "his201250";
			String user_status = "C";
			
			//Statement 사용해보기
			stmt = conn.createStatement();
			String sql1 = "select * from xr_user where user_id = '"+user_id+"' and user_status = '"+user_status+"'";
			rs = stmt.executeQuery(sql1);
			
			while(rs.next()) {
				System.out.println("stmt test ResultSet   "+rs.getString("user_id")+"  "+rs.getString("user_name"));
			}
			
			//PreparedStatement 사용해보기
			String sql2 = "select * from xr_user where user_id = ? and user_status = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_status);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("pstmt test ResultSet   "+rs.getString("user_id")+"  "+rs.getString("user_name"));
			}
			
//			String delID = "his200014";
//			
//			sql2 = "delete from xr_user where user_status = 'D' and user_id = '"+delID+"'";
//			int result = stmt.executeUpdate(sql2);
//			
//			System.out.println(result+"");
//			if(result > 0) {
//				System.out.println("성공! "+result);
//			}
			sql1 = "select count(doc_id) doc_count from xr_document where doc_status = 'E'";
			rs = stmt.executeQuery(sql1);
			
			while(rs.next()) {
				int result = rs.getInt("doc_count");
				
				System.out.println("Final Trashcan Document count?!!!     "+result);
			}
			
			sql1 = "select role_id from xr_assigned where user_id='his990008' ";
			rs = stmt.executeQuery(sql1);
			
			while(rs.next()) {
				//String[] result = rs.getString("role_id");
				System.out.println(rs.getString("role_id"));
				
				if("DEPT_ADMIN".equals(rs.getString("role_id"))) {
					System.out.println("1");
					return;
				} else {
					System.out.println("2");
				}
			}
			
		} catch (Exception e) {
			System.err.println("sql error!!!");
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			pstmt.close();
			conn.close();
		}
	}
}


