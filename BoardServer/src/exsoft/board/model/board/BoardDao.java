package exsoft.board.model.board;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import exsoft.board.connection.BoardSqlMapConfig;

public class BoardDao {
	private static SqlMapClient sqlClient = BoardSqlMapConfig.getInstance();
	
	//�Խñ� ���
	public static List<BoardDto> selectAllBoard()throws SQLException{
		return sqlClient.queryForList("Board.selectAllBoard");
	}
	//�Խñ� ���
	public static int insertBoard(BoardDto bdto)throws SQLException{
		return sqlClient.update("Board.insertBoard", bdto);
	}
	//���� ū �۹�ȣ (��� ��Ͻ�, �Խñ� ��Ͻ� �۹�ȣ ���)
	public static Integer maxCno()throws SQLException{
		return (Integer)sqlClient.queryForObject("Board.maxCno");
	}
	//�۹�ȣ ���� (��ó�� ��Ͻ� max�Լ� ��������Exception �ذ��)
	public static Integer countCno()throws SQLException{
		return (Integer)sqlClient.queryForObject("Board.countCno");
	}
	//�Խñ� �󼼺���
	public static BoardDto selectBoardDetail(int cno)throws SQLException{
		return (BoardDto)sqlClient.queryForObject("Board.selectBoardDetail", cno);
	}
	//�Խñ� ����
	public static int updateBoard(BoardDto bdto)throws SQLException{
		return (Integer)sqlClient.update("Board.updateBoard", bdto);
	}
	//�Խñ� ����
	public static int DeleteBoard(int cno)throws SQLException{
		return sqlClient.delete("Board.deleteBoard", cno);
	}
	//�Խñ� �˻� (��������)
	public static List<BoardDto> searchBoardByContent(String search)throws SQLException{
		return sqlClient.queryForList("Board.searchBoardByContent", search);
	}
	//�Խñ� �˻� (��������)
	public static List<BoardDto> searchBoardByCtitle(String search)throws SQLException{
		return sqlClient.queryForList("Board.searchBoardByCtitle", search);
	}
	//�Խñ� �˻� (�ۼ��ڷ�)
	public static List<BoardDto>searchBoardByMname(String search)throws SQLException{
		return sqlClient.queryForList("Board.searchBoardByMname", search);
	}
	//�ش� ���̵� �ش��ϴ� �۹�ȣ����Ʈ (ȸ��Ż���)
	public static List<BoardDto> delCnoListByMid(String mid)throws SQLException{
		return sqlClient.queryForList("Board.delCnoListByMid", mid);
	}
	//�ش� �Խñ۹�ȣ�� ���� ���Ͼ��̵� �������� (�Խñ� ������)
	public static String selectFileIdByCno(int cno)throws SQLException{
		return (String)sqlClient.queryForObject("Board.selectFileIdByCno", cno);
	}
	//�ش� �Խñ��� position���� ū position���� ���� �Խñ� ����Ʈ
	public static List<BoardDto> selectPositions(int pos)throws SQLException{
		return sqlClient.queryForList("Board.selectPositions", pos);
	}
	//���� ������� ���� �Խñ��� position�� +1 �ؼ� ��� ����� positionȹ��
	public static int updatePosition(int cno)throws SQLException{
		return sqlClient.update("Board.updatePosition", cno);
	}
	//��� ���
	public static int insertReply(BoardDto bdto)throws SQLException{
		return sqlClient.update("Board.insertReply", bdto);
	}
}
