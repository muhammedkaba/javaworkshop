package oopOdev4.dataAccess.abstracts;

import java.util.List;

import oopOdev4.entities.concretes.User;
import oopOdev4.entities.dtos.UserToLoginDto;

public interface UserDao {
	boolean add(User user);
	boolean login(UserToLoginDto userToLoginDto);
	List<User> getAll();
}
