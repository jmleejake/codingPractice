package sqliteTest;

import java.sql.SQLException;
import java.util.ArrayList;

public class Execute {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, Exception {
		// TODO dd
		
		SQLite db = new SQLite();
        
        if (db.dbConnect() == true) {
        	//db.setQuery("delete from book");
            //db.setQuery("INSERT INTO `book` ('id', 'name', 'book_code') VALUES (NULL, '�ظ����Ϳ� ȥ������', 'KOR0001')");
            
            //db.setQuery("INSERT INTO `book` ('id', 'name', 'book_code') VALUES (NULL, '�ظ����Ϳ� �������ǵ�', 'KOR0002')");
            
            //db.setQuery("INSERT INTO `book` ('id', 'name', 'book_code') VALUES (NULL, '�ظ����Ϳ� ����� ��', 'KOR0003')");
            
            //db.setQuery("INSERT INTO `book` ('id', 'name', 'book_code') VALUES (NULL, '�ظ����Ϳ� ����ī���� �˼�', 'KOR0004')");
             
            //ArrayList<DataInfo> data = db.getSearchQuery("SELECT * FROM `book` WHERE name = '�ظ����Ϳ� ȥ������'");
            
            //System.out.println(data.get(0).getName() + " / " + data.get(0).getBook_code());
        	
        	//db.createTable("create table test (" +
        	//		"id integer primary key autoincrement not null, age varchar, name varchar)");
        	
//        	for (int i = 1; i <= 10; i++) {
//        		db.setQuery("INSERT INTO `book` ('id', 'name', 'book_code') VALUES (NULL, 'books"+i+"'"+", 'BO-"+i+"'"+")");
//			}
        	
//        	for (int i = 1; i < 10; i++) {
//    		db.setQuery("delete from `book`where book_code = 'B-"+i+"'");
//        	}
        	
//        	db.createTable("create table test2 (" +
//        			"id integer primary key autoincrement not null, coffee varchar)");
//        	
//        	db.setQuery("insert into test2 (id, coffee) values (null, '�Ƹ޸�ī��')");
//        	db.setQuery("insert into test2 (id, coffee) values (null, 'ī���')");
//        	db.setQuery("insert into test2 (id, coffee) values (null, '����ī���')");
//        	db.setQuery("insert into test2 (id, coffee) values (null, '������ġ��')");
        	
//        	db.setQuery("update test2 set coffee = '���̽��Ƹ޸�ī��' where id = 1");
//        	db.setQuery("update test2 set coffee = '������ + �ٴҶ�÷�' where id = 3");
        	
        	
        }
        
        //ArrayList<DataInfo> data = db.getSearchQuery("SELECT * FROM book");
        
        db.getSearchQuery2("SELECT * FROM book");
        
        db.getSearchQuery3("SELECT * FROM test");
        
        db.getSearchQuery4("SELECT * FROM test2");
        
        db.makeExcelFile("SELECT * FROM test2", "D:/makeExcel.xls", 2);
        
        db.dbClose();
	}

}
