package exsoft.board.model.file;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import exsoft.board.connection.BoardSqlMapConfig;

public class FileDao {
	private static SqlMapClient sqlClient = BoardSqlMapConfig.getInstance();
	
	//파일등록
	public static int insertFile(FileDto fdto)throws SQLException{
		return sqlClient.update("File.insertFile", fdto);
	}
	//파일수정
	public static int updateFile(FileDto fdto)throws SQLException{
		return sqlClient.update("File.updateFile", fdto);
	}
	//파일아이디 가지고 파일 정보 획득 (게시물 상세보기, 게시물 수정시)
	public static FileDto selectFileDetailByFileId(String fileId)throws SQLException{
		return (FileDto)sqlClient.queryForObject("File.selectFileDetailByFileId", fileId);
	}
}
