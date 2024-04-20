package dependencyInversionPrinciple;

import java.util.Scanner;

public class Shopping {
	private BankCards bankCard;

	public Shopping(BankCards bankCard) {
		this.bankCard=bankCard;
	}
	
	public void payment(String product,int amount)
	{
		bankCard.doPayment(product,amount);
	}
	
	public static void main(String[] args) {
		BankCards bankCards=new DebitCard();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product name : ");
		String product=scanner.next();
		System.out.println("Enter Price : ");
		int  amount=scanner.nextInt();
		
		Shopping shopping=new Shopping(bankCards);
		shopping.payment(product, amount);
		
	}

}
