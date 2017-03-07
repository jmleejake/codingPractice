package exsoft.board.model.member;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import exsoft.board.connection.BoardSqlMapConfig;

public class MemberDao {
	private static SqlMapClient sqlClient = BoardSqlMapConfig.getInstance();
	
	//�α����Ҷ�
	public static MemberDto loginMember(MemberDto mdto)throws SQLException{
		return (MemberDto)sqlClient.queryForObject("Member.selectMember", mdto);
	}
	//ȸ������
	public static int insertMember(MemberDto mdto)throws SQLException{
		return sqlClient.update("Member.insertMember", mdto);
	}
	//���̵� �ش�Ǵ� �̸��� �����ö� (�Խñ� �󼼰˻�, �Խñ� ���)
	public static String getName(String id)throws SQLException{
		return (String)sqlClient.queryForObject("Member.getName", id);
	}
	//���̵� �ߺ�üũ
	public static String idDuplicate(String id)throws SQLException{
		return (String)sqlClient.queryForObject("Member.idDuplicate", id);
	}
	//�ش� ���̵� �ش����� �ʴ� �̸��� ������ö�(�Խñ� ����Ʈ)
	public static List<MemberDto> getOtherName(String id)throws SQLException{
		return sqlClient.queryForList("Member.getOtherName", id);
	}
	//���̵�� ��й�ȣ�� ������ üũ (�Խñ� ����, ����)
	public static int pwOK(MemberDto mdto)throws SQLException{
		return (Integer)sqlClient.queryForObject("Member.pwOK", mdto);
	}
	//�̸��� �ش��ϴ� ���̵� �����ö� (�ۼ��ڷ� �Խñ� ��ȸ)
	public static String getId(String name)throws SQLException{
		return (String)sqlClient.queryForObject("Member.getId", name);
	}
	//ȸ������
	public static int updateMember(MemberDto mdto)throws SQLException{
		return (Integer)sqlClient.update("Member.updateMember", mdto);
	}
	//ȸ������ (�Խñۻ����� �Ͼ�� Ʈ�����ó��)
	public static void deleteMember(MemberDto mdto, int delCno)throws SQLException{
		try {
			sqlClient.startTransaction();
			sqlClient.delete("Member.deleteMember", mdto);
			sqlClient.delete("Board.deleteBoard", delCno);
			sqlClient.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlClient.endTransaction();
		}
	}
}
