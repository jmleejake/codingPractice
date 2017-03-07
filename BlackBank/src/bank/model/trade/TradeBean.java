package bank.model.trade;


/* �Ʒ� �ΰ��� �����µ� �������̶� ������ �ֱ�
 * �ŷ��Ϸù�ȣ trdSerialNum>>trdNum, �ŷ����� trdDivision>>trdCode 
 */

public class TradeBean {
	private int trdNum;					//�ŷ���ȣ 
	private String accNum;				//���¹�ȣ
	protected int trdBalance;		//�ŷ����ܾ�
	private String trdCode;				//�ŷ��ڵ�
	private int trdMoney;				//�ŷ��ݾ�
	private String trdDate;   			//�ŷ��Ͻ�
	private int page; 				//����¡ó���� ���� ������ ����
	
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
