package dependencyInversionPrinciple;

public class CreditCard implements BankCards{

	@Override
	public void doPayment(String product,int amount) {
		System.out.println("Rupees "+amount+" For "+product+" is done through CREDITCARD");
		
	}

}
