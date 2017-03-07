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
		System.out.println("�ߡߡߡߡߡߡ�--command= "+commandAction+" --�ߡߡߡߡߡߡ�");

		if(commandAction.equals("LOGIN")){//�α���
			LoginAction la = new LoginAction();
			la.execute(request, response);
		}else if(commandAction.equals("JOIN")){//ȸ������
			InsertMemberAction im = new InsertMemberAction();
			im.execute(request, response);
		}else if(commandAction.equals("ALLBOARD")){//�Խñ� ���
			SelectAllBoardAction sab = new SelectAllBoardAction();
			sab.execute(request, response);
		}else if(commandAction.equals("INSERTBOARD")){//�Խñ۵��
			try {
				if(BoardDao.countCno()==0){ //���� ���� ���¿��� ���� ����Ҷ�
					InsertNewBoardAction inba = new InsertNewBoardAction();
					inba.execute(request, response);
				}else{ //���� �ִ� ���¿��� ���� ����Ҷ�
					InsertBoardAction iba = new InsertBoardAction();
					iba.execute(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(commandAction.equals("idDUPLICATE")){//���̵��ߺ�üũ
			IdDuplicateAction ida = new IdDuplicateAction();
			ida.execute(request, response);
		}else if(commandAction.equals("BOARDDETAIL")){//�Խñۻ���ȸ
			SelectBoardDetailAction sbda = new SelectBoardDetailAction();
			sbda.execute(request, response);
		}else if(commandAction.equals("UPDATEBOARD")){//�Խñۼ���
			UpdateBoardAction uba = new UpdateBoardAction();
			uba.execute(request, response);
		}else if(commandAction.equals("DELETEBOARD")){//�Խñۻ���
			DeleteBoardAction dba = new DeleteBoardAction();
			dba.execute(request, response);
		}else if(commandAction.equals("SEARCHBOARD")){//�Խñ���ȸ
			SearchBoardAction sba = new SearchBoardAction();
			sba.execute(request, response);
		}else if(commandAction.equals("UPDATEMEMBER")){//ȸ������
			UpdateMemberAction uma = new UpdateMemberAction();
			uma.execute(request, response);
		}else if(commandAction.equals("DELETEMEMBER")){//ȸ��Ż��
			DeleteMemberAction dma = new DeleteMemberAction();
			dma.execute(request, response);
		}else if(commandAction.equals("FILEDOWNLOAD")){//���� �ٿ�ε�
			DownloadFileAction dfa = new DownloadFileAction();
			dfa.execute(request, response);
		}else if(commandAction.equals("REPLYBOARD")){//��� ���
			ReplyBoardAction rba = new ReplyBoardAction();
			rba.execute(request, response);
		}
	}
}
