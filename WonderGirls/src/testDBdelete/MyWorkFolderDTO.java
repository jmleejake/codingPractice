package testDBdelete;
/**
 * jmlee 140527 HIS���� MYWORKŬ���� ���ȭ�鿡 ������ ���ٰ� �����淡���캸��
 * creator_id�� �ý��۰����ڷ� �Ǿ��־� ���α⺻���� �̶� �����ڰ� �������̴� �׷���!
 * 
 * �׸��Ͽ� �ڵ����Ͽ� update�� ġ�°��� �ξ����� �ڵ�!
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
