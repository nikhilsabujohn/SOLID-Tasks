package singleResponsibilityPrinciple;

public class DepositService {
	public void deposit(long amount,String accountNo)
	{
		System.err.println("Rupees " + amount + " has been deposited to account number " + accountNo);
	}

}
