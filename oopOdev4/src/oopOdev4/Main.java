package oopOdev4;

import oopOdev4.dataAccess.concretes.HibernateUserDao;
import oopOdev4.entities.concretes.User;
import oopOdev4.entities.dtos.UserToLoginDto;
import oopOdev4.business.concretes.UserManager;
import oopOdev4.core.utils.activation.EmailActivationHelper;
import oopOdev4.core.utils.authServices.googleAuthAdapter;

public class Main {

	public static void main(String[] args) {
		
		User user = new User(1,"Muhammed","Kaba","muhammed.kaba3@gmail.com","parola");
		
		User user1 = new User(2,"Ma","Es","muhammed.kaba3@gmail.com","parola");
		
		UserManager userManager = new UserManager(new HibernateUserDao(),new EmailActivationHelper());
		
		userManager.register(user);
		userManager.activate(user);
		
		userManager.register(user1);
		
		UserToLoginDto userToLogin = new UserToLoginDto();
		userToLogin.setEmail("muhammed.kaba3@gmail.com");
		userToLogin.setPassword("parola");
		
		userManager.login(userToLogin);
		
		userManager.registerWithAuthService(new googleAuthAdapter());

	}

}
