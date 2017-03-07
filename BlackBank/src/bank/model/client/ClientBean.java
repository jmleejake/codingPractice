package bank.model.client;

import bank.model.account.AccountBean;


public class ClientBean {

	private int cltNum;			//고객번호
	private String cltName;		//고객이름
	private String cltRrn;			//주민번호
	private String cltTel;			//전화번호
	private String cltCel;		//핸드폰번호
	private String cltAddr;		//주소
	private String cltEmail;		//이메일
	
	
	public ClientBean() {}
	public ClientBean(int cltNum, String cltName, String cltRrn, String cltTel,
			String cltCel, String cltAddr, String cltEmail) {
		this.cltNum = cltNum;
		this.cltName = cltName;
		this.cltRrn = cltRrn;
		this.cltTel = cltTel;
		this.cltCel = cltCel;
		this.cltAddr = cltAddr;
		this.cltEmail = cltEmail;
	}
	public ClientBean(String cltName, String cltRrn, String cltTel, String cltCel,
			String cltAddr, String cltEmail) {		
		this.cltName = cltName;
		this.cltRrn = cltRrn;
		this.cltTel = cltTel;
		this.cltCel = cltCel;
		this.cltAddr = cltAddr;
		this.cltEmail = cltEmail;		
	}		
	public ClientBean(String cltTel, String cltCel, String cltAddr,
			String cltEmail, String cltRrn) {
		this.cltTel = cltTel;
		this.cltCel = cltCel;
		this.cltAddr = cltAddr;
		this.cltEmail = cltEmail;
		this.cltRrn = cltRrn;
	}	
	public ClientBean(int cltNum, String cltRrn) {
		this.cltNum = cltNum;
		this.cltRrn = cltRrn;
	}
	
	public int getCltNum() {
		return cltNum;
	}
	public void setCltNum(int cltNum) {
		this.cltNum = cltNum;
	}
	public String getCltName() {
		return cltName;
	}
	public void setCltName(String cltName) {
		this.cltName = cltName;
	}
	public String getCltRrn() {
		return cltRrn;
	}
	public void setCltRrn(String cltRrn) {
		this.cltRrn = cltRrn;
	}
	public String getCltTel() {
		return cltTel;
	}
	public void setCltTel(String cltTel) {
		this.cltTel = cltTel;
	}
	public String getCltCel() {
		return cltCel;
	}
	public void setCltCel(String cltCel) {
		this.cltCel = cltCel;
	}
	public String getCltAddr() {
		return cltAddr;
	}
	public void setCltAddr(String cltAddr) {
		this.cltAddr = cltAddr;
	}
	public String getCltEmail() {
		return cltEmail;
	}
	public void setCltEmail(String cltEmail) {
		this.cltEmail = cltEmail;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientBean [cltNum=");
		builder.append(cltNum);
		builder.append(", cltName=");
		builder.append(cltName);
		builder.append(", cltRrn=");
		builder.append(cltRrn);
		builder.append(", cltTel=");
		builder.append(cltTel);
		builder.append(", cltCel=");
		builder.append(cltCel);
		builder.append(", cltAddr=");
		builder.append(cltAddr);
		builder.append(", cltEmail=");
		builder.append(cltEmail);
		builder.append("]");
		return builder.toString();
	}
}
