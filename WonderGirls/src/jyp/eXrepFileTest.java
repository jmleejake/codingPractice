package jyp;

import java.io.File;
import java.io.FileOutputStream;

import com.exsoft.cs.client.IxClient;
import com.exsoft.net.SizedInputStream;

public class eXrepFileTest {

	public static void main(String[] args) throws Exception {

		IxClient ixClient = new IxClient();

		// connect -------------------------------------
		ixClient.connect("150.12.2.144", 5101);
		System.out.println("Connect OK");

		// login -------------------------------------
		if (ixClient.login("admin", "admin")) {
			System.out.println("Login OK\n---------------");

			 // createFolder -------------------------------------
//			 if (ixClient.createFolder("eXrep", "Volume01", "/Test_Folder")) {
//			 System.out.println("createFolder OK");
//			 } else
//			 System.out.println("Error:" + ixClient.getErrorMessage());
//
//			 if (ixClient.isExists("eXrep", "Volume01", "/Test_Folder")) {
//				 if (ixClient.putFile("C:\\Users\\Jamin\\Documents\\네이트온 받은 파일\\Nero\\a.txt", "eXrep", "Volume01",
//				 "/Test_Folder/123.txt", true)) {
//					 System.out.println("putFile Success.");
//				 } else
//					 System.out.println("Error:" + ixClient.getErrorMessage());
//				 } else {
//					 if (ixClient.createFolder("eXrep", "Volume01", "/Test_Folder"))
//					 {
//						 System.out.println("createFolder Success.");
//					 } else
//						 System.out.println("Error:" + ixClient.getErrorMessage());
//			 }

			 // putFile -------------------------------------
//			 if (ixClient.putFile("C:/Java/a.txt", "eXrep", "Volume01",
//			 "/Board_Folder/test.txt", true)) {
//			 // putFile(원래파일이 있는 주소, 서비스이름, 볼륨이름, 루트폴더포함 eXrep에서 저장될 주소,
//			 // 오버라이트여부)
//			 System.out.println("putFile OK");
//			 } else {
//			 System.out.println("Error:" + ixClient.getErrorMessage());
//			 }
			
			 // getFile -------------------------------------
//			 SizedInputStream in = ixClient.getFile("eXrep", "Volume01",
//			 "/Test_Folder/123.txt");
//			 if (in != null) {
//			 File saveFile = new File("c:/WAS/testSuccess.txt");
//			 FileOutputStream fos = new FileOutputStream(saveFile);
//			
//			 byte[] buf = new byte[1024];
//			 int nRead = -1;
//			
//			 System.out.println("getFile Start");
//			 while ((nRead = in.read(buf)) != -1)
//			 fos.write(buf, 0, nRead);
//			 fos.flush();
//			 fos.close();
//			 in.close();
//			 System.out.println("getFile OK");
//			 } else
//			 System.out.println("Error:" + ixClient.getErrorMessage());
			
			String service = "HS_STOR";
			String volume  = "Volume01";
			String path = "/test/2014/03/25/111.txt";
			
			//isExist -----------------------------------------
			if (ixClient.isExists(service, volume, path)) {
				System.out.println("isExists!");
				
				//removeFile -------------------------------------
				if (ixClient.removeFile(service, volume, path)) {
					System.out.println("removeFile OK");
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
