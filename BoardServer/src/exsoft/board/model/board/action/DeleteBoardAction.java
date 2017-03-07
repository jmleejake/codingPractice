package exsoft.board.model.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exsoft.board.controller.action.IBoardAction;
import exsoft.board.model.board.BoardDao;
import exsoft.board.model.member.MemberDao;
import exsoft.board.model.member.MemberDto;

public class DeleteBoardAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("CNO"));
		String mid = request.getParameter("MID");
		String mpw = request.getParameter("MPW");
		
		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			
			if (MemberDao.pwOK(new MemberDto(mid, mpw))==1) {
				if (BoardDao.DeleteBoard(cno)==1) {
					out.write("삭제되었습니다!!");
					out.close();
				} else {
					out.write("삭제실패!!");
					out.close();
				}
			}else{
				out.write("비밀번호가 틀립니다!!");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
