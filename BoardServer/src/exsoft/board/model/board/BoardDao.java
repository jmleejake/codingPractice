package exsoft.board.model.board;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import exsoft.board.connection.BoardSqlMapConfig;

public class BoardDao {
	private static SqlMapClient sqlClient = BoardSqlMapConfig.getInstance();
	
	//게시글 목록
	public static List<BoardDto> selectAllBoard()throws SQLException{
		return sqlClient.queryForList("Board.selectAllBoard");
	}
	//게시글 등록
	public static int insertBoard(BoardDto bdto)throws SQLException{
		return sqlClient.update("Board.insertBoard", bdto);
	}
	//제일 큰 글번호 (답글 등록시, 게시글 등록시 글번호 등록)
	public static Integer maxCno()throws SQLException{
		return (Integer)sqlClient.queryForObject("Board.maxCno");
	}
	//글번호 갯수 (맨처음 등록시 max함수 널포인터Exception 해결용)
	public static Integer countCno()throws SQLException{
		return (Integer)sqlClient.queryForObject("Board.countCno");
	}
	//게시글 상세보기
	public static BoardDto selectBoardDetail(int cno)throws SQLException{
		return (BoardDto)sqlClient.queryForObject("Board.selectBoardDetail", cno);
	}
	//게시글 수정
	public static int updateBoard(BoardDto bdto)throws SQLException{
		return (Integer)sqlClient.update("Board.updateBoard", bdto);
	}
	//게시글 삭제
	public static int DeleteBoard(int cno)throws SQLException{
		return sqlClient.delete("Board.deleteBoard", cno);
	}
	//게시글 검색 (내용으로)
	public static List<BoardDto> searchBoardByContent(String search)throws SQLException{
		return sqlClient.queryForList("Board.searchBoardByContent", search);
	}
	//게시글 검색 (제목으로)
	public static List<BoardDto> searchBoardByCtitle(String search)throws SQLException{
		return sqlClient.queryForList("Board.searchBoardByCtitle", search);
	}
	//게시글 검색 (작성자로)
	public static List<BoardDto>searchBoardByMname(String search)throws SQLException{
		return sqlClient.queryForList("Board.searchBoardByMname", search);
	}
	//해당 아이디에 해당하는 글번호리스트 (회원탈퇴시)
	public static List<BoardDto> delCnoListByMid(String mid)throws SQLException{
		return sqlClient.queryForList("Board.delCnoListByMid", mid);
	}
	//해당 게시글번호의 고유 파일아이디 가져오기 (게시글 수정시)
	public static String selectFileIdByCno(int cno)throws SQLException{
		return (String)sqlClient.queryForObject("Board.selectFileIdByCno", cno);
	}
	//해당 게시글의 position보다 큰 position값을 가진 게시글 리스트
	public static List<BoardDto> selectPositions(int pos)throws SQLException{
		return sqlClient.queryForList("Board.selectPositions", pos);
	}
	//위의 결과에서 얻은 게시글의 position에 +1 해서 답글 등록의 position획득
	public static int updatePosition(int cno)throws SQLException{
		return sqlClient.update("Board.updatePosition", cno);
	}
	//답글 등록
	public static int insertReply(BoardDto bdto)throws SQLException{
		return sqlClient.update("Board.insertReply", bdto);
	}
}
