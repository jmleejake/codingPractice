package testDBdelete;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.exsoft.cs.client.IxClient;
import com.ibatis.sqlmap.client.SqlMapClient;

public class TestDBdeleteApplication {
	
	/**
	 * iBatis를 사용하기 위한 class입니다!!
	 * 
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 */
			
	public static void main(String[] args) throws SQLException, IOException {

		SqlMapClient sqlMap = MyAppSqlMapConfig.getSqlMapInstance();
		IxClient ixClient = new IxClient();
		TestDBdeleteDao testDBdeleteDao = new TestDBdeleteDao();
		
		int result = 0;
		
		Properties p = MyAppSqlMapConfig.getProperties();
		String service = p.getProperty("service");
		String volume = p.getProperty("volume");
		String ip = p.getProperty("ip"); 
		
		String path = null;
		String page_id = null;
		String doc_id = null;
		
		List<TestDBdel> delList = testDBdeleteDao.selectContentPath(sqlMap);
		
		// connect -------------------------------------
		ixClient.connect(ip, 5101);
		System.out.println("Connect OK\n--------------------");
		
		//delList가 안 비어있으면
		if(!delList.isEmpty()) {
			
			// login  -------------------------------------
			if (ixClient.login("admin", "admin")) {
				//System.out.println("Login OK\n---------------");
				System.out.println("Login OK\n---------------");
				
				for (int i = 0; i < delList.size(); i++) {
					result = testDBdeleteDao.selectContentPathCount(sqlMap);
					System.out.println("First Trashcan Document count  "+result);
					
					path = delList.get(i).getPath();
					page_id = delList.get(i).getPage_id();
					System.out.println("page_id/path  "+page_id+"  /  "+path);
					
					doc_id = delList.get(i).getDoc_id();
					System.out.println("doc_id  "+doc_id);
					
					//isExist -----------------------------------------
					if (ixClient.isExists(service, volume, path)) {
						System.out.println("isExists!!");
						
						//removeFile -------------------------------------
						if (ixClient.removeFile(service, volume, path)) {
							System.out.println("removeFile OK");
							
							//delete page
							result = testDBdeleteDao.deletePage(sqlMap, page_id);
							if(result > 0) {
								System.out.println("page delete OK");
								
								//delete filed
								result = testDBdeleteDao.deleteFiled(sqlMap, doc_id);
								if(result > 0) {
									System.out.println("filed delete OK");
									
									result = testDBdeleteDao.deleteLinked(sqlMap, doc_id);
									if(result > 0) {
										System.out.println("linked delete OK");
										
										result = testDBdeleteDao.deleteDocument(sqlMap, doc_id);
										if(result > 0) {
											System.out.println("document delete OK");
											
											result = testDBdeleteDao.selectContentPathCount(sqlMap);
											System.out.println("Final Trashcan Document count  "+result);
											System.out.println();
										}//delete document
									}//delete linked 
									else {
										System.err.println("del에 있나보다!!");
										result = testDBdeleteDao.deleteLinkedDel(sqlMap, doc_id);
										if(result > 0) {
											System.out.println("linked_del delete OK");
											
											result = testDBdeleteDao.deleteDocument(sqlMap, doc_id);
											if(result > 0) {
												System.out.println("document delete OK");
												
												result = testDBdeleteDao.selectContentPathCount(sqlMap);
												System.out.println("Final Trashcan Document count  "+result);
												System.out.println();
											}//delete document
										}//delete linked_del
									}//else문 delete linked_del
								}//delete filed
							}//delete page
						}//exrep removeFile
					}//exrep isExist
					else {
						System.err.println("Content_path not exist!!");
						//delete page
						result = testDBdeleteDao.deletePage(sqlMap, page_id);
						if(result > 0) {
							System.out.println("page delete OK");
							
							//delete filed
							result = testDBdeleteDao.deleteFiled(sqlMap, doc_id);
							if(result > 0) {
								System.out.println("filed delete OK");
								
								result = testDBdeleteDao.deleteLinked(sqlMap, doc_id);
								if(result > 0) {
									System.out.println("linked delete OK");
									
									result = testDBdeleteDao.deleteDocument(sqlMap, doc_id);
									if(result > 0) {
										System.out.println("document delete OK");
										
										result = testDBdeleteDao.selectContentPathCount(sqlMap);
										System.out.println("Final Trashcan Document count  "+result);
										System.out.println();
									}//delete document
								}//delete linked 
								else {
									System.err.println("del에 있나보다!!");
									result = testDBdeleteDao.deleteLinkedDel(sqlMap, doc_id);
									if(result > 0) {
										System.out.println("linked_del delete OK");
										
										result = testDBdeleteDao.deleteDocument(sqlMap, doc_id);
										if(result > 0) {
											System.out.println("document delete OK");
											
											result = testDBdeleteDao.selectContentPathCount(sqlMap);
											System.out.println("Final Trashcan Document count  "+result);
											System.out.println();
										}//delete document
									}//delete linked_del
								}//else문 delete linked_del
							}//delete filed
						}//delete page
						else {
							System.err.println("page가 없는 아이로구나!!");
							result = testDBdeleteDao.deleteLinked(sqlMap, doc_id);
							if(result > 0) {
								System.out.println("linked delete OK");
								
								result = testDBdeleteDao.deleteDocument(sqlMap, doc_id);
								if(result > 0) {
									System.out.println("document delete OK");
									
									result = testDBdeleteDao.selectContentPathCount(sqlMap);
									System.out.println("Final Trashcan Document count  "+result);
									System.out.println();
								}//delete document
							}//delete linked 
							else {
								System.err.println("del에 있나보다!!");
								result = testDBdeleteDao.deleteLinkedDel(sqlMap, doc_id);
								if(result > 0) {
									System.out.println("linked_del delete OK");
									
									result = testDBdeleteDao.deleteDocument(sqlMap, doc_id);
									if(result > 0) {
										System.out.println("document delete OK");
										
										result = testDBdeleteDao.selectContentPathCount(sqlMap);
										System.out.println("Final Trashcan Document count  "+result);
										System.out.println();
									}//delete document
								}//delete linked_del
								else {
									System.err.println("아무것도 없구나!!");
									result = testDBdeleteDao.deleteDocument(sqlMap, doc_id);
									if(result > 0) {
										System.out.println("document delete OK");
										
										result = testDBdeleteDao.selectErasedDocumentCount(sqlMap);
										System.out.println("Final Trashcan Document count  "+result);
										System.out.println();
									}//delete document
									else {
										System.err.println("그럼... 이미 삭제된 놈이로구나!!");
									}
								}//else문 delete document
							}//else문 delete linked_del
						}//else문 delete linked
					}//exist 하지 않을때.
				}//list for문
			}//exrep login
			
			//logout -------------------------------------
		    ixClient.logout("admin");
		    System.out.println("---------------\nLogout Ok");
			
		}// list not null if문
		else {
			System.err.println("아하 그냥 링크드만 있는 놈이로구만 !!");
			System.out.println();
			//링크드만 삭제하는 Application으로 이동.
			TestDBdeleteApplication2.main(null);
		}
		
		// disconnect -------------------------------------
		ixClient.disconnect();
		System.out.println("--------------------\nDisconnect Ok");
	}//main
}
