package global.sesoc.js;

import java.util.ArrayList;

public interface ICommentDAO {
	public int insertComment(CommentVO vo);
	public ArrayList<CommentVO> selectComment();
	public int deleteComment(int repno);
}
