package openClosedPrinciple;

import java.util.Random;

public class WhatsappNotification implements NotificationServices{

	@Override
	public void sendOTP() {
		Random random=new Random();
		int count=6;
		String otp = "";
		while(count!=0)
		{
		int n=random.nextInt(65, 90);
		char ch=(char)(n);
		otp+=ch;
		count--;
		}
		System.out.println("Your Whatsapp OTP is : "+otp);
		
	}
	

}
