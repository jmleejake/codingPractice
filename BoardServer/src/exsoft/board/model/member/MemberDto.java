package exsoft.board.model.member;

public class MemberDto {
	private String mid;
	private String mpw;
	private String mname;
	private String mtel;
	private String mjuso;
	
	public MemberDto(){}

	public MemberDto(String mid, String mpw, String mname, String mtel,
			String mjuso) {
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mtel = mtel;
		this.mjuso = mjuso;
	}

	public MemberDto(String mid, String mpw) {
		this.mid = mid;
		this.mpw = mpw;
	}

	public MemberDto(String mpw, String mname, String mtel, String mjuso) {
		this.mpw = mpw;
		this.mname = mname;
		this.mtel = mtel;
		this.mjuso = mjuso;
	}

	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getMjuso() {
		return mjuso;
	}
	public void setMjuso(String mjuso) {
		this.mjuso = mjuso;
	}
}
