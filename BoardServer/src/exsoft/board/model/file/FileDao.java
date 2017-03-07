package exsoft.board.model.file;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import exsoft.board.connection.BoardSqlMapConfig;

public class FileDao {
	private static SqlMapClient sqlClient = BoardSqlMapConfig.getInstance();
	
	//���ϵ��
	public static int insertFile(FileDto fdto)throws SQLException{
		return sqlClient.update("File.insertFile", fdto);
	}
	//���ϼ���
	public static int updateFile(FileDto fdto)throws SQLException{
		return sqlClient.update("File.updateFile", fdto);
	}
	//���Ͼ��̵� ������ ���� ���� ȹ�� (�Խù� �󼼺���, �Խù� ������)
	public static FileDto selectFileDetailByFileId(String fileId)throws SQLException{
		return (FileDto)sqlClient.queryForObject("File.selectFileDetailByFileId", fileId);
	}
}
