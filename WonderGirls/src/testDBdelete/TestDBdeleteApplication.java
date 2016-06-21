package testDBdelete;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.exsoft.cs.client.IxClient;
import com.ibatis.sqlmap.client.SqlMapClient;

public class TestDBdeleteApplication {
	
	/**
	 * iBatis�� ����ϱ� ���� class�Դϴ�!!
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
		
		//delList�� �� ���������
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
										System.err.println("del�� �ֳ�����!!");
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
									}//else�� delete linked_del
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
									System.err.println("del�� �ֳ�����!!");
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
								}//else�� delete linked_del
							}//delete filed
						}//delete page
						else {
							System.err.println("page�� ���� ���̷α���!!");
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
								System.err.println("del�� �ֳ�����!!");
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
									System.err.println("�ƹ��͵� ������!!");
									result = testDBdeleteDao.deleteDocument(sqlMap, doc_id);
									if(result > 0) {
										System.out.println("document delete OK");
										
										result = testDBdeleteDao.selectErasedDocumentCount(sqlMap);
										System.out.println("Final Trashcan Document count  "+result);
										System.out.println();
									}//delete document
									else {
										System.err.println("�׷�... �̹� ������ ���̷α���!!");
									}
								}//else�� delete document
							}//else�� delete linked_del
						}//else�� delete linked
					}//exist ���� ������.
				}//list for��
			}//exrep login
			
			//logout -------------------------------------
		    ixClient.logout("admin");
		    System.out.println("---------------\nLogout Ok");
			
		}// list not null if��
		else {
			System.err.println("���� �׳� ��ũ�常 �ִ� ���̷α��� !!");
			System.out.println();
			//��ũ�常 �����ϴ� Application���� �̵�.
			TestDBdeleteApplication2.main(null);
		}
		
		// disconnect -------------------------------------
		ixClient.disconnect();
		System.out.println("--------------------\nDisconnect Ok");
	}//main
}
