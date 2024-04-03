package singleResponsibilityPrinciple;

public class WithdrawService {
	public void withdraw(long amount,String accountNo)
	{
		System.err.println("Rupees " + amount + " has been withdrawn from account number " + accountNo +"\n");
	}

}
