package bank.model.trade;


/* 아래 두개가 빠졌는데 조원들이랑 상의후 넣기
 * 거래일련번호 trdSerialNum>>trdNum, 거래구분 trdDivision>>trdCode 
 */

public class TradeBean {
	private int trdNum;					//거래번호 
	private String accNum;				//계좌번호
	protected int trdBalance;		//거래후잔액
	private String trdCode;				//거래코드
	private int trdMoney;				//거래금액
	private String trdDate;   			//거래일시
	private int page; 				//페이징처리를 위한 정수형 변수
	
	public TradeBean() {}
	public TradeBean(int trdNum, String accNum, int trdBalance, String trdCode, int trdMoney, String trdDate) {
		this.trdNum = trdNum;
		this.accNum = accNum;
		this.trdBalance = trdBalance;
		this.trdCode = trdCode;
		this.trdMoney = trdMoney;
		this.trdDate = trdDate;
	}	
	public TradeBean(int trdNum, String accNum, int trdBalance, String trdCode,
			int trdMoney) {
		this.trdNum = trdNum;
		this.accNum = accNum;
		this.trdBalance = trdBalance;
		this.trdCode = trdCode;
		this.trdMoney = trdMoney;
	}
	public TradeBean(String accNum, int page) {
		this.accNum = accNum;
		this.page = page;
	}
	
	public int getTrdNum() {
		return trdNum;
	}
	public void setTrdNum(int trdNum) {
		this.trdNum = trdNum;
	}
	public String getAccNum() {
		return accNum;
	}	
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getTrdCode() {
		return trdCode;
	}
	public void setTrdCode(String trdCode) {
		this.trdCode = trdCode;
	}
	public int getTrdMoney() {
		return trdMoney;
	}
	public void setTrdMoney(int trdMoney) {
		this.trdMoney = trdMoney;
	}
	public String getTrdDate() {
		return trdDate;
	}
	public void setTrdDate(String trdDate) {
		this.trdDate = trdDate;
	}
	public int getTrdBalance() {
		return trdBalance;
	}
	public void setTrdBalance(int trdBalance) {
		this.trdBalance = trdBalance;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeBean [trdNum=");
		builder.append(trdNum);
		builder.append(", accNum=");
		builder.append(accNum);
		builder.append(", trdBalance=");
		builder.append(trdBalance);
		builder.append(", trdCode=");
		builder.append(trdCode);
		builder.append(", trdMoney=");
		builder.append(trdMoney);
		builder.append(", trdDate=");
		builder.append(trdDate);
		builder.append("]");
		return builder.toString();
	}
}
