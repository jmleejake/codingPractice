package bank.model.account;

import java.io.Serializable;

import bank.model.trade.TradeBean;

public class AccountBean implements Serializable{
	private String accNum;			//���¹�ȣ
	private int cltNum;				//����ȣ
	private String accPw;			//���� ��й�ȣ
	private String crtDay;			//���� ��������
	private String expDay;			//���� ������
	private String payDay;			//���� ��������
	private int balance;			//���� �ܰ�
	private String prdCode;			//��ǰ�ڵ�
	
	public AccountBean() {}
	public AccountBean(String accNum,int cltNum, String accPw, String crtDay, String expDay,
			String payDay, int balance) {
		this.accNum = accNum;		
		this.accPw = accPw;
		this.crtDay = crtDay;
		this.expDay = expDay;
		this.payDay = payDay;
		this.balance = balance;
	}
	public AccountBean(String accNum, int cltNum, String accPw, String expDay,
			String payDay, int balance, String prdCode) {
		this.accNum = accNum;
		this.cltNum = cltNum;
		this.accPw = accPw;
		this.expDay = expDay;
		this.payDay = payDay;
		this.balance = balance;
		this.prdCode = prdCode;
	}
	public AccountBean(String accNum, String accPw) {
		this.accNum = accNum;
		this.accPw = accPw;
	}	
	public AccountBean(String accNum, int balance) {
		this.accNum = accNum;
		this.balance = balance;
	}
	public AccountBean(int cltNum, String accNum){
		this.cltNum = cltNum;
		this.accNum = accNum;
	}
	
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public int getCltNum() {
		return cltNum;
	}
	public void setCltNum(int cltNum) {
		this.cltNum = cltNum;
	}
	public String getAccPw() {
		return accPw;
	}
	public void setAccPw(String accPw) {
		this.accPw = accPw;
	}
	public String getCrtDay() {
		return crtDay;
	}
	public void setCrtDay(String crtDay) {
		this.crtDay = crtDay;
	}
	public String getExpDay() {
		return expDay;
	}
	public void setExpDay(String expDay) {
		this.expDay = expDay;
	}
	public String getPayDay() {
		return payDay;
	}
	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getPrdCode() {
		return prdCode;
	}
	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountBean [accNum=");
		builder.append(accNum);
		builder.append(", cltNum=");
		builder.append(cltNum);
		builder.append(", accPw=");
		builder.append(accPw);
		builder.append(", crtDay=");
		builder.append(crtDay);
		builder.append(", expDay=");
		builder.append(expDay);
		builder.append(", payDay=");
		builder.append(payDay);
		builder.append(", balance=");
		builder.append(balance);
		builder.append("]");
		return builder.toString();
	}
}
