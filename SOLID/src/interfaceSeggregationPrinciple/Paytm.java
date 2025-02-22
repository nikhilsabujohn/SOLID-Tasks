package interfaceSeggregationPrinciple;

import java.util.Random;

public class Paytm implements UPIPayments,CreditManager{
	Random random=new Random();

	@Override
	public void payMoney(long amount, String phno) {
		System.out.println("Rupees "+amount+" paid to "+phno+" Via Paytm");
	}

	@Override
	public void getScratchCard() {
		
		int n=random.nextInt(1, 100);
		System.out.println("You got a Paytm Scratch Card Worth "+n);
		
	}

	@Override
	public void getCashBackAsCreditBalance() {
		
		int n=random.nextInt(100, 200);
		System.out.println("You got a Paytm Credit CashBack Worth "+n);
	}
}
