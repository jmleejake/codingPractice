package testDBdelete;
/**
 * jmlee 140527 HIS에서 MYWORK클릭시 목록화면에 권한이 없다고 나오길래살펴보니
 * creator_id가 시스템관리자로 되어있어 개인기본권한 이라도 소유자가 관리자이니 그런것!
 * 
 * 그리하여 코딩을하여 update를 치는것이 훨씬쉬워 코딩!
 * 
 * */
public class MyWorkFolderDTO {
	private String folder_id;
	private String folder_name;
	private String creator_id;
	private String creator_name;
	
	public String getFolder_id() {
		return folder_id;
	}
	public void setFolder_id(String folder_id) {
		this.folder_id = folder_id;
	}
	public String getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}
	public String getCreator_name() {
		return creator_name;
	}
	public void setCreator_name(String creator_name) {
		this.creator_name = creator_name;
	}
	public String getFolder_name() {
		return folder_name;
	}
	public void setFolder_name(String folder_name) {
		this.folder_name = folder_name;
	}
}
