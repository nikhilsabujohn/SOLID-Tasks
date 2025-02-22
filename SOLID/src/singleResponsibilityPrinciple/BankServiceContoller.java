package singleResponsibilityPrinciple;

import java.util.Scanner;

public class BankServiceContoller {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter AccountNo");
		String accno=scanner.next();
		while(true)
		{
		System.out.println("Services Provided "
				+"\n"+ "1.Deposit"
				+"\n"+ "2.Withdraw"
				+"\n"+ "3.Generate OTP"
				+"\n"+ "4.Exit");
		int choice=scanner.nextInt();

		
		switch (choice) 
		{
			case 1: 
			{
				System.out.println("\n"+"Enter amount to be Deposited :");
				long n=scanner.nextLong();
				DepositService depositService =new DepositService();
				depositService.deposit(n, accno);
				break;
			}
			
			case 2: 
			{
				System.out.println("\n"+"Enter amount to be Withdraw :");
				long n=scanner.nextLong();
				WithdrawService service=new WithdrawService();
				service.withdraw(n, accno);
				break;
			}
			
			case 3:
			{
				NotificationService notificationService=new NotificationService();
				notificationService.sendOTP();
				break;
			}
			case 4:
			{
				System.out.println("Thank you");
				System.exit(0);
			}
			
			default:
			{
				System.err.println("invalid choice");
				break;
			}
			
		}
		}
		}
		
		
	}

