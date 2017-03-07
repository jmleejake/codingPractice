package exsoft.board.model.file.action;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exsoft.cs.client.IxClient;
import com.exsoft.net.SizedInputStream;

import exsoft.board.controller.action.IBoardAction;

public class DownloadFileAction implements IBoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = new String(request.getParameter("FILENAME").getBytes("ISO-8859-1"), "UTF-8");
		String fileId = request.getParameter("FILEID");
				
		
		System.out.println("fileName= "+fileName+"   fileid= "+fileId);
		
		Properties p = new Properties();

		try {
			p.load(new FileInputStream(
					"D:/Source/Practice/workspace/BoardServer/src/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// properties 파일에서 eXrep에 대한 정보얻기
		String ip = p.getProperty("EXREP_IP");
		int port = Integer.parseInt(p.getProperty("EXREP_PORT"));
		String id = p.getProperty("EXREP_USER_ID");
		String pw = p.getProperty("EXREP_USER_PASSWORD");
		String service = p.getProperty("EXREP_SERVICE");
		String volume = p.getProperty("EXREP_VOLUME");
		String savePath = p.getProperty("EXREP_SAVE");

		// 엑스랩접속 객체
		IxClient ixClient = new IxClient();
		
		try {
			ixClient.connect(ip, port);

			if (!ixClient.login(id, pw)) {
				throw new Exception("login Fail!");
			}

			try {
				if (!ixClient.isExists(service, volume, savePath)) {
					throw new Exception("no exsting exrep!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			String filePath = savePath + "/" + fileId;
			// getFile -------------------------------------
			SizedInputStream in = ixClient.getFile(service, volume, filePath);

			if (in != null) {

				ServletOutputStream sos = response.getOutputStream();

				byte[] buf = new byte[4096];
				int nRead = -1;

				while ((nRead = in.read(buf)) != -1) {
					sos.write(buf, 0, nRead);
				}
				sos.flush();
				sos.close();
				in.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ixClient.disconnect();
			System.out.println("Disconnect Ok");
		}
	}
}
