package jyp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

public class WondergirlsApplication {
	
	/**
	 * iBatis를 사용하기 위한 class입니다!!
	 * 
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws SQLException, IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		SqlMapClient sqlMap = MyAppSqlMapConfig.getSqlMapInstance();
		WondergirlsDao wondergirlsDao = new WondergirlsDao();
		WonderGirls wonderGirls = new WonderGirls();

		Integer age, num;
		String name;

		while (true) {
			try {
				System.out.println("\n1.멤버출력\n2.멤버추가\n3.멤버수정\n4.멤버삭제\n5.종료");
				System.out.print("--> ");
				String temp = bufferedReader.readLine();
				int MenuNum = Integer.parseInt(temp);
				switch (MenuNum) {
				case 1:
					wondergirlsDao.viewMember(sqlMap);
					break;

				case 2:
					wonderGirls = new WonderGirls();
					System.out.print("번호을 입력하세요 : ");
					wonderGirls.setNum(Integer.parseInt(bufferedReader
							.readLine()));
					System.out.print("이름을 입력하세요 : ");
					wonderGirls.setName(bufferedReader.readLine());
					System.out.print("나이을 입력하세요 : ");
					wonderGirls.setAge(Integer.parseInt(bufferedReader
							.readLine()));
					wondergirlsDao.insertMember(sqlMap, wonderGirls);
					break;

				case 3:
					Map<String, Object> map = new HashMap<String, Object>(3);

					System.out.print("수정할 번호을 입력하세요 : ");
					num = new Integer(Integer.parseInt(bufferedReader
							.readLine()));
					if (!wondergirlsDao.validateMember(sqlMap, num)) {
						System.out.println("없는 멤버번호입니다.");
						break;
					}
					System.out.print("이름을 입력하세요 : ");
					name = bufferedReader.readLine();
					System.out.print("나이을 입력하세요 : ");
					age = new Integer(Integer.parseInt(bufferedReader
							.readLine()));

					map.put("num", num);
					map.put("name", name);
					map.put("age", age);
					wondergirlsDao.modifyMember(sqlMap, map);
					break;

				case 4:
					System.out.print("삭제할 멤버번호를 입력하세요 : ");
					num = Integer.parseInt(bufferedReader.readLine());
					if (!wondergirlsDao.validateMember(sqlMap, num)) {
						System.out.println("없는 멤버번호입니다.");
						break;
					}
					wondergirlsDao.deleteMember(sqlMap, num);
					break;

				case 5:
					System.exit(0);

				default:
					System.out.println("1~5중에서 선택하세요!");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못 입력했습니다. 다시 입력하세요");
			}
		}
	}
}
