package global.sesoc.js;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {
	
	Logger log = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentDAO dao;
	
	/**
	 * 테스트 JSP페이지로 이동
	 * @return
	 */
	@RequestMapping("comm")
	public String callCommentPage() {
		log.debug("callCommentPage");
		return "commentPage";
	}
	
	/**
	 * 댓글 등록
	 * @param vo 댓글객체
	 * @return 댓글목록
	 */
	@ResponseBody
	@RequestMapping(value="addComm", method=RequestMethod.POST)
	public ArrayList<CommentVO> addComment(CommentVO vo) {
		log.debug("addComment :: \nvo={}", vo);
		int ret = dao.insertComment(vo);
		log.debug("RESULT => {}", ret);
		return dao.selectComment();
	}
	
	/**
	 * @return 댓글목록
	 */
	@ResponseBody
	@RequestMapping("showList")
	public ArrayList<CommentVO> showCommentList() {
		log.debug("showCommentList");
		return dao.selectComment();
	}
	
	/**
	 * 댓글삭제
	 * @param repno 댓글번호
	 * @return 댓글목록
	 */
	@ResponseBody
	@RequestMapping(value="delComm", method=RequestMethod.POST)
	public ArrayList<CommentVO> deleteComment(int repno) {
		log.debug("deleteComment :: \nvo={}", repno);
		int ret = dao.deleteComment(repno);
		log.debug("RESULT => {}", ret);
		return dao.selectComment();
	}
}
