package global.sesoc.js;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	Logger log = LoggerFactory.getLogger(CommentDAO.class);
	
	public int insertComment(CommentVO vo) {
		log.debug("insertComment :: vo={}", vo);
		ICommentDAO dao = sqlSession.getMapper(ICommentDAO.class);
		return dao.insertComment(vo);
	}
	
	public ArrayList<CommentVO> selectComment() {
		log.debug("selectComment");
		ICommentDAO dao = sqlSession.getMapper(ICommentDAO.class);
		return dao.selectComment();
	}
	
	public int deleteComment(int repno) {
		log.debug("deleteComment :: repno={}", repno);
		ICommentDAO dao = sqlSession.getMapper(ICommentDAO.class);
		return dao.deleteComment(repno);
	}
}
