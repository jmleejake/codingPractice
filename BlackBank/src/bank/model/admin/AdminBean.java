package bank.model.admin;

public class AdminBean {

	private String adNum;			//�����ڹ�ȣ
	private String adId;				//������Id
	private String adPw;			//������Pw
	private String adName;		//�������̸�
	private String adRrn;			//�ֹι�ȣ
	private String adTel;			//��ȭ��ȣ
	private String adCel;			//�ڵ�����ȣ
	private String adAddr;			//�ּ�
	private String adEmail;			//�̸���
	
	public AdminBean() {}
	public AdminBean(String adNum, String adId, String adPw, String adName,
			String adRrn, String adTel, String adCel, String adAddr,
			String adEmail) {
		this.adNum = adNum;
		this.adId = adId;
		this.adPw = adPw;
		this.adName = adName;
		this.adRrn = adRrn;
		this.adTel = adTel;
		this.adCel = adCel;
		this.adAddr = adAddr;
		this.adEmail = adEmail;
	}
	public AdminBean(String adId, String adPw) {
		this.adId = adId;
		this.adPw = adPw;
	}

	public String getAdNum() {
		return adNum;
	}
	public void setAdNum(String adNum) {
		this.adNum = adNum;
	}
	public String getAdId() {
		return adId;
	}
	public void setAdId(String adId) {
		this.adId = adId;
	}
	public String getAdPw() {
		return adPw;
	}
	public void setAdPw(String adPw) {
		this.adPw = adPw;
	}
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	public String getAdRrn() {
		return adRrn;
	}
	public void setAdRrn(String adRrn) {
		this.adRrn = adRrn;
	}
	public String getAdTel() {
		return adTel;
	}
	public void setAdTel(String adTel) {
		this.adTel = adTel;
	}
	public String getAdCel() {
		return adCel;
	}
	public void setAdCel(String adCel) {
		this.adCel = adCel;
	}
	public String getAdAddr() {
		return adAddr;
	}
	public void setAdAddr(String adAddr) {
		this.adAddr = adAddr;
	}
	public String getAdEmail() {
		return adEmail;
	}
	public void setAdEmail(String adEmail) {
		this.adEmail = adEmail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminBean [adNum=");
		builder.append(adNum);
		builder.append(", adId=");
		builder.append(adId);
		builder.append(", adPw=");
		builder.append(adPw);
		builder.append(", adName=");
		builder.append(adName);
		builder.append(", adRrn=");
		builder.append(adRrn);
		builder.append(", adTel=");
		builder.append(adTel);
		builder.append(", adCel=");
		builder.append(adCel);
		builder.append(", adAddr=");
		builder.append(adAddr);
		builder.append(", adEmail=");
		builder.append(adEmail);
		builder.append("]");
		return builder.toString();
	}
}
	
