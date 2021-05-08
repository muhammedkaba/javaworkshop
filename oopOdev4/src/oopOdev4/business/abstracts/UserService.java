package oopOdev4.business.abstracts;

import java.util.List;

import oopOdev4.core.utils.authServices.AuthService;
import oopOdev4.entities.concretes.User;
import oopOdev4.entities.dtos.UserToLoginDto;

public interface UserService {
	void register(User user);
	void registerWithAuthService(AuthService service);
	void login(UserToLoginDto userToLoginDto);
	void activate(User user);
	List<User> getAll();
}
