package exsoft.board.model.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exsoft.board.controller.action.IBoardAction;
import exsoft.board.model.board.BoardDao;
import exsoft.board.model.board.BoardDto;
import exsoft.board.model.file.FileDao;
import exsoft.board.model.file.FileDto;
import exsoft.board.model.member.MemberDao;

public class SelectBoardDetailAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("CNO"));
		
		try {
			String boardDetail = "";
			BoardDto bdto = BoardDao.selectBoardDetail(cno);
			FileDto fdto = FileDao.selectFileDetailByFileId(bdto.getFileId());
			
			boardDetail += "<boardDetail>\n";
			boardDetail += "\t<cno>" + bdto.getCno() + "</cno>\n";
			boardDetail += "\t<ctitle>" + bdto.getCtitle() + "</ctitle>\n";
			boardDetail += "\t<content>" + bdto.getContent() + "</content>\n";
			boardDetail += "\t<cday>" + bdto.getCday() + "</cday>\n";
			boardDetail += "\t<mid>" + bdto.getMid() + "</mid>\n";
			boardDetail += "\t<uday>" + bdto.getUday() + "</uday>\n";
			boardDetail += "\t<mname>" + MemberDao.getName(bdto.getMid()) + "</mname>\n";
			boardDetail += "\t<fileName>" + fdto.getFileName() + "</fileName>\n";
			boardDetail += "\t<fileType>" + fdto.getFileType() + "</fileType>\n";
			boardDetail += "\t<fileSize>"  + fdto.getFileSize() + "</fileSize>\n";
			boardDetail += "\t<fileId>"  + bdto.getFileId() + "</fileId>\n";
			boardDetail += "\t<position>" + bdto.getPosition() + "</position>\n";
			boardDetail += "\t<depth>" + bdto.getDepth() + "</depth>\n";
			boardDetail += "</boardDetail>";
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.write(boardDetail);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
