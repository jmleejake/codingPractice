package exsoft.board.model.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exsoft.board.controller.action.IBoardAction;
import exsoft.board.model.member.MemberDao;
import exsoft.board.model.member.MemberDto;

public class InsertMemberAction implements IBoardAction{

	/* (non-Javadoc)
	 * @see exsoft.board.controller.action.IBoardAction#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = new String(request.getParameter("MID").getBytes("ISO-8859-1"), "UTF-8");
		String pw = new String(request.getParameter("MPW").getBytes("ISO-8859-1"), "UTF-8");
		String name = new String(request.getParameter("MNAME").getBytes("ISO-8859-1"), "UTF-8");
		String tel = new String(request.getParameter("MTEL").getBytes("ISO-8859-1"), "UTF-8");
		String juso = new String(request.getParameter("MJUSO").getBytes("ISO-8859-1"), "UTF-8");
		
		try {
			
			MemberDto md = new MemberDto();
			md.setMid(id);
			md.setMpw(pw);
			md.setMname(name);
			md.setMtel(tel);
			md.setMjuso(juso);
			
			int i = MemberDao.insertMember(md);
			
			response.setCharacterEncoding("utf-8");
			PrintWriter pwr = response.getWriter();
			String result = null;
			
			if(i == 1){
				result = "JOINSUCCESS";
				pwr.write(result);
				pwr.close();
			}else if (i == 0){
				result = "JOINFAIL";
				pwr.write(result);
				pwr.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
