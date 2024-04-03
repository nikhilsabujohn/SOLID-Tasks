package openClosedPrinciple;

public class SMSNotification implements NotificationServices{

	@Override
	public void sendOTP() {
		System.out.println("SMS OTP is : "+(int)(Math.random()*100000));
		
	}

}
