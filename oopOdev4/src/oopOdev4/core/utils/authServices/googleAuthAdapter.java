package oopOdev4.core.utils.authServices;

import oopOdev4.googleAuthHelper.googleAuthManager;

public class googleAuthAdapter implements AuthService{

	@Override
	public void login() {
		googleAuthManager manager = new googleAuthManager();
		manager.login();
		
	}

}
