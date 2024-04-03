package singleResponsibilityPrinciple;


public class NotificationService {
		
	public void sendOTP()
	{
		int n=(int) (Math.random()*10000);
		System.err.println("OTP generated is :" +n);
	}
		
}
