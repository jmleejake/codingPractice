package exsoft.board.model.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exsoft.board.controller.action.IBoardAction;
import exsoft.board.model.member.MemberDao;
import exsoft.board.model.member.MemberDto;

public class LoginAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("MID");
		String pw = request.getParameter("MPW");
		
		try {
			MemberDto md = MemberDao.loginMember(new MemberDto(id,pw));
			
			response.setCharacterEncoding("utf-8");
			PrintWriter pwr = response.getWriter();
			String result = "";
			
			if(md != null){
				String r= "LOGINSUCCESS";
				result += "<member>\n";
				result += "\t<mid>"+md.getMid()+"</mid>\n";
				result += "\t<mpw>"+md.getMpw()+"</mpw>\n";
				result += "\t<mname>"+md.getMname()+"</mname>\n";
				result += "\t<mtel>"+md.getMtel()+"</mtel>\n";
				result += "\t<mjuso>"+md.getMjuso()+"</mjuso>\n";
				result += "\t<result>"+r+"</result>\n";
				result += "</member>";
				pwr.write(result);
				pwr.close();
			}else{
				String r = "LOGINFAIL";
				result += "<member>\n";
				result += "\t<fail>"+r+"</fail>\n";
				result += "</member>";
				pwr.write(result);
				pwr.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
