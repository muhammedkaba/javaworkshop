package oopOdev4.core.utils.activation;

import oopOdev4.entities.concretes.User;

public interface ActivationService {
	void activate(User user);
	void sendActivationEmail(User user);
}
