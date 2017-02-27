package global.sesoc.web5.board.vo;

public class BoardVO {
	private int bno;
	private String custid;
	private String title;
	private String content;
	private int read_cnt;
	private String create_date;
	private String original_file;
	private String saved_file;
	
	private String is_hot;
	private String is_new;
	private String creator_name;
	private String update_date;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(int read_cnt) {
		this.read_cnt = read_cnt;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getOriginal_file() {
		return original_file;
	}
	public void setOriginal_file(String original_file) {
		this.original_file = original_file;
	}
	public String getSaved_file() {
		return saved_file;
	}
	public void setSaved_file(String saved_file) {
		this.saved_file = saved_file;
	}
	public String getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(String is_hot) {
		this.is_hot = is_hot;
	}
	public String getIs_new() {
		return is_new;
	}
	public void setIs_new(String is_new) {
		this.is_new = is_new;
	}
	public String getCreator_name() {
		return creator_name;
	}
	public void setCreator_name(String creator_name) {
		this.creator_name = creator_name;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", custid=" + custid + ", title=" + title + ", content=" + content
				+ ", read_cnt=" + read_cnt + ", create_date=" + create_date + ", original_file=" + original_file
				+ ", saved_file=" + saved_file + ", is_hot=" + is_hot + ", is_new=" + is_new + ", creator_name="
				+ creator_name + ", update_date=" + update_date + "]";
	}
}
