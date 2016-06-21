package testDBdelete;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class TestDBdeleteDao {
	
	int result = 0;
	
	/**
	 *  doc_status가 E인 문서의 content_path, doc_id, page_id를 얻는다.
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
	 *  카운트를 얻는다.
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
	 *  페이지를 삭제한다.
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
	 *  파일드 (문서-페이지)를 삭제한다.
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
	 *  링크드 (문서-폴더)를 삭제한다.
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
	 *  링크드델 (문서-폴더 삭제된거)를 삭제한다.
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
	 *  문서를 삭제한다.
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
	 *  doc_status가 E인 문서의 doc_id를 얻는다.
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
	 *  카운트를 얻는다.
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
	 * jmlee 140527 HIS에서 MYWORK클릭시 목록화면에 권한이 없다고 나오길래살펴보니
	 * creator_id가 시스템관리자로 되어있어 개인기본권한 이라도 소유자가 관리자이니 그런것!
	 * 
	 * 그리하여 코딩을하여 update를 치는것이 훨씬쉬워 코딩!
	 * 
	 * */
	
	/**
	 * jmlee 140527 mywork의 폴더리스트 구하기
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
	 * jmlee 140527 folder_id가 creator_id로되게 update
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
