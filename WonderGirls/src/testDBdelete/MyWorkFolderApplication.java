package testDBdelete;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class MyWorkFolderApplication {

	/**
	 * jmlee 140527 HIS에서 MYWORK클릭시 목록화면에 권한이 없다고 나오길래살펴보니
	 * creator_id가 시스템관리자로 되어있어 개인기본권한 이라도 소유자가 관리자이니 그런것!
	 * 
	 * 그리하여 코딩을하여 update를 치는것이 훨씬쉬워 코딩!
	 * 
	 * */
	public static void main(String[] args) throws SQLException, IOException {
		SqlMapClient sqlMap = MyAppSqlMapConfig.getSqlMapInstance();
		TestDBdeleteDao testDBdeleteDao = new TestDBdeleteDao();
		
		int result = 0;
		
		List<MyWorkFolderDTO> mywork = testDBdeleteDao.selectMyWorkFolder(sqlMap);
		
		for (int i = 0; i < mywork.size(); i++) {
			MyWorkFolderDTO myDTO = new MyWorkFolderDTO();
			myDTO.setCreator_id(mywork.get(i).getFolder_id());
			myDTO.setCreator_name(mywork.get(i).getFolder_name());
			myDTO.setFolder_id(mywork.get(i).getFolder_id());
			
			result = testDBdeleteDao.updateCreator(sqlMap, myDTO);
			
			if(result > 0){
				System.out.println("update 성공!! folder_id?!!   "+mywork.get(i).getFolder_id());
			}
		}
	}

}
