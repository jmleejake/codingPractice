package exsoft.board.model.board;


public class BoardDto {
	private int cno;
	private String ctitle;
	private String content;
	private String cday;
	private String mid;
	private String uday;
	private String fileId;
	private int position;
	private int depth;

	public BoardDto() {}
	
	public BoardDto(int cno, String ctitle, String content, String fileId) {
		this.cno = cno;
		this.ctitle = ctitle;
		this.content = content;
		this.fileId = fileId; 
	}

	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCday() {
		return cday;
	}
	public void setCday(String cday) {
		this.cday = cday;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getUday() {
		return uday;
	}
	public void setUday(String uday) {
		this.uday = uday;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
}
