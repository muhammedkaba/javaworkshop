package oopOdev4.core.utils.verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyHelper implements VerifyService{
	
	private String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private Pattern pattern = Pattern.compile(regex);
	
	@Override
	public boolean verifyEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return (matcher.matches() && !email.isEmpty());
	}

	@Override
	public boolean verifyPassword(String password) {
		if (password.length() >= 6 && !password.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean verifyName(String name) {
		if (name.length() >= 2 && !name.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfEmpty(String string) {
		return string.isEmpty();
	}



}
