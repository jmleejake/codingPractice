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
	 * iBatis�� ����ϱ� ���� class�Դϴ�!!
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
				System.out.println("\n1.������\n2.����߰�\n3.�������\n4.�������\n5.����");
				System.out.print("--> ");
				String temp = bufferedReader.readLine();
				int MenuNum = Integer.parseInt(temp);
				switch (MenuNum) {
				case 1:
					wondergirlsDao.viewMember(sqlMap);
					break;

				case 2:
					wonderGirls = new WonderGirls();
					System.out.print("��ȣ�� �Է��ϼ��� : ");
					wonderGirls.setNum(Integer.parseInt(bufferedReader
							.readLine()));
					System.out.print("�̸��� �Է��ϼ��� : ");
					wonderGirls.setName(bufferedReader.readLine());
					System.out.print("������ �Է��ϼ��� : ");
					wonderGirls.setAge(Integer.parseInt(bufferedReader
							.readLine()));
					wondergirlsDao.insertMember(sqlMap, wonderGirls);
					break;

				case 3:
					Map<String, Object> map = new HashMap<String, Object>(3);

					System.out.print("������ ��ȣ�� �Է��ϼ��� : ");
					num = new Integer(Integer.parseInt(bufferedReader
							.readLine()));
					if (!wondergirlsDao.validateMember(sqlMap, num)) {
						System.out.println("���� �����ȣ�Դϴ�.");
						break;
					}
					System.out.print("�̸��� �Է��ϼ��� : ");
					name = bufferedReader.readLine();
					System.out.print("������ �Է��ϼ��� : ");
					age = new Integer(Integer.parseInt(bufferedReader
							.readLine()));

					map.put("num", num);
					map.put("name", name);
					map.put("age", age);
					wondergirlsDao.modifyMember(sqlMap, map);
					break;

				case 4:
					System.out.print("������ �����ȣ�� �Է��ϼ��� : ");
					num = Integer.parseInt(bufferedReader.readLine());
					if (!wondergirlsDao.validateMember(sqlMap, num)) {
						System.out.println("���� �����ȣ�Դϴ�.");
						break;
					}
					wondergirlsDao.deleteMember(sqlMap, num);
					break;

				case 5:
					System.exit(0);

				default:
					System.out.println("1~5�߿��� �����ϼ���!");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���");
			}
		}
	}
}
