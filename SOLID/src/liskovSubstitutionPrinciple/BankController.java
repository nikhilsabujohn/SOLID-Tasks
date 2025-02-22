package liskovSubstitutionPrinciple;

import java.util.Scanner;


public class BankController {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter AccountNo");
		String accno=scanner.next();
		System.out.println("Select type of account "
				+"\n"+ "1.Savings"
				+"\n"+ "2.current");
		int accType=scanner.nextInt();
		
		if(accType==1)
		{
		SavingsAccount account= new SavingsAccount();
		
		System.out.println("Services Provided"
				+"\n"+ "1.Deposit"
				+"\n"+ "2.Withdraw"
				+"\n"+ "3.Generate OTP");
		int choice=scanner.nextInt();
		switch (choice) 
		{
			case 1: 
			{
				System.out.println("Enter Amount to be deposited :");
				long amount=scanner.nextInt();
				account.deposit(amount, accno);
				break;
			}
			
			case 2: 
			{
				System.out.println("\n"+"Enter amount to be Withdraw :");
				long amount=scanner.nextInt();
				account.withdraw(amount, accno);
				break;
			}
			
			case 3:
			{
				account.sendOTP();
				break;
			}
			
			default:
			{
				System.err.println("invalid choice");
			}
			
		}

		
		
			
		}
		else if(accType==2)
		{
			CurrentAccount account=new CurrentAccount();
			System.out.println("Services Provided(as it is a current account type cant withdraw money) "
					+"\n"+ "1.Deposit"
					+"\n"+ "2.Generate OTP");
			int choice=scanner.nextInt();
			switch (choice) 
			{
				case 1: 
				{
					System.out.println("\n"+"Enter amount to be Deposited :");
					long n=scanner.nextLong();
					account.deposit(n, accno);
					break;
				}
				
				
				case 2:
				{
					account.sendOTP();
				}
				
				default:
				{
					System.err.println("invalid choice");
					break;
				}
				
			}

		}
		else
		{
			System.out.println("invalid choice");
		}

}
}
		