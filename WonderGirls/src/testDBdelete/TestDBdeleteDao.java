package testDBdelete;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class TestDBdeleteDao {
	
	int result = 0;
	
	/**
	 *  doc_status�� E�� ������ content_path, doc_id, page_id�� ��´�.
	 * 
	 * @param sqlMap
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<TestDBdel> selectContentPath(SqlMapClient sqlMap) throws SQLException {
		List<TestDBdel> delList = 
				(List<TestDBdel>) sqlMap.queryForList("TestDBdel.selectContentPath");
		
		return delList;
	}
	
	/**
	 *  ī��Ʈ�� ��´�.
	 * 
	 * @param sqlMap
	 * @return
	 * @throws SQLException
	 */
	public int selectContentPathCount(SqlMapClient sqlMap) throws SQLException {
		result = (Integer)sqlMap.queryForObject("TestDBdel.selectContentPathCount");
		return result;
	}

	/**
	 *  �������� �����Ѵ�.
	 * 
	 * @param sqlMap
	 * @param page_id
	 * @return
	 * @throws SQLException
	 */
	public int deletePage(SqlMapClient sqlMap, String page_id) throws SQLException {
		result = sqlMap.update("TestDBdel.deletePage", page_id);
		return result;
	}
	
	/**
	 *  ���ϵ� (����-������)�� �����Ѵ�.
	 * 
	 * @param sqlMap
	 * @param doc_id
	 * @return
	 * @throws SQLException
	 */
	public int deleteFiled(SqlMapClient sqlMap, String doc_id) throws SQLException {
		result = sqlMap.update("TestDBdel.deleteFiled", doc_id);
		return result;
	}
	
	/**
	 *  ��ũ�� (����-����)�� �����Ѵ�.
	 * 
	 * @param sqlMap
	 * @param doc_id
	 * @return
	 * @throws SQLException
	 */
	public int deleteLinked(SqlMapClient sqlMap, String doc_id) throws SQLException {
		result = sqlMap.update("TestDBdel.deleteLinked", doc_id);
		return result;
	}
	
	/**
	 *  ��ũ�嵨 (����-���� �����Ȱ�)�� �����Ѵ�.
	 * 
	 * @param sqlMap
	 * @param doc_id
	 * @return
	 * @throws SQLException
	 */
	public int deleteLinkedDel(SqlMapClient sqlMap, String doc_id) throws SQLException {
		result = sqlMap.update("TestDBdel.deleteLinkedDel", doc_id);
		return result;
	}
	
	/**
	 *  ������ �����Ѵ�.
	 * 
	 * @param sqlMap
	 * @param doc_id
	 * @return
	 * @throws SQLException
	 */
	public int deleteDocument(SqlMapClient sqlMap, String doc_id) throws SQLException {
		result = sqlMap.update("TestDBdel.deleteDocument", doc_id);
		return result;
	}
	
	/**
	 *  doc_status�� E�� ������ doc_id�� ��´�.
	 * 
	 * @param sqlMap
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<TestDBdel> selectErasedDocument(SqlMapClient sqlMap) throws SQLException {
		List<TestDBdel> delList = 
				(List<TestDBdel>) sqlMap.queryForList("TestDBdel.selectErasedDocument");
		
		return delList;
	}
	
	/**
	 *  ī��Ʈ�� ��´�.
	 * 
	 * @param sqlMap
	 * @return
	 * @throws SQLException
	 */
	public int selectErasedDocumentCount(SqlMapClient sqlMap) throws SQLException {
		result = (Integer)sqlMap.queryForObject("TestDBdel.selectErasedDocumentCount");
		return result;
	}
	
	/**
	 * jmlee 140527 HIS���� MYWORKŬ���� ���ȭ�鿡 ������ ���ٰ� �����淡���캸��
	 * creator_id�� �ý��۰����ڷ� �Ǿ��־� ���α⺻���� �̶� �����ڰ� �������̴� �׷���!
	 * 
	 * �׸��Ͽ� �ڵ����Ͽ� update�� ġ�°��� �ξ����� �ڵ�!
	 * 
	 * */
	
	/**
	 * jmlee 140527 mywork�� ��������Ʈ ���ϱ�
	 * 
	 * @param sqlMap
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<MyWorkFolderDTO> selectMyWorkFolder(SqlMapClient sqlMap) throws SQLException {
		List<MyWorkFolderDTO> myworkFolList = 
				(List<MyWorkFolderDTO>)sqlMap.queryForList("selectMyWorkFolder");
		return myworkFolList;
	}
	
	/**
	 * jmlee 140527 folder_id�� creator_id�εǰ� update
	 * 
	 * @param sqlMap
	 * @param myDTO
	 * @return
	 * @throws SQLException
	 */
	public int updateCreator(SqlMapClient sqlMap, MyWorkFolderDTO myDTO) throws SQLException {
		result = sqlMap.update("updateCreator", myDTO);
		return result;
	}

}
