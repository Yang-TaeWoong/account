package account;

public class SavingAccount extends Account1 {
	protected int month;
	private double interest;
	public SavingAccount(double money,double benefit) {
		super(money);
		this.interest=benefit;
	}
	@Override
	public void debit(double money) throws Exception{
		if(month<=12){
			throw new Exception("���� ����Ҽ� �����ϴ�");
		} else if(money <= balance){
			debit(money);
		}else if(money<0){
			throw new Exception("�����Է�!");
		}
		else{
			throw new InputMismatchException();
		}
	}
	
	@Override public void credit(double money) {
		
	}
	
	@Override
	public double passTime(int month){
		if(month <= 0) return balance;

		if(this.month < 12 || this.month + month >= 12) {
			balance=balance*Math.pow((1+interest),12);
		}
		this.month+=month;
		return balance;
	}
	
	public double getWithdrawableAmount(){
		return (month < 12) ? 0 : balance;
	}
	@Override
	public String toString(){
		String str=String.format("SavingAccount_Balance : %f",balance);
		return str;
	}
}