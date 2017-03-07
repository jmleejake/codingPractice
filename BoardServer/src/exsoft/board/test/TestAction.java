package exsoft.board.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exsoft.board.controller.action.IBoardAction;
import exsoft.board.model.board.BoardDao;
import exsoft.board.model.board.BoardDto;


public class TestAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctitle = new String(request.getParameter("TITLE").getBytes("ISO-8859-1"), "UTF-8");
		String content = new String(request.getParameter("CONTENT").getBytes("ISO-8859-1"), "UTF-8");
		String mid = new String(request.getParameter("MID").getBytes("ISO-8859-1"), "UTF-8");
		String file = new String(request.getParameter("FILE").getBytes("ISO-8859-1"), "UTF-8");
		String pos = request.getParameter("POSITION");
		String dep = request.getParameter("DEPTH");
		
		int position = Integer.parseInt(pos);
		int depth = Integer.parseInt(dep);
		
		try {
			List<BoardDto> list =  BoardDao.selectPositions(position);
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getCno());
				
				int result = BoardDao.updatePosition(list.get(i).getCno());
				
				System.out.println("result= "+result);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
