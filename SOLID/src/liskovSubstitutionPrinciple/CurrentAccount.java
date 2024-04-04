package liskovSubstitutionPrinciple;

public class CurrentAccount extends Bank implements BankServices{

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
