package liskovSubstitutionPrinciple;

public class SavingsAccount extends Bank implements BankServices,WithdrawService{

	@Override
	public void withdraw(long amount, String accNo) {
		System.err.println("Rupees " + amount + " has been withdrawn from account number " + accNo +"\n");
		
	}
	
	@Override
	public void deposit(long amount, String accNo) {
		System.err.println("Rupees " + amount + " has been deposited to account number " + accNo);
		
	}


	@Override
	public void sendOTP() {
		int n=(int) (Math.random()*10000);
		System.err.println("OTP generated is :" +n);
	}


}
