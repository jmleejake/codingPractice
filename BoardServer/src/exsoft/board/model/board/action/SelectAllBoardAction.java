package exsoft.board.model.board.action;

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

public class SelectAllBoardAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("MID");
			
			List<BoardDto> allBoardList = BoardDao.selectAllBoard();
			List<MemberDto> nameList = MemberDao.getOtherName(id);

			String allBoard = ""; 
			
			allBoard += "<boards>\n";
			for (int i = 0; i < allBoardList.size(); i++) {
				allBoard += "\t<allboard>\n";
				allBoard += "\t\t<cno>" + allBoardList.get(i).getCno() + "</cno>\n";
				allBoard += "\t\t<ctitle>" + allBoardList.get(i).getCtitle() + "</ctitle>\n";
				
				//수정일의 값이 null일때
				if (allBoardList.get(i).getUday() == null) {
					allBoard += "\t\t<cday>" + allBoardList.get(i).getCday() + "</cday>\n";
				}
				//수정일이 있을때
				else {
					allBoard += "\t\t<cday>" + allBoardList.get(i).getUday() + "</cday>\n";
				}
				
				//로그인한 아이디와 DB에서 긁어온 아이디가 같을때
				if(id.equals(allBoardList.get(i).getMid())){
					allBoard += "\t\t<mid>" + MemberDao.getName(id) + "</mid>\n";
					
				//로그인한 아이디와 DB에서 긁어온 아이디가 다를때
				}else{
					for (int j = 0; j < nameList.size(); j++) {
						
						//로그인한 아이디와 다른 아이디들의 리스트와 게시물을 올린 아이디의 리스트에 같은것이 있을때
						if((nameList.get(j).getMid()).equals(allBoardList.get(i).getMid())){
							allBoard += "\t\t<mid>" + nameList.get(j).getMname() + "</mid>\n";
						}
					}
				}
				allBoard += "\t</allboard>\n";
			}
			allBoard += "</boards>";
			
			response.setCharacterEncoding("utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(allBoard);
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
