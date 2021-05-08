package oopOdev4.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import oopOdev4.dataAccess.abstracts.UserDao;
import oopOdev4.entities.concretes.User;
import oopOdev4.entities.dtos.UserToLoginDto;

public class HibernateUserDao implements UserDao{
	
	private List<User> users = new ArrayList<User>();

	@Override
	public boolean add(User user) {
		for(User temp : this.users) {
			if (temp.getEmail() == user.getEmail()) {
				System.out.println("Bu e-posta kullaniliyor.");
				return false;
			}
		}
		users.add(user);
		System.out.println("Kullanici eklendi : " + user.getFirstName());
		return true;
	}
	

	@Override
	public List<User> getAll() {
		return users;
	}


	@Override
	public boolean login(UserToLoginDto userToLoginDto) {
		for(User temp : this.users) {
			if (temp.getEmail() == userToLoginDto.getEmail()) {
				return true;
			}
		}
		return false;
	}

}
