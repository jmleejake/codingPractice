package global.sesoc.web5.board.vo;

public class ReplyVO {
	private int repno;
	private int bno;
	private String custid;
	private String text;
	private String create_date;
	
	private String update_date;
	private String creator_name;
	
	public int getRepno() {
		return repno;
	}
	public void setRepno(int repno) {
		this.repno = repno;
	}
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getCreator_name() {
		return creator_name;
	}
	public void setCreator_name(String creator_name) {
		this.creator_name = creator_name;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [repno=" + repno + ", bno=" + bno + ", custid=" + custid + ", text=" + text + ", create_date="
				+ create_date + ", update_date=" + update_date + ", creator_name=" + creator_name + "]";
	}
}
