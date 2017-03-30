package nioTest;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class TestMainClass {

	/**
	 *  테스트메인클래스임
	 * */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 
		// windows
		//Path newDir = FileSystems.getDefault().getPath("C:/nio2/newDirectory");
		Path newDir = FileSystems.getDefault().getPath("C:\\", "nio", "newDirectory");
		createDirectoryWin(newDir);
//		deleteDirectory(newDir);
	 
		// linux
	//		Path newDir = FileSystems.getDefault().getPath("/home/falinux/nio2/newDirectory");
	//		createDirectoryLinux(newDir);
	 
	}
	 
		/**
	 * createDirectory(windows)
	 * @param newDir
	 */
	public static void createDirectoryWin(Path newDir) {
		
		System.out.println("createDirectoryWin");
		System.out.println("dir: " + newDir);
		System.out.println("isExist: " + Files.exists(newDir));
		
		try {
			if(!Files.exists(newDir)) {
				// 디렉토리 생성
				Files.createDirectory(newDir);
				System.out.println("directory create complete");
			} else {
				System.out.println("already exist");
			}
			
			if(!Files.exists(Paths.get(newDir + "/test.txt"))) {
				Files.createFile(Paths.get(newDir + "/test.txt"));
				System.out.println("file create complete");
			} else {
				System.out.println("file already exist");
			}
			
			StringBuffer data = new StringBuffer();
			
			data.append("111111\n");
			data.append("2222222222222\n");
			data.append("3333333333333333333\n");
			data.append("44444444444444444444444444444\n");
			data.append("555555555555555555555555555555555555555\n");
			data.append("6666666666666666666666666666666666666666666\n");
			
			Files.write(Paths.get(newDir + "/test.txt"), data.toString().getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
		/**
	 * createDirectory(linux)
	 * @param newDir
	 */
	public static void createDirectoryLinux(Path newDir) {
 
		// 디렉토리 권한 설정
		Set<PosixFilePermission> permis = PosixFilePermissions.fromString("rwxr-x---");
		// 파일 속성
		FileAttribute<Set<PosixFilePermission>> attrib= PosixFilePermissions.asFileAttribute(permis);
 
		try {
			// 디렉토리 생성
			Files.createDirectory(newDir, attrib);
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
		/**
	 * delete Directory
	 * @param delDir
	 */
	public static void deleteDirectory(Path delDir) {
		
		System.out.println("deleteDirectory");
		System.out.println("delDir: " + delDir);
		
		try {
			// 디렉토리 삭제
			Files.delete(delDir);
			System.out.println("delete complete");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
