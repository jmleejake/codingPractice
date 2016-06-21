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
	
	//����̺�ε�
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//������
	public SQLite() {
		
	}
	
	//db ����޼ҵ�
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
	
	//db close �޼ҵ�
	public void dbClose() throws SQLException {
		rs.close();
		stmt.close();
		conn.close();
	}
	
	//UPDATE, INSERT, DELETE ���� ����
    public void setQuery(String query) {
        try {
            stmt.executeUpdate(query);  
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }
     
    //SELECT Ư�� ���ڵ� �޾ƿ���
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
    
    //book ���ڵ� �޾ƿ���
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
    
    //test ���ڵ� �޾ƿ���
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
    
    //test2 ���ڵ� �޾ƿ���
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
    
    //Excel���� ����
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

			workbook = Workbook.createWorkbook(new File(excelName)); // ������ ���ϸ� ��η� ��ũ�� �� ���������� ����ϴ�.
			workbook.createSheet("Sheet", 0); // ������ ��ũ�Ͽ� ��Ʈ�� ����ϴ�. "Sheet" �� ��Ʈ���� �˴ϴ�.
			sheet = workbook.getSheet(0); // ��Ʈ�� �����ɴϴ�.

			WritableCellFormat cellFormat = new WritableCellFormat(); // ���� ��Ÿ���� �����ϱ� ���� �κ��Դϴ�.
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN); // ���� ��Ÿ���� �����մϴ�. �׵θ��� ���α׸��°ſ���
			
			//String[][] column = new String[test2Map.size()/2][];
			String[][] column = {};
			
			// ���ۺ��� �����鼭 ������ �����͸� �ۼ��մϴ�. (������ �÷� ����)
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
		//[��ó] �ڹ�<JAVA> JXL �̿��Ͽ� ������ ���� �ʰ��� ����|�ۼ��� �޺�
    }
}
