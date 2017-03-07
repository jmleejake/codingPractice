package exsoft.board.model.board.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exsoft.cs.client.IxClient;

import exsoft.board.controller.action.IBoardAction;
import exsoft.board.model.board.BoardDao;
import exsoft.board.model.board.BoardDto;
import exsoft.board.model.file.FileDao;
import exsoft.board.model.file.FileDto;
import exsoft.board.model.file.FileIdRandomString;
import exsoft.board.model.member.MemberDao;
import exsoft.board.model.member.MemberDto;

public class UpdateBoardAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cno = Integer.parseInt(new String(request.getParameter("CNO").getBytes("ISO-8859-1"), "UTF-8"));
		String mid = new String(request.getParameter("MID").getBytes("ISO-8859-1"), "UTF-8");
		String mpw = new String(request.getParameter("MPW").getBytes("ISO-8859-1"), "UTF-8");
		String ctitle = new String(request.getParameter("CTITLE").getBytes("ISO-8859-1"), "UTF-8");
		String content = new String(request.getParameter("CONTENT").getBytes("ISO-8859-1"), "UTF-8");
		String file = new String(request.getParameter("FILE").getBytes("ISO-8859-1"), "UTF-8");
		String fileId = request.getParameter("FILEID");

		Properties p = new Properties();

		try {
			p.load(new FileInputStream(
					"D:/workspace/BoardServer/src/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String tempFolder = p.getProperty("TEMP_FOLDER");

		InputStream in = request.getInputStream();

		File f = new File(tempFolder + "/" + file); // pathname

		FileOutputStream fos = new FileOutputStream(f, true);

		byte[] input = new byte[4096];
		int len = -1;

		while ((len = in.read(input)) != -1) {
			fos.write(input, 0, len);
		}

		fos.close();
		in.close();

		// properties ���Ͽ��� eXrep�� ���� �������
		String ip = p.getProperty("EXREP_IP");
		int port = Integer.parseInt(p.getProperty("EXREP_PORT"));
		String id = p.getProperty("EXREP_USER_ID");
		String pw = p.getProperty("EXREP_USER_PASSWORD");
		String service = p.getProperty("EXREP_SERVICE");
		String volume = p.getProperty("EXREP_VOLUME");
		String savePath = p.getProperty("EXREP_SAVE");

		String exSavepath = savePath + "/" + fileId;

		// DB�� �ֱ����� ��ü����
		BoardDto bd = new BoardDto();

		bd.setCno(cno);
		bd.setCtitle(ctitle);
		bd.setContent(content);
		bd.setMid(mid);
		bd.setFileId(fileId);

		FileDto fdto = new FileDto();

		fdto.setFileId(fileId);
		fdto.setFileName(file.substring(0, file.lastIndexOf(".")));
		fdto.setFileType(file.substring(file.lastIndexOf(".")+1, file.length()));
		long size = f.length();
		String strSize = size + "";
		fdto.setFileSize(strSize);

		// DB�� input
		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();

			if (MemberDao.pwOK(new MemberDto(mid, mpw)) == 1) {
				if (BoardDao.updateBoard(bd) == 1 && FileDao.updateFile(fdto) == 1) {
					out.write("success");
					out.close();
				} else {
					out.write("��������!!");
					out.close();
				}
			} else {
				out.write("��й�ȣ�� Ʋ���ϴ�!!");
				out.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// ���������� ��ü
		IxClient ixClient = new IxClient();

		ixClient.connect(ip, port);

		if (ixClient.login(id, pw)) {
			System.out.println("Login Ok\n---------------");
			if (ixClient.isExists(service, volume, savePath)) {
				if (ixClient.putFile(tempFolder + "/" + file, service, volume,
						exSavepath, false)) {
					System.out.println("PutFile Ok.");
				} else
					System.out.println("Error:" + ixClient.getErrorMessage());
			} else {
				if (ixClient.createFolder(service, volume, savePath)) {
					System.out.println("CreateFolder Ok.");
				} else
					System.out.println("Error:" + ixClient.getErrorMessage());

				if (ixClient.putFile(tempFolder + "/" + file, service, volume,
						exSavepath, false)) {
					System.out.println("PutFile Ok.");
				} else
					System.out.println("Error:" + ixClient.getErrorMessage());
			}

			// logout -------------------------------------
			ixClient.logout("admin");
			System.out.println("---------------\nLogout Ok");
		}
		// disconnect -------------------------------------
		ixClient.disconnect();
		System.out.println("Disconnect Ok");
	}
}