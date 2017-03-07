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
			//아이디에 해당하는 게시글번호 리스트
			List<BoardDto> delCnoList = BoardDao.delCnoListByMid(mid);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			
			if(MemberDao.loginMember(new MemberDto(mid,mpw))!=null){
				for (int i = 0; i < delCnoList.size(); i++) {
					//아이디, 회원탈퇴시 입력한 비밀번호,  게시글번호 리스트로 트랜잭션 처리하여
					//회원탈퇴와 동시에 해당 아이디에 대한 게시글을 모두 삭제
					MemberDao.deleteMember(new MemberDto(mid,mpw), delCnoList.get(i).getCno());
				}
				out.write("탈퇴되었습니다.");
				out.close();
			}else{
				out.write("탈퇴실패했습니다.\n비밀번호를 확인해주세요.");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
