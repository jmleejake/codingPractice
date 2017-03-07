package exsoft.board.model.member;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import exsoft.board.connection.BoardSqlMapConfig;

public class MemberDao {
	private static SqlMapClient sqlClient = BoardSqlMapConfig.getInstance();
	
	//로그인할때
	public static MemberDto loginMember(MemberDto mdto)throws SQLException{
		return (MemberDto)sqlClient.queryForObject("Member.selectMember", mdto);
	}
	//회원가입
	public static int insertMember(MemberDto mdto)throws SQLException{
		return sqlClient.update("Member.insertMember", mdto);
	}
	//아이디에 해당되는 이름을 가져올때 (게시글 상세검색, 게시글 목록)
	public static String getName(String id)throws SQLException{
		return (String)sqlClient.queryForObject("Member.getName", id);
	}
	//아이디 중복체크
	public static String idDuplicate(String id)throws SQLException{
		return (String)sqlClient.queryForObject("Member.idDuplicate", id);
	}
	//해당 아이디에 해당하지 않는 이름을 가지고올때(게시글 리스트)
	public static List<MemberDto> getOtherName(String id)throws SQLException{
		return sqlClient.queryForList("Member.getOtherName", id);
	}
	//아이디와 비밀번호를 가지고 체크 (게시글 수정, 삭제)
	public static int pwOK(MemberDto mdto)throws SQLException{
		return (Integer)sqlClient.queryForObject("Member.pwOK", mdto);
	}
	//이름에 해당하는 아이디를 가져올때 (작성자로 게시글 조회)
	public static String getId(String name)throws SQLException{
		return (String)sqlClient.queryForObject("Member.getId", name);
	}
	//회원수정
	public static int updateMember(MemberDto mdto)throws SQLException{
		return (Integer)sqlClient.update("Member.updateMember", mdto);
	}
	//회원삭제 (게시글삭제도 일어나게 트랜잭션처리)
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
