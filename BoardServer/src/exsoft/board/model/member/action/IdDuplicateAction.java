package exsoft.board.model.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exsoft.board.controller.action.IBoardAction;
import exsoft.board.model.member.MemberDao;

public class IdDuplicateAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("MID");
		
		PrintWriter out = response.getWriter();
		
		try {
			String result = MemberDao.idDuplicate(mid);
			if(result != null && !result.isEmpty()){
				out.write("DUPOK");
				out.close();
			}else{
				out.write("DUPFAIL");
				out.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
