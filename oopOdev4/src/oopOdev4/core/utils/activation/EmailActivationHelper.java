package oopOdev4.core.utils.activation;

import oopOdev4.entities.concretes.User;

public class EmailActivationHelper implements ActivationService{

	@Override
	public void activate(User user) {
		System.out.println("Hesabiniz dogrulandi : " + user.getEmail());
		
	}

	@Override
	public void sendActivationEmail(User user) {
		System.out.println("Aktivasyon e-postasi gonderildi : " + user.getEmail());
		
	}

}
