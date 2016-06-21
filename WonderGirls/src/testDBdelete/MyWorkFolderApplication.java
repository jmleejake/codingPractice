package testDBdelete;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class MyWorkFolderApplication {

	/**
	 * jmlee 140527 HIS���� MYWORKŬ���� ���ȭ�鿡 ������ ���ٰ� �����淡���캸��
	 * creator_id�� �ý��۰����ڷ� �Ǿ��־� ���α⺻���� �̶� �����ڰ� �������̴� �׷���!
	 * 
	 * �׸��Ͽ� �ڵ����Ͽ� update�� ġ�°��� �ξ����� �ڵ�!
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
				System.out.println("update ����!! folder_id?!!   "+mywork.get(i).getFolder_id());
			}
		}
	}

}
