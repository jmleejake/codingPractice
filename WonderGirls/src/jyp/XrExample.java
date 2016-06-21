package jyp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.Properties;

import com.exsoft.cs.client.IxClient;
import com.exsoft.cs.client.model.AttrDefEntry;
import com.exsoft.cs.client.model.DocEntry;
import com.exsoft.cs.client.model.DocTypeEntry;
import com.exsoft.cs.client.model.FileEntry;
import com.exsoft.cs.client.model.FolderEntry;
import com.exsoft.cs.client.model.PageEntry;
import com.exsoft.cs.client.model.RoleEntry;
import com.exsoft.cs.client.model.ServiceEntry;
import com.exsoft.cs.client.model.SessionEntry;
import com.exsoft.cs.client.model.SystemInfo;
import com.exsoft.cs.client.model.UserEntry;
import com.exsoft.cs.client.model.VolumeEntry;
import com.exsoft.net.SizedInputStream;

public class XrExample {

	public static void main(String[] args) throws Exception {
		IxClient ixClient = new IxClient();
		
		// connect -------------------------------------
		ixClient.connect("192.168.0.51", 15101);
		System.out.println("Connect OK");
		
		// login  -------------------------------------
		if (ixClient.login("admin", "admin")) {
			System.out.println("Login OK\n---------------");
			
			 //=================================================================================================
			 //====     System Management     ==================================================================
			 //=================================================================================================
			
			 //getSystemInfo -------------------------------------
			SystemInfo sys = ixClient.getSystemInfo();
			if (sys != null) {
				System.out.println("Name:" + sys.getName() + " / Host Ip:" + sys.getHostIp() + " / Port:" + sys.getPort() + " / Connection Limit:" + sys.getConnectionLimit() + " / Current Connection:" + sys.getCurConnection() + " / Class:" + sys.getClass() + " / Status:" + sys.getStatus());
				System.out.println("getSystemInfo OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());

			//getClientList -------------------------------------
			SessionEntry[] sessions  = ixClient.getClientList();
			if (sessions != null) {
				for (int i = 0; i < sessions.length; i++)
				System.out.println("Sessions[" + i + "] Session ID:" + sessions[i].getSessionId() + " / User ID:" + sessions[i].getUserId() + " / Host IP:" + sessions[i].getHostIP() + " / Class:" + sessions[i].getClass());
				System.out.println("getClientList OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//executeSystemCommand -------------------------------------
			if (ixClient.executeSystemCommand("RESTART")) {
				System.out.println("executeSystemCommand OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//executeSystemCommand -------------------------------------
			if (ixClient.executeServiceCommand("STNEW01", "RESTART")) {
				System.out.println("executeSystemCommand OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			
			// =================================================================================================
			// ====     User Management     ====================================================================
			// =================================================================================================
			
			 //addUser -------------------------------------
			if (ixClient.addUser("lapis", "lapis", "한정민", new String[]{"Admin", "Viewer"})) {
				System.out.println("addUser OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //modifyUser -------------------------------------
			if (ixClient.modifyUser("lapis", "lapis2", "한정민2", new String[]{"Admin"})) {
				System.out.println("modifyUser OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());

			//removeUser -------------------------------------
			if (ixClient.removeUser("lapis")) {
				System.out.println("removeUser OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
		
			//getUserList -------------------------------------
			UserEntry[] users = ixClient.getUserList();
			if (users != null) {
				for (int i = 0; i < users.length; i++)
					System.out.println("User[" + i + "] ID:" + users[i].getUserId() + " / Password:" + users[i].getPassword() + " / Name:" + users[i].getUserName());
				System.out.println("getUserList OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//getUserInfo -------------------------------------
			UserEntry user = ixClient.getUserInfo("admin");
			if (user != null) {
				System.out.println("ID:" + user.getUserId() + " / Password:" + user.getPassword() + " / Name:" + user.getUserName());
				System.out.println("getUserInfo OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			
			 //=================================================================================================
			 //====     Role Management     ====================================================================
			 //=================================================================================================
			
			 //addRole -------------------------------------
			if (ixClient.addRole("observer", "관찰자", "관찰하는 사람", new String[]{"VIEW_SERVICE", "VIEW_VOLUME", "VIEW_FOLDER"})) {
				System.out.println("addRole OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());

			 //modifyRole -------------------------------------
			if (ixClient.modifyRole("observer", "관찰자2", "관찰하는 사람2", new String[]{"VIEW_SERVICE"})) {
				System.out.println("modifyRole OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());

			 //removeRole -------------------------------------
			if (ixClient.removeRole("observer")) {
				System.out.println("removeRole OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //getRoleInfo -------------------------------------
			RoleEntry role = ixClient.getRoleInfo("Viewer");
			if (role != null) {
				System.out.println("ID:" + role.getRoleId() + " / name:" + role.getRoleName() + " / Description:" + role.getDescription() + " / Permissions:" + role.getStringPermissions() + " / Class:" + role.getClass());

				String[] permissions = role.getPermissions();
				for (int i = 0; i < permissions.length; i++)
					System.out.println("Permission[" + i + "] :" + permissions[i]);

				System.out.println("getRoleInfo OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //getRoleList -------------------------------------
			RoleEntry[] roles = ixClient.getRoleList();
			if (roles != null) {
				for (int i = 0; i < roles.length; i++) {
					System.out.println("Role[" + i + "] Role ID:" + roles[i].getRoleId() + " / name:" + roles[i].getRoleName() + " / Description:" + roles[i].getDescription() + " / Permissions:" + roles[i].getStringPermissions());

					String[] permissions = roles[i].getPermissions();
					for (int j = 0; j < permissions.length; j++)
						System.out.println("Permission[" + j + "] :" + permissions[j]);
				}
				
				System.out.println("getRoleList OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			
			 //=================================================================================================
			 //=====     Service Management     ================================================================
			 //=================================================================================================
			
			 //addService -------------------------------------
			if (ixClient.addService("TEST_SERVICE", "127.0.0.1", 16101, 16101, "type", 0, 0, 0 )) {
				System.out.println("addService OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//removeService -------------------------------------
			if (ixClient.removeService("TEST_SERVICE")) {
				System.out.println("removeService OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// getServiceList -------------------------------------
			ServiceEntry[] services = ixClient.getServiceList();
			if (services != null) {
				for (int i = 0; i < services.length; i++)
					System.out.println("Service[" + i + "] Name:" + services[i].getName() + " / Host IP:" + services[i].getHostIp() + " / Port:" + services[i].getPort() + " / Status:" + services[i].getStatus());
				System.out.println("getServiceList OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			
			 //=================================================================================================
			 //====     Volume Management     ==================================================================
			 //=================================================================================================
			
			 //createVolume -------------------------------------
			if (ixClient.createVolume("STNEW01", "INDEX_VOLUME", "INDEX", "D:/eXrepSvrNew/Volumes/INDEX_VOLUME", "RAW",100000000)) {
				System.out.println("createVolume OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//removeVolume -------------------------------------
			if (ixClient.removeVolume("STNEW01", "INDEX_VOLUME")) {
				System.out.println("removeVolume OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //getVolumePath -------------------------------------
			String volumePath = ixClient.getVolumePath("STNEW01", "TEST");
			if (volumePath != null) {
				System.out.println("volumePath : " + volumePath);
				System.out.println("getVolumePath OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			 //getVolumeInfo -------------------------------------
			VolumeEntry volumeInfo = ixClient.getVolumeInfo("STNEW01", "TEST");
			if (volumeInfo != null) {
				System.out.println("Name:" + volumeInfo.getName() + " / Volume Type:" + volumeInfo.getVolumeType() + " / Store Mode:" + volumeInfo.getStoreMode() + " / Processor Class:" + volumeInfo.getProcessorClass() + " / Root Path:" + volumeInfo.getRootPath() + " / Create Date:" + volumeInfo.getCreateDate());
				System.out.println("getVolumeInfo OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			 //getVolumeList -------------------------------------
			VolumeEntry[] volumes = ixClient.getVolumeList("STNEW01");
			if (volumes != null) {
				for (int i = 0; i < volumes.length; i++)
					System.out.println("Volume[" + i + "] Name:" + volumes[i].getName() + " / Processor Class:" + volumes[i].getProcessorClass() + " / Root Path:" + volumes[i].getRootPath() + " / Store Mode:" + volumes[i].getStoreMode() + " / Volume Type:" + volumes[i].getVolumeType() + " / Create Date:" + volumes[i].getCreateDate());
				System.out.println("getVolumeList OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			
			 //=================================================================================================
			 //====     Folder Management     ==================================================================
			 //=================================================================================================
			
			 //createFolder -------------------------------------
			if (ixClient.createFolder("STNEW01", "TEST", "test_folder")) {
				System.out.println("createFolder OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			 //removeFolder -------------------------------------
			if (ixClient.removeFolder("STNEW01", "TEST", "test_folder")) {
				System.out.println("removeFolder OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// renameFolder -------------------------------------
			if (ixClient.renameFolder("STNEW01", "TEST", "old_folder", "new_folder")) {
				System.out.println("renameFolder OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //getFolderInfo -------------------------------------
			FolderEntry folderInfo = ixClient.getFolderInfo("STNEW01", "TEST", "new_folder");
			if (folderInfo != null) {
				System.out.println("Name:" + folderInfo.getName() + " / Volume Name:" + folderInfo.getVolumeName() + " / Full Path:" + folderInfo.getFullPath() + " / Class:" + folderInfo.getClass() + " / Create Date:" + folderInfo.getCreateDate());
				System.out.println("getFolderInfo OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			 //getFolderList -------------------------------------
			FolderEntry[] folders = ixClient.getFolderList("STNEW01", "Images", "/");
			if (folders != null) {
				for (int i = 0; i < folders.length; i++)
					System.out.println("Folder[" + i + "] Name:" + folders[i].getName() + " / Volume Name:" + folders[i].getVolumeName() + " / Full Path:" + folders[i].getFullPath() + " / Create Date:" + folders[i].getCreateDate());
				System.out.println("getFolderList OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//putFile -------------------------------------
			File upFile = new File("d:/sourceImage.tif");
			if (ixClient.putFile(new SizedInputStream(new FileInputStream(upFile),upFile.length()), "STNEW01", "Pictures", "/testFolder/test1.tif", true)) {
				System.out.println("putFile OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			if (ixClient.putFile("d:/sourceImage.tif", "STNEW01", "Pictures", "/testFolder/test2.tif", true)) {
				System.out.println("putFile OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());	
			
			//getFile -------------------------------------
			SizedInputStream in = ixClient.getFile("STNEW01", "Pictures", "/testFolder/test1.tif");
			if (in != null) {
				File saveFile = new File("d:/getFile.tif");
				FileOutputStream fos = new FileOutputStream(saveFile);

				byte[] buf = new byte[1024];
				int nRead = -1;
				
				System.out.println("getFile Start");
				while((nRead = in.read(buf))!= -1) fos.write(buf, 0, nRead);
				fos.flush();
				fos.close();
				in.close();
				System.out.println("getFile OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//removeFile -------------------------------------
			if (ixClient.removeFile("STNEW01", "Pictures", "/testFolder/test1.tif")) {
				System.out.println("removeFile OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//renameFile -------------------------------------
			if (ixClient.renameFile("STNEW01", "Pictures", "/mam/1.tif", "11.tif", true)) {
				System.out.println("renameFile OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			//copyFile -------------------------------------
			if (ixClient.copyFile("STNEW01", "Pictures", "/mam/2.tif", "/mam/22.tif", true)) {
				System.out.println("copyFile OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//getFileList -------------------------------------
			FileEntry[] files = ixClient.getFileList("STNEW01", "Pictures", "/testFolder");
			if (files != null) {
				for (int i = 0; i < files.length; i++)
					System.out.println("File[" + i + "] Name:" + files[i].getName() + " / Size:" + files[i].getSize() + " / Create Date:" + files[i].getCreateDate());
				System.out.println("getFileList OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			//getUniqueFileName -------------------------------------
			String fileName = ixClient.getUniqueFileName("STNEW01", "Pictures", "/car/");
			if (fileName != null) {
				System.out.println("fileName : " + fileName);
				System.out.println("getUniqueFileName OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			String fileNameEx = ixClient.getUniqueFileName("STNEW01", "Pictures", "/car/", "IMG_", "tif");
			if (fileNameEx != null) {
				System.out.println("fileNameEx : " + fileNameEx);
				System.out.println("getUniqueFileNameEx OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //isExists -------------------------------------
			if (ixClient.isExists("STNEW01", "Pictures", "/car/7-Page2.tif")) {
				System.out.println("isExists OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //=================================================================================================
			 //====     Tiff Management     ====================================================================
			 //=================================================================================================

			 //getTiffPage -------------------------------------
			if (ixClient.getTiffPage("STNEW01", "Pictures", "testFolder/sourceImage.tif", 3, "d:/getTiffPage.tif")) {
				System.out.println("getTiffPage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			SizedInputStream sis = ixClient.getTiffPage("STNEW01", "Pictures", "testFolder/sourceImage.tif", 3);
			if (sis != null) {
				File getTiffPage = new File("d:/getTiffpage2.tif");
				FileOutputStream fos = new FileOutputStream(getTiffPage);

				byte[] buffer = new byte[1024];
				int nRead = -1;
				while((nRead = sis.read(buffer)) != -1) {
					fos.write(buffer, 0, nRead);
				}
				fos.flush();
				fos.close();
				sis.close();
				
				System.out.println("getTiffPage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			 //removeTiffPage -------------------------------------
			if (ixClient.removeTiffPage("STNEW01", "Pictures", "testFolder/sourceImage.tif", 1)) {
				System.out.println("removeTiffPage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			//addTiffPage -------------------------------------
			if (ixClient.addTiffPage("STNEW01", "Pictures", "testFolder/sourceImage.tif", "d:/with_lazy_moves10.jpg")) {
				System.out.println("addTiffPage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			upFile = new File("d:/with_lazy_moves17.jpg");
			if (ixClient.addTiffPage(new SizedInputStream(new FileInputStream(upFile), upFile.length()), "STNEW01", "Pictures", "testFolder/sourceImage.tif")) {
				System.out.println("addTiffPage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//setTiffPage -------------------------------------
			if (ixClient.setTiffPage("STNEW01", "Pictures", "testFolder/sourceImage.tif", 3, "d:/with_lazy_moves32.jpg")) {
				System.out.println("setTiffPage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			File upFile2 = new File("d:/with_lazy_moves05.jpg");
			if (ixClient.setTiffPage(new SizedInputStream(new FileInputStream(upFile2), upFile2.length()), "STNEW01", "Pictures", "testFolder/sourceImage.tif", 3)) {
				System.out.println("setTiffPage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			// insertTiffPage -------------------------------------
			if (ixClient.insertTiffPage("STNEW01", "Pictures", "testFolder/sourceImage.tif", 3, "d:/with_lazy_moves17.jpg")) {
				System.out.println("insertTiffPage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			File upFile3 = new File("d:/testImage.jpg");
			if (ixClient.insertTiffPage(new SizedInputStream(new FileInputStream(upFile3), upFile3.length()), "STNEW01", "Pictures", "testFolder/test2.tif", 3)) {
				System.out.println("insertTiffPage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //getTiffPageCount -------------------------------------
			int pageCount = ixClient.getTiffPageCount("STNEW01", "Pictures", "testFolder/sourceImage.tif");
			if (pageCount != 0) {
				System.out.println("tiffPageCount : " + pageCount);
				System.out.println("getTiffPageCount OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// =================================================================================================
			// ====     Document Management     ================================================================
			// =================================================================================================

			// createDoc -------------------------------------
			String docID = ixClient.createDoc("STNEW01", "TEST", "old_folder", "test_doc", "proposal");
			if (docID != null) {
				System.out.println("docID : " + docID);
				System.out.println("createDoc OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			// copyDoc -------------------------------------
			String copiedDocID = ixClient.copyDoc("STNEW01", "7f8ef-d350f0f5eb7f", "TEST", "new_folder", "copied_doc2");
			if (copiedDocID != null) {
				System.out.println("copiedDocID : " + copiedDocID);
				System.out.println("copyDoc OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// removeDoc -------------------------------------
			if (ixClient.removeDoc("STNEW01", "7f6cda56-33b9-11de-a8ef-d350f0f5eb7f")) {
				System.out.println("removeDoc OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// renameDoc -------------------------------------
			if (ixClient.renameDoc("STNEW01", "781ac4b4-33b9-11de-a8ef-d350f0f5eb7f", "new_doc_name")) {
				System.out.println("renameDoc OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// moveDoc -------------------------------------
			if (ixClient.moveDoc("STNEW01", "781ac4b4-33b9-11de-a8ef-d350f0f5eb7f", "TEST", "new_folder")) {
				System.out.println("moveDoc OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// getDocInfo -------------------------------------
			DocEntry docInfo = ixClient.getDocInfo("STNEW01", "781ac4b4-33b9-11de-a8ef-d350f0f5eb7f");
			if (docInfo != null) {
				System.out.println("ID:" + docInfo.getId() + " / Name:" + docInfo.getName() + " / Type:" + docInfo.getType() + " / Folder ID:" + docInfo.getFolderId() + " / Total Page No:" + docInfo.getTotalPageNo() + " / Class:" + docInfo.getClass() + " / Create Date:" + docInfo.getCreateDate());
				System.out.println("getDocInfo OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			// getDocList -------------------------------------
			DocEntry[] docs = ixClient.getDocList("STNEW01", "TEST", "old_folder");
			if (docs != null) {
				for (int i = 0; i < docs.length; i++)
					System.out.println("Doc[" + i + "] ID:" + docs[i].getId() + " / Name:" + docs[i].getName() + " / Folder ID:" + docs[i].getFolderId() + " / Type:" + docs[i].getType() + " / Total Page:" + docs[i].getTotalPageNo() + " / Create Date:" + docs[i].getCreateDate());
				System.out.println("getDocList OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());


			// =================================================================================================
			// ====     Page Management     =====================================================================
			// =================================================================================================
			
			// appendPage -------------------------------------
			if (ixClient.appendPage("STNEW01", "4191f984-33bb-11de-a8ef-d350f0f5eb7f", "첨부파일", "d:/with_lazy_moves05.jpg")) {
				System.out.println("appendPage OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());

			File upFile4 = new File("d:/testImage.jpg");
			if (ixClient.appendPage(new SizedInputStream(new FileInputStream(upFile4), upFile4.length()), "STNEW01", "1d77569d-34a2-11de-b95b-23355bb7e356", "첨부파일", upFile4.getName())) {
				System.out.println("appendPage OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());

			// insertPage -------------------------------------
			if (ixClient.insertPage("STNEW01", "a877326e-39f8-11de-bfff-6b051a804b53", "3번", 3, "d:/testImage.jpg")) {
				System.out.println("insertPage OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());

			File upFile5 = new File("d:/testImage.jpg");
			if (ixClient.insertPage(new SizedInputStream(new FileInputStream(upFile5), upFile5.length()), "STNEW01", "a877326e-39f8-11de-bfff-6b051a804b53", "첨부파일2", upFile5.getName(), 3)) {
				System.out.println("insertPage OK");
			} else 
				System.out.println("Error:" + ixClient.getErrorMessage());

			 //copyPage -------------------------------------
			if (ixClient.copyPage("STNEW01", "d11633aa-28b8-11de-8473-cfb5c38b0896", 1, "cc709799-2802-11de-be41-cc1553f179d3", 2)) {
				System.out.println("copyPage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //removePage -------------------------------------
			if (ixClient.removePage("STNEW01", "4191f984-33bb-11de-a8ef-d350f0f5eb7f", 3)) {
				System.out.println("removePage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// replacePage -------------------------------------
			if (ixClient.replacePage("STNEW01", "4191f984-33bb-11de-a8ef-d350f0f5eb7f", 3, "d:/with_lazy_moves32.jpg", "d:/with_lazy_moves32.jpg")) {
				System.out.println("replacePage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			File upFile6 = new File("d:/testImage.jpg");
			if (ixClient.replacePage(new SizedInputStream(new FileInputStream(upFile6), upFile6.length()), "STNEW01", "1d77569d-34a2-11de-b95b-23355bb7e356", 3, "d:/with_lazy_moves32.jpg", upFile6.getName())) {
				System.out.println("replacePage OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			// getPageList -------------------------------------
			PageEntry[] pages = ixClient.getPageList("STNEW01", "4191f984-33bb-11de-a8ef-d350f0f5eb7f");
			if (pages != null) {
				for (int i = 0; i < pages.length; i++)
					System.out.println("page[" + i + "] Page No:" + pages[i].getPageNo() + " / Title:" + pages[i].getTitle() + " / File Name:" + pages[i].getFileName() + " / Size:" + pages[i].getSize() + " / Hash Value:" + pages[i].getHashValue() + " / Create Date:" + pages[i].getCreateDate());
				System.out.println("getPageList OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //getPageFile -------------------------------------
			if (ixClient.getPageFile("STNEW01", "4191f984-33bb-11de-a8ef-d350f0f5eb7f", 3, "d:/getPageFile.tif")) {
				System.out.println("getPageFile OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			SizedInputStream is = ixClient.getPageFile("STNEW01", "4191f984-33bb-11de-a8ef-d350f0f5eb7f", 3);
			if (is != null) {
				File getPageFile = new File("d:/getPageFile2.tif");
				FileOutputStream fos = new FileOutputStream(getPageFile);

				byte[] buffer = new byte[1024];
				int nRead = -1;
				while((nRead = is.read(buffer)) != -1) {
					fos.write(buffer, 0, nRead);
				}
				fos.flush();
				fos.close();
				is.close();
				
				System.out.println("getPageFile OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			

			 //=================================================================================================
			 //====     DocType Management     =================================================================
			// =================================================================================================

			// createDocType -------------------------------------
			AttrDefEntry[] attrdefs = new AttrDefEntry[2];
			attrdefs[0] = new AttrDefEntry("DNO","도면번호",16,true);
			attrdefs[1] = new AttrDefEntry("PNO","부품번호",32,true);
			
			if (ixClient.createDocType("STNEW01", "DRAWING", "도면문서유형", attrdefs)) {
				System.out.println("createDocType OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			//removeDocType -------------------------------------
			if (ixClient.removeDocType("STNEW01", "TEST_TYPE2")) {
				System.out.println("removeDocType OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// getDocTypeInfo -------------------------------------
			DocTypeEntry docType = ixClient.getDocTypeInfo("STNEW01", "LAPISTYPE");
			if (docType != null) {
				System.out.println("ID:" + docType.getId() + " / Name:" + docType.getName() + " / Table:" + docType.getTable() + " / Class:" + docType.getClass() + " / Create Date:" + docType.getCreateDate());
				System.out.println("getDocTypeInfo OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// getDocTypeList -------------------------------------
			DocTypeEntry[] docTypes = ixClient.getDocTypeList("STNEW01");
			if (docTypes != null) {
				for (int i = 0; i < docTypes.length; i++)
					System.out.println("docType[" + i + "] ID:" + docTypes[i].getId() + " / Name:" + docTypes[i].getName() + " / Table:" + docTypes[i].getTable() + " / Create Date:" + docTypes[i].getCreateDate());
				System.out.println("getDocTypeList OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// addDocAttr -------------------------------------
			if (ixClient.addDocAttr("STNEW01", "DRAWING", "NEWATTR","새문서속성",32,true)) {
				System.out.println("addDocAttr OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //modifyDocAttr -------------------------------------
			if (ixClient.modifyDocAttr("STNEW01", "DRAWING", "NEWATTR", "문서속성",16,false)) {
				System.out.println("modifyDocAttr OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// removeDocAttr -------------------------------------
			if (ixClient.removDocAttr("STNEW01", "LAPISTYPE", "TESTATTR")) {
				System.out.println("removeDocAttr OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());			
			 //=================================================================================================
			 //====     Attribute Management     ===============================================================
			 //=================================================================================================
			
			 //setDocAttrValues -------------------------------------
			Properties props = new Properties();
			props.setProperty("PROJECT", "123");
			props.setProperty("AUTHOR", "lapis");

			if (ixClient.setDocAttrValues("STNEW01", "4191f984-33bb-11de-a8ef-d350f0f5eb7f", props)) {
				System.out.println("setDocAttrValues OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			 //setDocAttrValue -------------------------------------
			if (ixClient.setDocAttrValue("STNEW01", "4191f984-33bb-11de-a8ef-d350f0f5eb7f", "EXTATTR", "ext")) {
				System.out.println("setDocAttrValue OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// getDocAttrValue -------------------------------------
			String docAttrValue = ixClient.getDocAttrValue("STNEW01", "4191f984-33bb-11de-a8ef-d350f0f5eb7f", "AUTHOR");
			if (docAttrValue != null) {
				System.out.println("docAttrValue : " + docAttrValue);
				System.out.println("getDocAttrValue OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			
			// getDocAttrValues -------------------------------------
			AttrDefEntry[] attrList = ixClient.getAttrList("STNEW01", "XR_DOCUMENT");
			String[] attrIds = new String[attrList.length];
			if (attrList != null) {
				for (int i = 0; i < attrList.length; i++) {
					attrIds[i] = attrList[i].getAttrId();
				}
			}
			
			Properties docAttrValues = ixClient.getDocAttrValues("STNEW01", "a877326e-39f8-11de-bfff-6b051a804b53", attrIds);
			if (docAttrValues != null) {
				Enumeration keyList = docAttrValues.propertyNames();
				while (keyList.hasMoreElements()) {
					String attrId = (String) keyList.nextElement();
					System.out.println(attrId + ":" + docAttrValues.getProperty(attrId));
				}
				System.out.println("getDocAttrValues OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());
			

			
			 //getAttrList -------------------------------------
			AttrDefEntry[] attrs = ixClient.getAttrList("STNEW01", "LAPISTYPE");
			if (attrs != null) {
				for (int i = 0; i < attrs.length; i++)
					System.out.println("Attr[" + i + "] Attr Name:" + attrs[i].getAttrName() + " / Size:" + attrs[i].getSize() + " / Domain:" + attrs[i].getDomain() + " / Class:" + attrs[i].getClass());
				System.out.println("getAttrList OK");
			} else
				System.out.println("Error:" + ixClient.getErrorMessage());

			
			 //===============================================================================================================================
			
			 //logout -------------------------------------
		    ixClient.logout("admin");
			System.out.println("---------------\nLogout Ok");
		}
		// disconnect -------------------------------------
		ixClient.disconnect();
		System.out.println("Disconnect Ok");
	}
	
}