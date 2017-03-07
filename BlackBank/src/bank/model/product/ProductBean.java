package bank.model.product;

public class ProductBean {
	private String prdCode;		//상품코드
	private String prdName;		//상품명
	private float interest;			//금리
	private String adminPw;		//admin비밀번호
	
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