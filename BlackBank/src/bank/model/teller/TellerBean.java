package bank.model.teller;

public class TellerBean {

	private String tlrNum;			//������ȣ
	private String tlrId;		//����Id
	private String tlrPw;		//����Pw
	private String tlrName;		//�����̸�
	private String tlrRrn;			//�ֹι�ȣ
	private String tlrTel;			//��ȭ��ȣ
	private String tlrCel;			//�ڵ�����ȣ
	private String tlrAddr;		//�ּ�
	private String tlrEmail;		//�̸���
	
	public TellerBean() {}
	public TellerBean(String tlrNum,String tlrId, String tlrPw, String tlrName, String tlrRrn,
			String tlrTel, String tlrCel, String tlrAddr, String tlrEmail) {
		this.tlrNum = tlrNum;
		this.tlrId = tlrId;
		this.tlrPw = tlrPw;
		this.tlrName = tlrName;
		this.tlrRrn = tlrRrn;
		this.tlrTel = tlrTel;
		this.tlrCel = tlrCel;
		this.tlrAddr = tlrAddr;
		this.tlrEmail = tlrEmail;
	}	
	public TellerBean(String tlrId, String tlrPw, String tlrName, String tlrRrn,
			String tlrTel, String tlrCel, String tlrAddr, String tlrEmail) {
		this.tlrId = tlrId;
		this.tlrPw = tlrPw;
		this.tlrName = tlrName;
		this.tlrRrn = tlrRrn;
		this.tlrTel = tlrTel;
		this.tlrCel = tlrCel;
		this.tlrAddr = tlrAddr;
		this.tlrEmail = tlrEmail;
	}	
	public TellerBean(String tlrId, String tlrPw) {		// update,logIn�� ���� ��ȸ ������
		this.tlrId = tlrId;
		this.tlrPw = tlrPw;
	}	
	public TellerBean(String tlrId, String tlrPw, String tlrTel, String tlrCel,		//update ������
			String tlrAddr, String tlrEmail) {
		this.tlrId = tlrId;
		this.tlrPw = tlrPw;
		this.tlrTel = tlrTel;
		this.tlrCel = tlrCel;
		this.tlrAddr = tlrAddr;
		this.tlrEmail = tlrEmail;
	}
	
	public String getTlrNum() {
		return tlrNum;
	}
	public void setTlrNum(String tlrNum) {
		this.tlrNum = tlrNum;
	}
	public String getTlrId() {
		return tlrId;
	}
	public void setTlrId(String tlrId) {
		this.tlrId = tlrId;
	}
	public String getTlrPw() {
		return tlrPw;
	}
	public void setTlrPw(String tlrPw) {
		this.tlrPw = tlrPw;
	}
	public String getTlrName() {
		return tlrName;
	}
	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}
	public String getTlrRrn() {
		return tlrRrn;
	}
	public void setTlrRrn(String tlrRrn) {
		this.tlrRrn = tlrRrn;
	}
	public String getTlrTel() {
		return tlrTel;
	}
	public void setTlrTel(String tlrTel) {
		this.tlrTel = tlrTel;
	}
	public String getTlrCel() {
		return tlrCel;
	}
	public void setTlrCel(String tlrCel) {
		this.tlrCel = tlrCel;
	}
	public String getTlrAddr() {
		return tlrAddr;
	}
	public void setTlrAddr(String tlrAddr) {
		this.tlrAddr = tlrAddr;
	}
	public String getTlrEmail() {
		return tlrEmail;
	}
	public void setTlrEmail(String tlrEmail) {
		this.tlrEmail = tlrEmail;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TellerBean [tlrNum=");
		builder.append(tlrNum);
		builder.append(", tlrId=");
		builder.append(tlrId);
		builder.append(", tlrPw=");
		builder.append(tlrPw);
		builder.append(", tlrName=");
		builder.append(tlrName);
		builder.append(", tlrRrn=");
		builder.append(tlrRrn);
		builder.append(", tlrTel=");
		builder.append(tlrTel);
		builder.append(", tlrCel=");
		builder.append(tlrCel);
		builder.append(", tlrAddr=");
		builder.append(tlrAddr);
		builder.append(", tlrEmail=");
		builder.append(tlrEmail);
		builder.append("]");
		return builder.toString();
	}
		
}
