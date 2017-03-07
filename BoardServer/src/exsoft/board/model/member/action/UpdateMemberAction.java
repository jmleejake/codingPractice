package exsoft.board.model.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exsoft.board.controller.action.IBoardAction;
import exsoft.board.model.member.MemberDao;
import exsoft.board.model.member.MemberDto;

public class UpdateMemberAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = new String(request.getParameter("MID").getBytes("ISO-8859-1"), "UTF-8");
		String mpw = new String(request.getParameter("MPW").getBytes("ISO-8859-1"), "UTF-8");
		String mname = new String(request.getParameter("MNAME").getBytes("ISO-8859-1"), "UTF-8");
		String mtel = new String(request.getParameter("MTEL").getBytes("ISO-8859-1"), "UTF-8");
		String mjuso = new String(request.getParameter("MJUSO").getBytes("ISO-8859-1"), "UTF-8");
		
		try {
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			
			if (MemberDao.updateMember(new MemberDto(mid, mpw, mname, mtel, mjuso)) == 1) {
				out.write("회원수정성공!!");
				out.close();
			} else {
				out.write("회원수정실패!!");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
