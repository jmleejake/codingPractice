package global.sesoc.web5.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import global.sesoc.web5.board.vo.BoardVO;
import global.sesoc.web5.board.vo.ReplyVO;

public interface IBoardMapper {
	public int insertBoard(BoardVO vo);
	public ArrayList<BoardVO> selectBoardList(HashMap<String, Object> search, RowBounds rb);
	public BoardVO selectBoard(int bno);
	public int selectBoardTotalCount(HashMap<String, Object> search);
	public int deleteBoard(HashMap<String, Object> param);
	public int updateBoard(BoardVO vo);
	public int insertReply(ReplyVO vo);
	public ArrayList<ReplyVO> selectReply(int bno);
	public int deleteReply(ReplyVO vo);
	public int updateReply(ReplyVO vo);
}
