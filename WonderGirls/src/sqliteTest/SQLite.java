package sqliteTest;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class SQLite {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	//드라이브로드
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//생성자
	public SQLite() {
		
	}
	
	//db 연결메소드
	public boolean dbConnect() {
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:resource/Testdb.sqlite");
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.err.println(e.getClass().getName()+ " : "+e.getMessage());
			return false;
		}
		return true;
	}
	
	//db close 메소드
	public void dbClose() throws SQLException {
		rs.close();
		stmt.close();
		conn.close();
	}
	
	//UPDATE, INSERT, DELETE 쿼리 수행
    public void setQuery(String query) {
        try {
            stmt.executeUpdate(query);  
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }
     
    //SELECT 특정 레코드 받아오기
    public ArrayList<DataInfo> getSearchQuery(String query) {
         
        ArrayList<DataInfo> data = new ArrayList<DataInfo>();
         
        try {           
             
            rs = stmt.executeQuery(query);  
 
            DataInfo info = new DataInfo();
            info.setId(rs.getInt("id"));
            info.setName(rs.getString("name"));
            info.setBook_code(rs.getString("book_code"));
             
            data.add(info);
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
        return data;
    }
    
    //book 레코드 받아오기
    public void getSearchQuery2(String query) {
         
        try {           
             
            rs = stmt.executeQuery(query);
            
            while(rs.next()) {
            	//System.out.println("stmt executequery " + rs.getInt("id") + " : " + " code: " + rs.getString("book_code") + " / " + rs.getString("name") );
            	System.out.println("stmt executequery  - NO."+rs.getInt("id") + " / code: " + rs.getString("book_code") + " / " + rs.getString("name") );
            }
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //create table
    public void createTable(String query) {
    	try {
    		stmt.execute(query);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    //test 레코드 받아오기
    public void getSearchQuery3(String query) {
         
        try {           
             
            rs = stmt.executeQuery(query);
            
            while(rs.next()) {
            	//System.out.println("stmt executequery " + rs.getInt("id") + " : " + " code: " + rs.getString("book_code") + " / " + rs.getString("name") );
            	System.out.println("stmt executequery  - NO."+rs.getInt("id") + " / name: " + rs.getString("name") + " / age: " + rs.getString("age"));
            }
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //test2 레코드 받아오기
    public void getSearchQuery4(String query) {
         
        try {
        	
        	//List<String> test2List = new ArrayList<String>();
        	Map<String, String> test2Map = new HashMap<String, String>();
            rs = stmt.executeQuery(query);
            
            while(rs.next()) {
            	System.out.println("stmt executequery  - NO."+rs.getInt("id") + " / coffee: " + rs.getString("coffee"));
            }
            
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Excel파일 생성
    public void makeExcelFile(String query, String excelName, int columnSize) throws Exception{
    	WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		try {
			//List<String> test2List = new ArrayList<String>();
        	Map<String, String> test2Map = new HashMap<String, String>();
            rs = stmt.executeQuery(query);
            
            while(rs.next()) {
            	test2Map.put("Number"+rs.getInt("id"), "NO."+rs.getInt("id"));
            	test2Map.put("Coffee"+rs.getInt("id"), rs.getString("coffee"));
            }
            System.out.println(test2Map);
            System.out.println("size  "+test2Map.size());

			workbook = Workbook.createWorkbook(new File(excelName)); // 지정된 파일명 경로로 워크북 즉 엑셀파일을 만듭니다.
			workbook.createSheet("Sheet", 0); // 지정한 워크북에 싯트를 만듭니다. "Sheet" 가 싯트명이 됩니다.
			sheet = workbook.getSheet(0); // 시트를 가져옵니다.

			WritableCellFormat cellFormat = new WritableCellFormat(); // 셀의 스타일을 지정하기 위한 부분입니다.
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN); // 셀의 스타일을 지정합니다. 테두리에 라인그리는거에요
			
			//String[][] column = new String[test2Map.size()/2][];
			String[][] column = {};
			
			// 빙글빙글 돌리면서 엑셀에 데이터를 작성합니다. (맨윗줄 컬럼 생성)
//			for (int row = 0; row < column.length; row++) {
//				System.out.println("column.length  "+column.length);
//				for (int col = 0; col < column[0].length; col++) {
//					System.out.println("column[0].length  "+column[0].length);
//					Label label = new jxl.write.Label(col, row, (String) column[row][col], cellFormat);
//					sheet.addCell(label);
//				}
//			}
			
			column[0][0] = "Number";
			column[0][1] = "Coffee";
			
			for (int i = 1; i < test2Map.size()/2+1; i++) {
				System.out.println("row"+i);
				for (int j = 0; j < columnSize; j++) {
					System.out.println("col"+j);
					column[i][j] = test2Map.get("Number"+i);
					column[i][(j+1)] = test2Map.get("Coffee"+i);
					//System.out.println("column["+i+"]["+j+"]  "+test2Map.get("Number"+i));
					//System.out.println("column["+i+"]["+(j+1)+"]  "+test2Map.get("Coffee"+i));
				}
			}

			workbook.write();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (workbook != null)
					workbook.close();
			} catch (WriteException e) {
				// e.printStackTrace();
			} catch (IOException e) {
				// e.printStackTrace();
			}
		} 
		//[출처] 자바<JAVA> JXL 이용하여 엑셀에 쓰기 초간단 예제|작성자 달빛
    }
}
