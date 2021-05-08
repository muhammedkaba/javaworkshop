package oopOdev4.core.utils.verification;

public interface VerifyService {
	public boolean verifyEmail(String email);
	public boolean verifyPassword(String password);
	public boolean verifyName(String name);
	public boolean checkIfEmpty(String string);
	public boolean checkIfExists(T entity);
}
