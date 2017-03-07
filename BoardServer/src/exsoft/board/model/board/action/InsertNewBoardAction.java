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

public class InsertNewBoardAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctitle = new String(request.getParameter("TITLE").getBytes("ISO-8859-1"), "UTF-8");
		String content = new String(request.getParameter("CONTENT").getBytes("ISO-8859-1"), "UTF-8");
		String mid = new String(request.getParameter("MID").getBytes("ISO-8859-1"), "UTF-8");
		String file = new String(request.getParameter("FILE").getBytes("ISO-8859-1"), "UTF-8");

		Properties p = new Properties();

		try {
			p.load(new FileInputStream(
					"D:/Source/Practice/workspace/BoardServer/src/config.properties"));
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

		// properties 파일에서 eXrep에 대한 정보얻기
		String ip = p.getProperty("EXREP_IP");
		int port = Integer.parseInt(p.getProperty("EXREP_PORT"));
		String id = p.getProperty("EXREP_USER_ID");
		String pw = p.getProperty("EXREP_USER_PASSWORD");
		String service = p.getProperty("EXREP_SERVICE");
		String volume = p.getProperty("EXREP_VOLUME");
		String savePath = p.getProperty("EXREP_SAVE");

		// fileId위한 랜덤스트링객체, 함수호출
		FileIdRandomString randStr = new FileIdRandomString();
		String fileId = randStr.getRandomString(7);

		String exSavepath = savePath + "/" + fileId;

		// 엑스랩접속 객체
		IxClient ixClient = new IxClient();
		
		try {
			ixClient.connect(ip, port);
			
			if (!ixClient.login(id, pw)) {
				throw new Exception("login Fail!");
			}
			
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
			
			// DB에 넣기위한 객체생성
			BoardDto bd = new BoardDto();
			
			int countCno = BoardDao.countCno();
			int finalCno = 0;
			
			if(countCno==0){
				finalCno=1;
			}

			bd.setCno(finalCno);
			bd.setCtitle(ctitle);
			bd.setContent(content);
			bd.setMid(mid);
			bd.setFileId(fileId);
			
			//글의 순서를 나타내는 position은 cno와 같고, 
			//답글인지 아닌지를 구분하는 depth의 초기값은 1이다.
			int position = 1;
			int depth = 1;
			
			bd.setPosition(position);
			bd.setDepth(depth);

			FileDto fdto = new FileDto();

			fdto.setFileId(fileId);
			fdto.setVolumeId(volume);
			fdto.setFileName(file.substring(0, file.lastIndexOf(".")));
			fdto.setFileType(file.substring(file.lastIndexOf(".")+1, file.length()));
			fdto.setFilePath(exSavepath);
			long size = f.length();
			String strSize = size + "";
			fdto.setFileSize(strSize);
			
			// DB에 input
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();

			if (BoardDao.insertBoard(bd) == 1
					&& FileDao.insertFile(fdto) == 1) {
				out.write("success");
				out.close();
			} else {
				out.write("등록실패!!");
				out.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// disconnect -------------------------------------
			ixClient.disconnect();
			System.out.println("Disconnect Ok");
		}
	}
}
