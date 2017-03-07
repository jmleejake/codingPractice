package exsoft.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exsoft.board.model.board.BoardDao;
import exsoft.board.model.board.action.DeleteBoardAction;
import exsoft.board.model.board.action.InsertBoardAction;
import exsoft.board.model.board.action.InsertNewBoardAction;
import exsoft.board.model.board.action.ReplyBoardAction;
import exsoft.board.model.board.action.SearchBoardAction;
import exsoft.board.model.board.action.SelectAllBoardAction;
import exsoft.board.model.board.action.SelectBoardDetailAction;
import exsoft.board.model.board.action.UpdateBoardAction;
import exsoft.board.model.file.action.DownloadFileAction;
import exsoft.board.model.member.action.DeleteMemberAction;
import exsoft.board.model.member.action.IdDuplicateAction;
import exsoft.board.model.member.action.InsertMemberAction;
import exsoft.board.model.member.action.LoginAction;
import exsoft.board.model.member.action.UpdateMemberAction;

public class BoardController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("-------------------------------------------------");

		String commandAction = request.getParameter("command");
		System.out.println("◆◆◆◆◆◆◆--command= "+commandAction+" --◆◆◆◆◆◆◆");

		if(commandAction.equals("LOGIN")){//로그인
			LoginAction la = new LoginAction();
			la.execute(request, response);
		}else if(commandAction.equals("JOIN")){//회원가입
			InsertMemberAction im = new InsertMemberAction();
			im.execute(request, response);
		}else if(commandAction.equals("ALLBOARD")){//게시글 목록
			SelectAllBoardAction sab = new SelectAllBoardAction();
			sab.execute(request, response);
		}else if(commandAction.equals("INSERTBOARD")){//게시글등록
			try {
				if(BoardDao.countCno()==0){ //글이 없는 상태에서 글을 등록할때
					InsertNewBoardAction inba = new InsertNewBoardAction();
					inba.execute(request, response);
				}else{ //글이 있는 상태에서 글을 등록할때
					InsertBoardAction iba = new InsertBoardAction();
					iba.execute(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(commandAction.equals("idDUPLICATE")){//아이디중복체크
			IdDuplicateAction ida = new IdDuplicateAction();
			ida.execute(request, response);
		}else if(commandAction.equals("BOARDDETAIL")){//게시글상세조회
			SelectBoardDetailAction sbda = new SelectBoardDetailAction();
			sbda.execute(request, response);
		}else if(commandAction.equals("UPDATEBOARD")){//게시글수정
			UpdateBoardAction uba = new UpdateBoardAction();
			uba.execute(request, response);
		}else if(commandAction.equals("DELETEBOARD")){//게시글삭제
			DeleteBoardAction dba = new DeleteBoardAction();
			dba.execute(request, response);
		}else if(commandAction.equals("SEARCHBOARD")){//게시글조회
			SearchBoardAction sba = new SearchBoardAction();
			sba.execute(request, response);
		}else if(commandAction.equals("UPDATEMEMBER")){//회원수정
			UpdateMemberAction uma = new UpdateMemberAction();
			uma.execute(request, response);
		}else if(commandAction.equals("DELETEMEMBER")){//회원탈퇴
			DeleteMemberAction dma = new DeleteMemberAction();
			dma.execute(request, response);
		}else if(commandAction.equals("FILEDOWNLOAD")){//파일 다운로드
			DownloadFileAction dfa = new DownloadFileAction();
			dfa.execute(request, response);
		}else if(commandAction.equals("REPLYBOARD")){//답글 등록
			ReplyBoardAction rba = new ReplyBoardAction();
			rba.execute(request, response);
		}
	}
}
