package testDBdelete;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class TestDBdeleteApplication2 {
	
	/**
	 * iBatis�� ����ϱ� ���� class�Դϴ�!!
	 * 
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws SQLException, IOException {
		System.out.println("--------------------TestDBdeleteApplication2--------------------");

		SqlMapClient sqlMap = MyAppSqlMapConfig.getSqlMapInstance();
		TestDBdeleteDao testDBdeleteDao = new TestDBdeleteDao();
		
		int result = 0;
		
		List<TestDBdel> delList = testDBdeleteDao.selectErasedDocument(sqlMap);
		
		String doc_id = null;
		
		//delList�� �� ���������
		if(!delList.isEmpty()) {
			for (int i = 0; i < delList.size(); i++) {
				result = testDBdeleteDao.selectErasedDocumentCount(sqlMap);
				System.out.println("First Trashcan Document count  "+result);
				
				doc_id = delList.get(i).getDoc_id();
				System.out.println("doc_id  "+doc_id);
				
				result = testDBdeleteDao.deleteLinked(sqlMap, doc_id);
				if(result > 0) {
					System.out.println("linked delete OK");
					
					result = testDBdeleteDao.deleteDocument(sqlMap, doc_id);
					if(result > 0) {
						System.out.println("document delete OK");
						
						result = testDBdeleteDao.selectErasedDocumentCount(sqlMap);
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
							
							result = testDBdeleteDao.selectErasedDocumentCount(sqlMap);
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
					}
				}//else�� delete linked_del
			}//list for��
		}
		else {
			System.err.println("�����������뿡 �Ѱ��� ����~");
			System.out.println();
		}
		
	}//main
}
