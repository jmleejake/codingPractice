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
            //db.setQuery("INSERT INTO `book` ('id', 'name', 'book_code') VALUES (NULL, '해리포터와 혼혈왕자', 'KOR0001')");
            
            //db.setQuery("INSERT INTO `book` ('id', 'name', 'book_code') VALUES (NULL, '해리포터와 마법사의돌', 'KOR0002')");
            
            //db.setQuery("INSERT INTO `book` ('id', 'name', 'book_code') VALUES (NULL, '해리포터와 비밀의 방', 'KOR0003')");
            
            //db.setQuery("INSERT INTO `book` ('id', 'name', 'book_code') VALUES (NULL, '해리포터와 아즈카반의 죄수', 'KOR0004')");
             
            //ArrayList<DataInfo> data = db.getSearchQuery("SELECT * FROM `book` WHERE name = '해리포터와 혼혈왕자'");
            
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
//        	db.setQuery("insert into test2 (id, coffee) values (null, '아메리카노')");
//        	db.setQuery("insert into test2 (id, coffee) values (null, '카페라떼')");
//        	db.setQuery("insert into test2 (id, coffee) values (null, '두유카페라떼')");
//        	db.setQuery("insert into test2 (id, coffee) values (null, '프라프치노')");
        	
//        	db.setQuery("update test2 set coffee = '아이스아메리카노' where id = 1");
//        	db.setQuery("update test2 set coffee = '두유라떼 + 바닐라시럽' where id = 3");
        	
        	
        }
        
        //ArrayList<DataInfo> data = db.getSearchQuery("SELECT * FROM book");
        
        db.getSearchQuery2("SELECT * FROM book");
        
        db.getSearchQuery3("SELECT * FROM test");
        
        db.getSearchQuery4("SELECT * FROM test2");
        
        db.makeExcelFile("SELECT * FROM test2", "D:/makeExcel.xls", 2);
        
        db.dbClose();
	}

}
