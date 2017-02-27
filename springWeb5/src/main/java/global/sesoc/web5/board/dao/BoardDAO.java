package global.sesoc.web5.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web5.board.vo.BoardVO;
import global.sesoc.web5.board.vo.ReplyVO;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;
	
	Logger log = LoggerFactory.getLogger(BoardDAO.class);
	
	public int insertBoard(BoardVO vo) {
		log.debug("insertBoard :: \n{}", vo);
		IBoardMapper mapper = sqlSession.getMapper(IBoardMapper.class);
		return mapper.insertBoard(vo);
	}
	
	public ArrayList<BoardVO> selectBoardList(int start_record, int countPerPage, HashMap<String, Object> search) {
		log.debug("selectBoardList");
		
		/*
		 * rownum같은것을 써서 페이징 처리를 하지 않더라도 
		 * myBatis가 몇번째 로우값부터 몇개를 계산하여 반환해줌.
		 * */
		RowBounds rb = new RowBounds(start_record, countPerPage);
		IBoardMapper mapper = sqlSession.getMapper(IBoardMapper.class);
		return mapper.selectBoardList(search, rb);
	}
	
	public BoardVO selectBoard(int bno) {
		log.debug("selectBoard :: bno= {}", bno);
		IBoardMapper mapper = sqlSession.getMapper(IBoardMapper.class);
		return mapper.selectBoard(bno);
	}
	
	public int selectBoardTotalCount(HashMap<String, Object> search) {
		log.debug("selectBoardTotalCount :: map= {}", search);
		IBoardMapper mapper = sqlSession.getMapper(IBoardMapper.class);
		return mapper.selectBoardTotalCount(search);
	}
	
	public int deleteBoard(HashMap<String, Object> param) {
		log.debug("deleteBoard :: map= {}", param);
		IBoardMapper mapper = sqlSession.getMapper(IBoardMapper.class);
		return mapper.deleteBoard(param);
	}
	
	public int updateBoard(BoardVO vo) {
		log.debug("updateBoard :: \n{}", vo);
		IBoardMapper mapper = sqlSession.getMapper(IBoardMapper.class);
		return mapper.updateBoard(vo);
	}
	
	public int insertReply(ReplyVO vo) {
		log.debug("insertReply :: \n{}", vo);
		IBoardMapper mapper = sqlSession.getMapper(IBoardMapper.class);
		return mapper.insertReply(vo);
	}
	
	public ArrayList<ReplyVO> selectReply(int bno) {
		log.debug("selectReply :: bno={}", bno);
		IBoardMapper mapper = sqlSession.getMapper(IBoardMapper.class);
		return mapper.selectReply(bno);
	}
	
	public int deleteReply(ReplyVO vo) {
		log.debug("deleteReply :: \n{}", vo);
		IBoardMapper mapper = sqlSession.getMapper(IBoardMapper.class);
		return mapper.deleteReply(vo);
	}
	
	public int updateReply(ReplyVO vo) {
		log.debug("updateReply :: \n{}", vo);
		IBoardMapper mapper = sqlSession.getMapper(IBoardMapper.class);
		return mapper.updateReply(vo);
	}
}
