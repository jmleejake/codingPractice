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

public class SearchBoardAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = new String(request.getParameter("SEARCH").getBytes("ISO-8859-1"), "UTF-8");
		String id = request.getParameter("MID");
		/*
		 * 콤보박스에서 선택한 내용
		 * 0 = 작성자
		 * 1 = 제목
		 * 2 = 내용
		 * */
		int selectedNumberInComboBox = Integer.parseInt(request.getParameter("NUMBER")); 
		
		try {
			/*
			 * 로그인한 아이디와 다른 
			 * 게시글 목록에 있는 이름들 가져오기
			 * */
			List<MemberDto> nameList = MemberDao.getOtherName(id);
			
			String sResult = "";
			
			if (selectedNumberInComboBox==0) {
				//작성자로 게시글 검색
				String mid = MemberDao.getId(search);
				List<BoardDto> searchResult = BoardDao.searchBoardByMname(mid);
				
				if(searchResult.isEmpty() == false){
					sResult += "<boardList>\n";
					for (int i = 0; i < searchResult.size(); i++) {
						sResult += "\t<searchList>\n";
						sResult += "\t\t<cno>" + searchResult.get(i).getCno() + "</cno>\n";
						sResult += "\t\t<ctitle>" + searchResult.get(i).getCtitle() + "</ctitle>\n";
						
						//수정일의 값이 null일때
						if (searchResult.get(i).getUday() == null) {
							sResult += "\t\t<cday>" + searchResult.get(i).getCday() + "</cday>\n";
						}
						//수정일이 있을때
						else {
							sResult += "\t\t<cday>" + searchResult.get(i).getUday() + "</cday>\n";
						}
						
						//로그인한 아이디와 DB에서 긁어온 아이디가 같을때
						if(id.equals(searchResult.get(i).getMid())){
							sResult += "\t\t<mid>" + MemberDao.getName(id) + "</mid>\n";
							
						//로그인한 아이디와 DB에서 긁어온 아이디가 다를때
						}else{
							for (int j = 0; j < nameList.size(); j++) {
								
								//로그인한 아이디와 다른 아이디들의 리스트와 게시물을 올린 아이디의 리스트에 같은것이 있을때
								if((nameList.get(j).getMid()).equals(searchResult.get(i).getMid())){
									sResult += "\t\t<mid>" + nameList.get(j).getMname() + "</mid>\n";
								}
							}
						}
						sResult += "\t</searchList>\n";
					}
					sResult += "</boardList>";
					
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.write(sResult);
					out.close();
				}
				//searchResult가 isEmpty값이 true일때 (결과값이 없을때)
				else{
					sResult += "fail";
					
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.write(sResult);
					out.close();
				}
				
				
			} else if(selectedNumberInComboBox==1){
				//제목으로 게시글 검색
				List<BoardDto> searchResult = BoardDao.searchBoardByCtitle(search);
				
				if(searchResult.isEmpty() == false){
					sResult += "<boardList>\n";
					for (int i = 0; i < searchResult.size(); i++) {
						sResult += "\t<searchList>\n";
						sResult += "\t\t<cno>" + searchResult.get(i).getCno() + "</cno>\n";
						sResult += "\t\t<ctitle>" + searchResult.get(i).getCtitle() + "</ctitle>\n";
						
						//수정일의 값이 null일때
						if (searchResult.get(i).getUday() == null) {
							sResult += "\t\t<cday>" + searchResult.get(i).getCday() + "</cday>\n";
						}
						//수정일이 있을때
						else {
							sResult += "\t\t<cday>" + searchResult.get(i).getUday() + "</cday>\n";
						}
						
						//로그인한 아이디와 DB에서 긁어온 아이디가 같을때
						if(id.equals(searchResult.get(i).getMid())){
							sResult += "\t\t<mid>" + MemberDao.getName(id) + "</mid>\n";
							
						//로그인한 아이디와 DB에서 긁어온 아이디가 다를때
						}else{
							for (int j = 0; j < nameList.size(); j++) {
								
								//로그인한 아이디와 다른 아이디들의 리스트와 게시물을 올린 아이디의 리스트에 같은것이 있을때
								if((nameList.get(j).getMid()).equals(searchResult.get(i).getMid())){
									sResult += "\t\t<mid>" + nameList.get(j).getMname() + "</mid>\n";
								}
							}
						}
						sResult += "\t</searchList>\n";
					}
					sResult += "</boardList>";
					
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.write(sResult);
					out.close();
				}
				//searchResult가 isEmpty값이 true일때 (결과값이 없을때)
				else{
					sResult += "fail";
					
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.write(sResult);
					out.close();
				}
				
			} else{
				//내용으로 게시글 검색
				List<BoardDto> searchResult = BoardDao.searchBoardByContent(search);
				
				if(searchResult.isEmpty() == false){
					sResult += "<boardList>\n";
					for (int i = 0; i < searchResult.size(); i++) {
						sResult += "\t<searchList>\n";
						sResult += "\t\t<cno>" + searchResult.get(i).getCno() + "</cno>\n";
						sResult += "\t\t<ctitle>" + searchResult.get(i).getCtitle() + "</ctitle>\n";
						
						//수정일의 값이 null일때
						if (searchResult.get(i).getUday() == null) {
							sResult += "\t\t<cday>" + searchResult.get(i).getCday() + "</cday>\n";
						}
						//수정일이 있을때
						else {
							sResult += "\t\t<cday>" + searchResult.get(i).getUday() + "</cday>\n";
						}
						
						//로그인한 아이디와 DB에서 긁어온 아이디가 같을때
						if(id.equals(searchResult.get(i).getMid())){
							sResult += "\t\t<mid>" + MemberDao.getName(id) + "</mid>\n";
							
						//로그인한 아이디와 DB에서 긁어온 아이디가 다를때
						}else{
							for (int j = 0; j < nameList.size(); j++) {
								
								//로그인한 아이디와 다른 아이디들의 리스트와 게시물을 올린 아이디의 리스트에 같은것이 있을때
								if((nameList.get(j).getMid()).equals(searchResult.get(i).getMid())){
									sResult += "\t\t<mid>" + nameList.get(j).getMname() + "</mid>\n";
								}
							}
						}
						sResult += "\t</searchList>\n";
					}
					sResult += "</boardList>";
					
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.write(sResult);
					out.close();
				}
				//searchResult가 isEmpty값이 true일때 (결과값이 없을때)
				else{
					sResult += "fail";
					
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.write(sResult);
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
