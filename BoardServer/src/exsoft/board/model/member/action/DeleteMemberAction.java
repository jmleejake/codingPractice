package exsoft.board.model.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exsoft.board.controller.action.IBoardAction;
import exsoft.board.model.board.BoardDao;
import exsoft.board.model.board.BoardDto;
import exsoft.board.model.member.MemberDao;
import exsoft.board.model.member.MemberDto;

public class DeleteMemberAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = new String(request.getParameter("MID").getBytes("ISO-8859-1"), "UTF-8");
		String mpw = new String(request.getParameter("MPW").getBytes("ISO-8859-1"), "UTF-8");
		
		try {
			//���̵� �ش��ϴ� �Խñ۹�ȣ ����Ʈ
			List<BoardDto> delCnoList = BoardDao.delCnoListByMid(mid);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			
			if(MemberDao.loginMember(new MemberDto(mid,mpw))!=null){
				for (int i = 0; i < delCnoList.size(); i++) {
					//���̵�, ȸ��Ż��� �Է��� ��й�ȣ,  �Խñ۹�ȣ ����Ʈ�� Ʈ����� ó���Ͽ�
					//ȸ��Ż��� ���ÿ� �ش� ���̵� ���� �Խñ��� ��� ����
					MemberDao.deleteMember(new MemberDto(mid,mpw), delCnoList.get(i).getCno());
				}
				out.write("Ż��Ǿ����ϴ�.");
				out.close();
			}else{
				out.write("Ż������߽��ϴ�.\n��й�ȣ�� Ȯ�����ּ���.");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
