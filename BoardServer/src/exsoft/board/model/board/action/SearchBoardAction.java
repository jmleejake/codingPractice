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
		 * �޺��ڽ����� ������ ����
		 * 0 = �ۼ���
		 * 1 = ����
		 * 2 = ����
		 * */
		int selectedNumberInComboBox = Integer.parseInt(request.getParameter("NUMBER")); 
		
		try {
			/*
			 * �α����� ���̵�� �ٸ� 
			 * �Խñ� ��Ͽ� �ִ� �̸��� ��������
			 * */
			List<MemberDto> nameList = MemberDao.getOtherName(id);
			
			String sResult = "";
			
			if (selectedNumberInComboBox==0) {
				//�ۼ��ڷ� �Խñ� �˻�
				String mid = MemberDao.getId(search);
				List<BoardDto> searchResult = BoardDao.searchBoardByMname(mid);
				
				if(searchResult.isEmpty() == false){
					sResult += "<boardList>\n";
					for (int i = 0; i < searchResult.size(); i++) {
						sResult += "\t<searchList>\n";
						sResult += "\t\t<cno>" + searchResult.get(i).getCno() + "</cno>\n";
						sResult += "\t\t<ctitle>" + searchResult.get(i).getCtitle() + "</ctitle>\n";
						
						//�������� ���� null�϶�
						if (searchResult.get(i).getUday() == null) {
							sResult += "\t\t<cday>" + searchResult.get(i).getCday() + "</cday>\n";
						}
						//�������� ������
						else {
							sResult += "\t\t<cday>" + searchResult.get(i).getUday() + "</cday>\n";
						}
						
						//�α����� ���̵�� DB���� �ܾ�� ���̵� ������
						if(id.equals(searchResult.get(i).getMid())){
							sResult += "\t\t<mid>" + MemberDao.getName(id) + "</mid>\n";
							
						//�α����� ���̵�� DB���� �ܾ�� ���̵� �ٸ���
						}else{
							for (int j = 0; j < nameList.size(); j++) {
								
								//�α����� ���̵�� �ٸ� ���̵���� ����Ʈ�� �Խù��� �ø� ���̵��� ����Ʈ�� �������� ������
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
				//searchResult�� isEmpty���� true�϶� (������� ������)
				else{
					sResult += "fail";
					
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.write(sResult);
					out.close();
				}
				
				
			} else if(selectedNumberInComboBox==1){
				//�������� �Խñ� �˻�
				List<BoardDto> searchResult = BoardDao.searchBoardByCtitle(search);
				
				if(searchResult.isEmpty() == false){
					sResult += "<boardList>\n";
					for (int i = 0; i < searchResult.size(); i++) {
						sResult += "\t<searchList>\n";
						sResult += "\t\t<cno>" + searchResult.get(i).getCno() + "</cno>\n";
						sResult += "\t\t<ctitle>" + searchResult.get(i).getCtitle() + "</ctitle>\n";
						
						//�������� ���� null�϶�
						if (searchResult.get(i).getUday() == null) {
							sResult += "\t\t<cday>" + searchResult.get(i).getCday() + "</cday>\n";
						}
						//�������� ������
						else {
							sResult += "\t\t<cday>" + searchResult.get(i).getUday() + "</cday>\n";
						}
						
						//�α����� ���̵�� DB���� �ܾ�� ���̵� ������
						if(id.equals(searchResult.get(i).getMid())){
							sResult += "\t\t<mid>" + MemberDao.getName(id) + "</mid>\n";
							
						//�α����� ���̵�� DB���� �ܾ�� ���̵� �ٸ���
						}else{
							for (int j = 0; j < nameList.size(); j++) {
								
								//�α����� ���̵�� �ٸ� ���̵���� ����Ʈ�� �Խù��� �ø� ���̵��� ����Ʈ�� �������� ������
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
				//searchResult�� isEmpty���� true�϶� (������� ������)
				else{
					sResult += "fail";
					
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.write(sResult);
					out.close();
				}
				
			} else{
				//�������� �Խñ� �˻�
				List<BoardDto> searchResult = BoardDao.searchBoardByContent(search);
				
				if(searchResult.isEmpty() == false){
					sResult += "<boardList>\n";
					for (int i = 0; i < searchResult.size(); i++) {
						sResult += "\t<searchList>\n";
						sResult += "\t\t<cno>" + searchResult.get(i).getCno() + "</cno>\n";
						sResult += "\t\t<ctitle>" + searchResult.get(i).getCtitle() + "</ctitle>\n";
						
						//�������� ���� null�϶�
						if (searchResult.get(i).getUday() == null) {
							sResult += "\t\t<cday>" + searchResult.get(i).getCday() + "</cday>\n";
						}
						//�������� ������
						else {
							sResult += "\t\t<cday>" + searchResult.get(i).getUday() + "</cday>\n";
						}
						
						//�α����� ���̵�� DB���� �ܾ�� ���̵� ������
						if(id.equals(searchResult.get(i).getMid())){
							sResult += "\t\t<mid>" + MemberDao.getName(id) + "</mid>\n";
							
						//�α����� ���̵�� DB���� �ܾ�� ���̵� �ٸ���
						}else{
							for (int j = 0; j < nameList.size(); j++) {
								
								//�α����� ���̵�� �ٸ� ���̵���� ����Ʈ�� �Խù��� �ø� ���̵��� ����Ʈ�� �������� ������
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
				//searchResult�� isEmpty���� true�϶� (������� ������)
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
