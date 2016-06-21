package jyp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

public class WondergirlsDao {
	
	@SuppressWarnings("unchecked")
	public void viewMember(SqlMapClient sqlMap) throws SQLException {
		List<WonderGirls> wonderGirlsList = (List<WonderGirls>) sqlMap
				.queryForList("WonderGirls.getWondergirls");
		for (int i = 0; i < wonderGirlsList.size(); i++) {
			WonderGirls wonderGirl = (WonderGirls) wonderGirlsList.get(i);
			System.out.print("번호 : " + wonderGirl.getNum());
			System.out.print("   이름 : " + wonderGirl.getName());
			System.out.println("   나이 : " + wonderGirl.getAge());
		}
	}

	public void insertMember(SqlMapClient sqlMap, WonderGirls wonderGirls)
			throws SQLException {
		sqlMap.insert("WonderGirls.insertWondergirl", wonderGirls);
		System.out.println("추가에 성공했습니다.");
	}

	public void modifyMember(SqlMapClient sqlMap, Map<String, Object> map)
			throws SQLException {
		sqlMap.update("WonderGirls.updateWondergirl", map);
		System.out.println("수정에 성공했습니다.");
	}

	public void deleteMember(SqlMapClient sqlMap, int num) throws IOException,
			SQLException {
		sqlMap.delete("WonderGirls.deleteWondergirl", num);
		System.out.println("삭제에 성공했습니다.");
	}

	public boolean validateMember(SqlMapClient sqlMap, int num)
			throws SQLException {
		WonderGirls wonderGirls = (WonderGirls) sqlMap.queryForObject(
				"WonderGirls.selectWondergirl", num);

		if (wonderGirls == null) {
			return false;
		}
		return true;
	}

}
