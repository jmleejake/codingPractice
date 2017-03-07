package bank.model.product;

public class ProductBean {
	private String prdCode;		//��ǰ�ڵ�
	private String prdName;		//��ǰ��
	private float interest;			//�ݸ�
	private String adminPw;		//admin��й�ȣ
	
	public ProductBean() {}
	public ProductBean(String prdCode, String prdName, float interest) {
		this.prdCode = prdCode;
		this.prdName = prdName;
		this.interest = interest;
	}
	public ProductBean(String prdName, float interest) {
		this.prdName = prdName;
		this.interest = interest;
	}
	public ProductBean(String prdCode, String prdName, float interest,
			String adminPw) {
		this.prdCode = prdCode;
		this.prdName = prdName;
		this.interest = interest;
		this.adminPw = adminPw;
	}
	public ProductBean(String prdCode, String adminPw) {
		this.prdCode = prdCode;
		this.adminPw = adminPw;
	}
	
	public String getPrdCode() {
		return prdCode;
	}
	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductBean [prdCode=");
		builder.append(prdCode);
		builder.append(", prdName=");
		builder.append(prdName);
		builder.append(", interest=");
		builder.append(interest);
		builder.append(", adminPw=");
		builder.append(adminPw);
		builder.append("]");
		return builder.toString();
	}
}