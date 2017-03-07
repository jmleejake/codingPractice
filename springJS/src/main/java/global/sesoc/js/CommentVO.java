package global.sesoc.js;

public class CommentVO {
	private int repno;
	private String name;
	private String text;
	private String create_date;
	
	public int getRepno() {
		return repno;
	}
	public void setRepno(int repno) {
		this.repno = repno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	@Override
	public String toString() {
		return "CommentVO [repno=" + repno + ", name=" + name + ", text=" + text + ", create_date=" + create_date + "]";
	}
	
}
