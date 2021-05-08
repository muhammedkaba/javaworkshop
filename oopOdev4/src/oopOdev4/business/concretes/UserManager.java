package oopOdev4.business.concretes;

import java.util.List;

import oopOdev4.business.abstracts.UserService;
import oopOdev4.core.utils.activation.ActivationService;
import oopOdev4.core.utils.authServices.AuthService;
import oopOdev4.core.utils.verification.VerifyHelper;
import oopOdev4.core.utils.verification.VerifyService;
import oopOdev4.dataAccess.abstracts.UserDao;
import oopOdev4.entities.concretes.User;
import oopOdev4.entities.dtos.UserToLoginDto;

public class UserManager implements UserService{
	
	private VerifyService verifyHelper = new VerifyHelper();
	
	private UserDao userDao;
	private ActivationService activationService;
	public UserManager(UserDao userDao, ActivationService activationService) {
		this.userDao = userDao;
		this.activationService = activationService;
	}

	@Override
	public void register(User user) {
		if(verifyHelper.verifyEmail(user.getEmail()) && verifyHelper.verifyName(user.getFirstName())
				&& verifyHelper.verifyName(user.getLastName()) && verifyHelper.verifyPassword(user.getPassword())) {
			var result = userDao.add(user);
			if(result) {
				activationService.sendActivationEmail(user);
			}
		}else {
			System.out.println("Bilgiler dogrulanamadi.");
		}
		
	}

	@Override
	public void activate(User user) {
		activationService.activate(user);
		
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void registerWithAuthService(AuthService service) {
		service.login();
	}

	@Override
	public void login(UserToLoginDto userToLoginDto) {
		if (verifyHelper.checkIfEmpty(userToLoginDto.getEmail()) || verifyHelper.checkIfEmpty(userToLoginDto.getPassword())) {
			System.out.println("Kullanici adi veya sifre bos olamaz.");
			return;
		}
		var result = userDao.login(userToLoginDto);
		if(result) {
			System.out.println("Giris yapildi : " + userToLoginDto.getEmail());
		}else {
			System.out.println("Boyle bir kullanici yok.");
		}
	}

}
